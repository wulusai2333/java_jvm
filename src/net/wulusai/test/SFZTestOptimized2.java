package net.wulusai.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.BitSet;

/**
 * 找出所有的符合中国身份证编码规则的完全平方数
 * 优化版本：减少字符串操作，使用数学运算替代，改进负载均衡
 总计找到 123 个符合条件的完全平方数
 总耗时: 0.289 秒
 */
public class SFZTestOptimized2 {
    private static final int[] WEIGHT = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    private static final char[] CHECK_CODES = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
    
    // 完全平方数的个位数模式（位图表示）
    private static final int SQUARE_LAST_DIGIT_MASK = 
        (1 << 0) | (1 << 1) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 9);
    
    // 预计算权重模11的结果
    private static final int[] WEIGHT_MOD11 = new int[17];
    // 预计算校验码转换表（数字到字符）
    private static final char[] DIGIT_TO_CHECKCODE = new char[11];

    // 合法的年份范围
    private static final int MIN_YEAR = 1900;
    private static final int MAX_YEAR = 2025;

    // 月份对应的天数（非闰年），0索引不使用
    private static final int[] DAYS_IN_MONTH = {
        0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };
    
    // 预计算的闰年2月天数（1900-2025）
    private static final boolean[] IS_LEAP_YEAR = new boolean[2026];
    // 地址码位图（替代HashSet，提高查找性能）
    private static final BitSet REGION_CODE_BITSET = new BitSet(1_000_000);

    // 行政区划代码的最小和最大值，用于初步剪枝
    private static int MIN_REGION_CODE = Integer.MAX_VALUE;
    private static int MAX_REGION_CODE = Integer.MIN_VALUE;

    // 任务块大小 - 根据处理复杂度调整
    private static final int TASK_CHUNK_SIZE = 50000;

    // 任务队列，用于动态负载均衡
    private static LinkedBlockingQueue<TaskChunk> taskQueue;

    static {
        for (int i = 0; i < 17; i++) {
            WEIGHT_MOD11[i] = WEIGHT[i] % 11;
        }
        System.arraycopy(CHECK_CODES, 0, DIGIT_TO_CHECKCODE, 0, 11);

        for (int year = MIN_YEAR; year <= MAX_YEAR; year++) {
            IS_LEAP_YEAR[year] = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }
        // 使用BitSet替代HashSet，初始化地址码
        for (Integer code : IDCard.code) {
            REGION_CODE_BITSET.set(code);
            if (code < MIN_REGION_CODE) {
                MIN_REGION_CODE = code;
            }
            if (code > MAX_REGION_CODE) {
                MAX_REGION_CODE = code;
            }
        }
    }

    // 任务块类，用于动态任务分配
    private static class TaskChunk {
        final long start;
        final long end;

        TaskChunk(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        System.out.println("开始查找符合身份证编码规则的完全平方数...");
        System.out.println("行政区划代码范围: " + MIN_REGION_CODE + " 到 " + MAX_REGION_CODE);

        // 根据身份证号码结构，计算更精确的搜索范围
        // 最小身份证号码（理论值）：MIN_REGION_CODE + MIN_YEAR0101 + 000 + 0
        long minIdNumber = (long)MIN_REGION_CODE * 1_0000_0000_0000L // 6位行政区划码
                         + (long)MIN_YEAR * 10000 + 101 * 1000 // 8位出生日期 (19000101) + 3位顺序码 (000)
                         + 0; // 1位校验码 (0)

        // 最大身份证号码（理论值）：MAX_REGION_CODE + MAX_YEAR1231 + 999 + 10 (X)
        long maxIdNumber = (long)MAX_REGION_CODE * 1_0000_0000_0000L // 6位行政区划码
                         + (long)MAX_YEAR * 10000 + 1231 * 1000 // 8位出生日期 (20251231) + 3位顺序码 (999)
                         + 10; // 1位校验码 (X对应数字10)

        long min = minIdNumber;
        long max = maxIdNumber;

        long sqrtMin = (long) Math.ceil(Math.sqrt(min));
        long sqrtMax = (long) Math.floor(Math.sqrt(max));

        System.out.println("搜索平方根范围: " + sqrtMin + " 到 " + sqrtMax);
        System.out.println("需要检查 " + (sqrtMax - sqrtMin + 1) + " 个数字");

        // 初始化动态任务队列
        taskQueue = new LinkedBlockingQueue<>();
        long totalNumbers = sqrtMax - sqrtMin + 1;

        // 将任务分割成小块，加入任务队列
        for (long chunkStart = sqrtMin; chunkStart <= sqrtMax; chunkStart += TASK_CHUNK_SIZE) {
            long chunkEnd = Math.min(chunkStart + TASK_CHUNK_SIZE - 1, sqrtMax);
            taskQueue.add(new TaskChunk(chunkStart, chunkEnd));
        }

        System.out.println("任务分割成 " + taskQueue.size() + " 个任务块");

        // 使用多线程并行处理 - 使用动态负载均衡
        int numThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("使用 " + numThreads + " 个线程并行计算");

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        ConcurrentLinkedQueue<String> results = new ConcurrentLinkedQueue<>();
        AtomicInteger processedCount = new AtomicInteger(0);
        AtomicInteger foundCount = new AtomicInteger(0);
        AtomicLong activeThreads = new AtomicLong(numThreads);

        // 进度监控线程
        Thread progressMonitor = new Thread(() -> {
            try {
                long total = totalNumbers;
                long lastProcessed = 0;
                int checkInterval = 500000;

                while (activeThreads.get() > 0 || processedCount.get() < total) {
                    Thread.sleep(2000);
                    long current = processedCount.get();
                    if (current - lastProcessed >= checkInterval || current == total) {
                        double progress = total > 0 ? current * 100.0 / total : 0;
                        System.out.printf("进度: %.2f%% (已处理 %d 个, 找到 %d 个, 剩余任务: %d)%n",
                                progress, current, foundCount.get(), taskQueue.size());
                        lastProcessed = current;
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        progressMonitor.start();

        // 提交所有工作线程任务
        for (int i = 0; i < numThreads; i++) {
            executor.submit(() -> {
                try {
                    TaskChunk chunk;
                    while ((chunk = taskQueue.poll()) != null) {
                        processRange(chunk.start, chunk.end, results, processedCount, foundCount);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    activeThreads.decrementAndGet();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        progressMonitor.interrupt();
        progressMonitor.join();

        // 输出结果
        System.out.println("\n=== 搜索结果 ===");
        int resultCount = 0;
        for (String result : results) {
            System.out.println(result);
            resultCount++;
        }

        System.out.println("\n总计找到 " + resultCount + " 个符合条件的完全平方数");
        System.out.println("总耗时: " + (System.currentTimeMillis() - startTime) / 1000.0 + " 秒");
    }

    private static void processRange(long start, long end,
                                     ConcurrentLinkedQueue<String> results,
                                     AtomicInteger processedCount,
                                     AtomicInteger foundCount) {
        // 局部计数器，减少原子操作开销
        int localProcessed = 0;
        int localFound = 0;

        for (long i = start; i <= end; i++) {
            long square = i * i;

            // 快速检查1：完全平方数的个位数过滤（使用位运算）
            int lastDigit = (int)(square % 10);
            if ((SQUARE_LAST_DIGIT_MASK & (1 << lastDigit)) == 0) {
                localProcessed++;
                continue;
            }

            // 快速检查2：行政区划代码的早期剪枝
            long tempIdForRegion = square;
            tempIdForRegion /= 10; // 移除校验码
            tempIdForRegion /= 1000; // 移除顺序码
            tempIdForRegion /= 100_000_000L; // 移除出生日期
            int regionCode = (int)(tempIdForRegion % 1_000_000L);

            // 优化：使用BitSet的get方法替代HashSet的contains，性能更高
            if (regionCode < MIN_REGION_CODE || regionCode > MAX_REGION_CODE || !REGION_CODE_BITSET.get(regionCode)) {
                localProcessed++;
                continue;
            }

            // 快速检查3：出生日期的早期剪枝
            long tempIdForBirth = square;
            tempIdForBirth /= 10; // 移除校验码
            tempIdForBirth /= 1000; // 移除顺序码
            long birthDateNum = tempIdForBirth % 100_000_000L; // 提取出生日期 (8位)

            int day = (int)(birthDateNum % 100);
            int month = (int)((birthDateNum / 100) % 100);
            int year = (int)(birthDateNum / 10000);

            if (year < MIN_YEAR || year > MAX_YEAR || month < 1 || month > 12 || day < 1 || day > 31) {
                localProcessed++;
                continue;
            }
            // 更精确的日期检查
            if (!isValidDayMath(year, month, day)) {
                localProcessed++;
                continue;
            }

            // 完整验证身份证号码（使用数学运算，避免字符串转换）
            if (isValidIDNumberFull(square)) {
                results.add(String.format("%d (=%d * %d)", square, i, i));
                localFound++;
            }

            localProcessed++;
        }

        // 批量更新计数器，减少原子操作开销
        if (localProcessed > 0) {
            processedCount.addAndGet(localProcessed);
        }
        if (localFound > 0) {
            foundCount.addAndGet(localFound);
        }
    }

    /**
     * 完整的身份证号码验证，使用数学运算替代字符串操作
     */
    public static boolean isValidIDNumberFull(long idNumber) {
        // 1. 分解身份证号码的各个部分
        // 提取最后一位
        int checkCodeNum = (int)(idNumber % 10);
        long temp = idNumber / 10;
        
        // 提取顺序码（3位）
        int sequenceCode = (int)(temp % 1000);
        temp /= 1000;
        
        // 提取出生日期（8位）
        long birthDateNum = temp % 100_000_000L;  // 8位
        temp /= 100_000_000L;
        
        // 提取行政区划代码（6位）
        int regionCode = (int)(temp % 1_000_000L);

        // 优化：移除重复的行政区划代码检查，已在processRange中执行
        // 保留范围检查作为额外的安全网
        if (regionCode < MIN_REGION_CODE || regionCode > MAX_REGION_CODE) {
            return false;
        }

        // 2. 检查校验码
        if (!verifyCheckCodeMath(idNumber)) {
            return false;
        }
        
        // 3. 验证出生日期（使用优化的数学运算）
        if (!isValidBirthDateMath(birthDateNum)) {
            return false;
        }
        
        // 4. 验证顺序码
        if (sequenceCode < 0 || sequenceCode > 999) {
            return false;
        }
        
        return true;
    }

    /**
     * 使用数学运算验证校验码
     */
    private static boolean verifyCheckCodeMath(long idNumber) {
        long temp = idNumber / 10;  // 去掉最后一位
        int sum = 0;
        
        // 从前向后计算加权和
        for (int i = 16; i >= 0; i--) {
            int digit = (int)(temp % 10);
            // 使用预计算的模11权重
            sum += digit * WEIGHT_MOD11[i];
            temp /= 10;
        }
        
        int remainder = sum % 11;
        char expectedCheckCode = DIGIT_TO_CHECKCODE[remainder];
        
        // 获取实际校验码
        char actualCheckCode;
        int lastDigit = (int)(idNumber % 10);
        if (lastDigit == 10) {  // X的情况
            actualCheckCode = 'X';
        } else {
            actualCheckCode = (char)('0' + lastDigit);
        }
        
        return actualCheckCode == expectedCheckCode;
    }

    /**
     * 使用数学运算验证出生日期
     */
    private static boolean isValidBirthDateMath(long birthDateNum) {
        int day = (int)(birthDateNum % 100);
        birthDateNum /= 100;
        int month = (int)(birthDateNum % 100);
        int year = (int)(birthDateNum / 100);
        
        // 检查年份范围
        if (year < MIN_YEAR || year > MAX_YEAR) {
            return false;
        }
        
        // 检查月份
        if (month < 1 || month > 12) {
            return false;
        }
        
        // 检查日期
        if (day < 1 || day > 31) {
            return false;
        }
        
        // 根据月份和年份检查日期
        return isValidDayMath(year, month, day);
    }

    /**
     * 检查日期是否有效
     */
    private static boolean isValidDayMath(int year, int month, int day) {
        if (month == 2) {
            int maxDay = IS_LEAP_YEAR[year] ? 29 : 28;
            return day <= maxDay;
        }
        
        if (month >= 1 && month <= 12) {
            return day <= DAYS_IN_MONTH[month];
        }
        
        return false;
    }
}
