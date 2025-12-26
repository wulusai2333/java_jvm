package net.wulusai.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

/**
 * 找出所有的符合中国身份证编码规则的完全平方数
 * 加入完整的身份证格式校验：
 * 1. 前6位：行政区划代码（合法校验）
 * 2. 第7-14位：出生日期（合法日期）
 * 3. 第15-17位：顺序码（000-999）
 * 4. 第18位：校验码（0-9或X）
 * 总计找到 123 个符合条件的完全平方数
 * 总耗时: 32.968 秒
 */
public class SFZTestOptimized {
    private static final int[] WEIGHT = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    private static final char[] CHECK_CODES = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

    // 完全平方数的个位数只能是这些数字
    private static final int[] SQUARE_LAST_DIGITS = {0, 1, 4, 5, 6, 9};

    // 合法的年份范围（中国身份证通常为1900年至今）
    private static final int MIN_YEAR = 1900;
    private static final int MAX_YEAR = 2025;

    // 预先加载合法的行政区划代码（这里使用常见的代码）
    private static final Set<String> VALID_REGION_CODES = new HashSet<>();

    // 月份对应的天数（非闰年）
    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static {
        // 初始化一些常见的行政区划代码（实际应用中应使用完整的代码表）
        // 这里只包含部分示例代码，实际应该使用完整的行政区划代码库
        initRegionCodes();
    }

