package net.wulusai.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 找出所有的符合中国身份证编码规则的完全平方数
 * 优化版本：使用预计算和更高效的算法
 * 总计找到 123 个符合条件的完全平方数
 * 总耗时: 9.411 秒
 */
public class SFZTestOptimized3 {
    private static final int[] WEIGHT = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    private static final char[] CHECK_CODES = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

    // 完全平方数的个位数模式（位图表示）
    private static final int SQUARE_LAST_DIGIT_MASK =
            (1 << 0) | (1 << 1) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 9);

    // 预计算权重与数字组合的结果（模11）
    private static final int[][] WEIGHTED_DIGIT_MOD11 = new int[10][17];

    // 预计算校验码转换表
    private static final char[] DIGIT_TO_CHECKCODE = new char[11];

    // 合法的年份范围
    private static final int MIN_YEAR = 1900;
    private static final int MAX_YEAR = 2025;

    // 预计算的闰年标志和日期有效性
    private static final boolean[] IS_LEAP_YEAR = new boolean[2026];

    // 预计算所有有效日期（从1900-01-01到2025-12-31）
    private static final Set<Integer> VALID_DATES = new HashSet<>();

    // 地址码集合和范围
    private static final Set<Integer> ADDRESS_CODES = new HashSet<>();
    private static int MIN_REGION_CODE = Integer.MAX_VALUE;
    private static int MAX_REGION_CODE = Integer.MIN_VALUE;

    // 预计算平方数的个位数模式检查表
    private static final boolean[] VALID_LAST_DIGIT = new boolean[10];

    // 线程池配置
    private static final int NUM_THREADS = Runtime.getRuntime().availableProcessors();
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUM_THREADS);

    static {
        // 初始化预计算表
        for (int digit = 0; digit < 10; digit++) {
            for (int i = 0; i < 17; i++) {
                WEIGHTED_DIGIT_MOD11[digit][i] = (digit * WEIGHT[i]) % 11;
            }
        }

        System.arraycopy(CHECK_CODES, 0, DIGIT_TO_CHECKCODE, 0, 11);

        // 初始化闰年表
        for (int year = MIN_YEAR; year <= MAX_YEAR; year++) {
            IS_LEAP_YEAR[year] = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }

        // 初始化有效日期表
        initializeValidDates();

        // 初始化地址码
        ADDRESS_CODES.addAll(IDCard.code);
        for (Integer code : ADDRESS_CODES) {
            if (code < MIN_REGION_CODE) MIN_REGION_CODE = code;
            if (code > MAX_REGION_CODE) MAX_REGION_CODE = code;
        }

        // 初始化个位数检查表
        for (int i = 0; i < 10; i++) {
            VALID_LAST_DIGIT[i] = (SQUARE_LAST_DIGIT_MASK & (1 << i)) != 0;
        }
    }

    private static void initializeValidDates() {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int year = MIN_YEAR; year <= MAX_YEAR; year++) {
            boolean isLeap = IS_LEAP_YEAR[year];
            for (int month = 1; month <= 12; month++) {
                int maxDay = daysInMonth[month - 1];
                if (month == 2 && isLeap) {
                    maxDay = 29;
                }
                for (int day = 1; day <= maxDay; day++) {
                    int date = year * 10000 + month * 100 + day;
                    VALID_DATES.add(date);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        System.out.println("开始查找符合身份证编码规则的完全平方数...");
        System.out.println("行政区划代码范围: " + MIN_REGION_CODE + " 到 " + MAX_REGION_CODE);
        System.out.println("使用 " + NUM_THREADS + " 个线程并行计算");

        // 计算搜索范围
        long minId = (long)MIN_REGION_CODE * 1_0000_0000_0000L + MIN_YEAR * 10000L + 101 * 1000L;
        long maxId = (long)MAX_REGION_CODE * 1_0000_0000_0000L + MAX_YEAR * 10000L + 1231 * 1000L + 10;

        long sqrtMin = (long) Math.ceil(Math.sqrt(minId));
        long sqrtMax = (long) Math.floor(Math.sqrt(maxId));

        System.out.println("搜索平方根范围: " + sqrtMin + " 到 " + sqrtMax);
        System.out.println("需要检查 " + (sqrtMax - sqrtMin + 1) + " 个数字");

        // 使用工作窃取线程池提高并行效率
        ExecutorService executor = Executors.newWorkStealingPool(NUM_THREADS);
        ConcurrentLinkedQueue<String> results = new ConcurrentLinkedQueue<>();
        AtomicInteger processedCount = new AtomicInteger(0);
        AtomicInteger foundCount = new AtomicInteger(0);

        // 计算任务块大小（优化为2的幂次，便于CPU缓存）
        long range = sqrtMax - sqrtMin + 1;
        long chunkSize = Math.max(range / (NUM_THREADS * 4), 1000000);

        List<Runnable> tasks = new ArrayList<>();
        for (long start = sqrtMin; start <= sqrtMax; start += chunkSize) {
            final long chunkStart = start;
            final long chunkEnd = Math.min(start + chunkSize - 1, sqrtMax);

            tasks.add(() -> {
                processChunk(chunkStart, chunkEnd, results, processedCount, foundCount);
            });
        }

        // 进度监控
        Thread progressMonitor = new Thread(() -> {
            try {
                long total = range;
                long lastProcessed = 0;
                long lastTime = System.currentTimeMillis();

                while (processedCount.get() < total) {
                    Thread.sleep(1000);
                    long current = processedCount.get();
                    long now = System.currentTimeMillis();

                    if (current > lastProcessed) {
                        double speed = (current - lastProcessed) * 1000.0 / (now - lastTime);
                        System.out.printf("进度: %.2f%% | 速度: %.0f 个/秒 | 已找到: %d 个%n",
                                current * 100.0 / total, speed, foundCount.get());
                        lastProcessed = current;
                        lastTime = now;
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        progressMonitor.start();

        // 提交所有任务
        tasks.forEach(executor::submit);

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        progressMonitor.interrupt();
        progressMonitor.join();

        // 输出结果
        System.out.println("\n=== 搜索结果 ===");
        List<String> sortedResults = new ArrayList<>(results);
        Collections.sort(sortedResults);

        int resultCount = 0;
        for (String result : sortedResults) {
            System.out.println(result);
            resultCount++;
        }

        System.out.println("\n总计找到 " + resultCount + " 个符合条件的完全平方数");
        System.out.println("总耗时: " + (System.currentTimeMillis() - startTime) / 1000.0 + " 秒");

        EXECUTOR.shutdown();
    }

    private static void processChunk(long start, long end,
                                     ConcurrentLinkedQueue<String> results,
                                     AtomicInteger processedCount,
                                     AtomicInteger foundCount) {

        // 使用局部变量减少内存访问开销
        Set<Integer> localAddressCodes = ADDRESS_CODES;
        Set<Integer> localValidDates = VALID_DATES;
        boolean[] localValidLastDigit = VALID_LAST_DIGIT;

        for (long i = start; i <= end; i++) {
            long square = i * i;

            // 快速检查1：完全平方数的个位数过滤
            int lastDigit = (int)(square % 10);
            if (!localValidLastDigit[lastDigit]) {
                processedCount.incrementAndGet();
                continue;
            }

            // 一次性提取所有需要的部分（避免多次除法和取模）
            long temp = square;
            int checkCodeNum = (int)(temp % 10);      // 校验码数字
            temp /= 10;
            int sequenceCode = (int)(temp % 1000);    // 顺序码
            temp /= 1000;
            int birthDateNum = (int)(temp % 100_000_000); // 出生日期
            temp /= 100_000_000;
            int regionCode = (int)(temp % 1_000_000);    // 行政区划代码

            // 快速检查2：行政区划代码
            if (!localAddressCodes.contains(regionCode)) {
                processedCount.incrementAndGet();
                continue;
            }

            // 快速检查3：出生日期（使用预计算的有效日期集合）
            if (!localValidDates.contains(birthDateNum)) {
                processedCount.incrementAndGet();
                continue;
            }

            // 快速检查4：顺序码范围
            if (sequenceCode < 0 || sequenceCode > 999) {
                processedCount.incrementAndGet();
                continue;
            }

            // 完整验证：校验码
            if (verifyCheckCodeOptimized(square, regionCode, birthDateNum, sequenceCode, checkCodeNum)) {
                results.add(String.format("%d (=%d * %d)", square, i, i));
                foundCount.incrementAndGet();
            }

            processedCount.incrementAndGet();
        }
    }

    /**
     * 优化的校验码验证
     */
    private static boolean verifyCheckCodeOptimized(long idNumber,
                                                    int regionCode,
                                                    int birthDateNum,
                                                    int sequenceCode,
                                                    int checkCodeNum) {

        // 使用预计算的加权模11表
        int sum = 0;

        // 处理地区码（6位）
        int tempCode = regionCode;
        for (int i = 5; i >= 0; i--) {
            int digit = tempCode % 10;
            sum += WEIGHTED_DIGIT_MOD11[digit][i];
            tempCode /= 10;
        }

        // 处理出生日期（8位）
        tempCode = birthDateNum;
        for (int i = 13; i >= 6; i--) {
            int digit = tempCode % 10;
            sum += WEIGHTED_DIGIT_MOD11[digit][i];
            tempCode /= 10;
        }

        // 处理顺序码（3位）
        tempCode = sequenceCode;
        for (int i = 16; i >= 14; i--) {
            int digit = tempCode % 10;
            sum += WEIGHTED_DIGIT_MOD11[digit][i];
            tempCode /= 10;
        }

        int remainder = sum % 11;
        char expectedCheckCode = DIGIT_TO_CHECKCODE[remainder];

        // 获取实际校验码
        char actualCheckCode;
        if (checkCodeNum == 10) {
            actualCheckCode = 'X';
        } else {
            actualCheckCode = (char)('0' + checkCodeNum);
        }

        return actualCheckCode == expectedCheckCode;
    }


}