    private static void initRegionCodes() {
        // 省级行政区划代码
        IDCard.code.forEach(code -> VALID_REGION_CODES.add(String.format("%06d", code)));
        // 实际应用中应该使用完整的行政区划代码数据库
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        System.out.println("开始查找符合身份证编码规则的完全平方数...");
        System.out.println("注意：包含完整的身份证格式校验（行政区划、出生日期、顺序码、校验码）");

        long min = 100_000_000_000_000_000L;  // 10^17
        long max = 999_999_999_999_999_999L;  // 10^18 - 1

        long sqrtMin = (long) Math.ceil(Math.sqrt(min));
        long sqrtMax = (long) Math.floor(Math.sqrt(max));

        System.out.println("搜索平方根范围: " + sqrtMin + " 到 " + sqrtMax);
        System.out.println("需要检查 " + (sqrtMax - sqrtMin + 1) + " 个数字");

        // 使用多线程并行处理
        int numThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("使用 " + numThreads + " 个线程并行计算");

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        ConcurrentLinkedQueue<String> results = new ConcurrentLinkedQueue<>();
        AtomicInteger processedCount = new AtomicInteger(0);
        AtomicInteger foundCount = new AtomicInteger(0);

        // 将范围分割成多个块
        long range = sqrtMax - sqrtMin + 1;
        long chunkSize = range / numThreads;

        List<Runnable> tasks = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            final long start = sqrtMin + i * chunkSize;
            final long end = (i == numThreads - 1) ? sqrtMax : start + chunkSize - 1;

            tasks.add(() -> {
                try {
                    processRange(start, end, results, processedCount, foundCount);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        // 进度监控线程
        Thread progressMonitor = new Thread(() -> {
            try {
                long total = range;
                long lastProcessed = 0;
                int checkInterval = 500000; // 每50万报告一次进度

                while (processedCount.get() < total) {
                    Thread.sleep(2000); // 每2秒报告一次
                    long current = processedCount.get();
                    if (current - lastProcessed >= checkInterval) {
                        System.out.printf("进度: %.2f%% (已处理 %d 个, 找到 %d 个)%n",
                                current * 100.0 / total, current, foundCount.get());
                        lastProcessed = current;
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        progressMonitor.start();

        // 提交所有任务
        for (Runnable task : tasks) {
            executor.submit(task);
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

        // 预计算一些模运算加速
        int[] weightMod11 = new int[17];
        for (int i = 0; i < 17; i++) {
            weightMod11[i] = WEIGHT[i] % 11;
        }

        for (long i = start; i <= end; i++) {
            long square = i * i;

            // 快速检查：完全平方数的个位数过滤
            int lastDigit = (int)(square % 10);
            if (!isValidSquareLastDigit(lastDigit)) {
                processedCount.incrementAndGet();
                continue;
            }

            // 完整验证身份证号码
            if (isValidIDNumberFull(square)) {
                results.add(String.format("%d (=%d * %d)", square, i, i));
                foundCount.incrementAndGet();
            }

            processedCount.incrementAndGet();
        }
    }

    /**
     * 完整的身份证号码验证，包括所有格式要求
     */
    public static boolean isValidIDNumberFull(long idNumber) {
        String idStr = String.valueOf(idNumber);

        // 1. 检查长度
        if (idStr.length() != 18) {
            return false;
        }

        // 2. 检查前17位是否都是数字
        for (int i = 0; i < 17; i++) {
            if (!Character.isDigit(idStr.charAt(i))) {
                return false;
            }
        }

        // 3. 检查最后一位是否是数字或X
        char lastChar = idStr.charAt(17);
        if (!(Character.isDigit(lastChar) || lastChar == 'X')) {
            return false;
        }

        // 4. 验证校验码
        if (!verifyCheckCode(idStr)) {
            return false;
        }

        // 5. 验证行政区划代码（前6位）
        String regionCode = idStr.substring(0, 6);
        if (!isValidRegionCode(regionCode)) {
            return false;
        }

        // 6. 验证出生日期（第7-14位）
        String birthDateStr = idStr.substring(6, 14);
        if (!isValidBirthDate(birthDateStr)) {
            return false;
        }

        // 7. 验证顺序码（第15-17位）
        String sequenceCode = idStr.substring(14, 17);
        if (!isValidSequenceCode(sequenceCode)) {
            return false;
        }

        return true;
    }

    /**
     * 验证校验码
     */
    private static boolean verifyCheckCode(String idStr) {
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            int digit = idStr.charAt(i) - '0';
            sum += digit * WEIGHT[i];
        }

        int remainder = sum % 11;
        char expectedCheckCode = CHECK_CODES[remainder];
        char actualCheckCode = idStr.charAt(17);

        return actualCheckCode == expectedCheckCode;
    }

    /**
     * 验证行政区划代码
     * 注意：这里只做基本验证，实际应该使用完整的行政区划代码表
     */
    private static boolean isValidRegionCode(String regionCode) {
        // 基本规则：前2位表示省级行政区，3-4位表示地级行政区，5-6位表示县级行政区
        // 这里只验证数字范围和基本格式
        // 可以使用预先加载的合法代码集进行验证
        return VALID_REGION_CODES.contains(regionCode);
    }

    /**
     * 验证出生日期
     */
    private static boolean isValidBirthDate(String birthDateStr) {
        if (birthDateStr.length() != 8) {
            return false;
        }

        try {
            int year = Integer.parseInt(birthDateStr.substring(0, 4));
            int month = Integer.parseInt(birthDateStr.substring(4, 6));
            int day = Integer.parseInt(birthDateStr.substring(6, 8));

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

            // 根据月份和年份（考虑闰年）检查日期
            return isValidDay(year, month, day);

        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 检查日期是否有效（考虑闰年）
     */
    private static boolean isValidDay(int year, int month, int day) {
        // 处理闰年2月
        if (month == 2) {
            boolean isLeapYear = isLeapYear(year);
            int maxDay = isLeapYear ? 29 : 28;
            return day <= maxDay;
        }

        // 其他月份
        if (month >= 1 && month <= 12) {
            return day <= DAYS_IN_MONTH[month - 1];
        }

        return false;
    }

    /**
     * 判断是否为闰年
     */
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * 验证顺序码
     */
    private static boolean isValidSequenceCode(String sequenceCode) {
        // 顺序码是3位数字，范围000-999
        // 其中第17位（顺序码的第三位）奇数为男性，偶数为女性
        // 这里只验证是否为3位数字

        if (sequenceCode.length() != 3) {
            return false;
        }

        try {
            int code = Integer.parseInt(sequenceCode);
            return code >= 0 && code <= 999;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 快速检查：完全平方数的个位数只能是0,1,4,5,6,9
     */
    private static boolean isValidSquareLastDigit(int lastDigit) {
        for (int digit : SQUARE_LAST_DIGITS) {
            if (lastDigit == digit) {
                return true;
            }
        }
        return false;
    }
}
