package net.wulusai.test;

/**
 * 找出所有的符合中国身份证编码规则的完全平方数 * 身份证号码由18位数字组成，其中前17位为数字，最后一位可以是数字或字母X
 * 完全平方数是指某个整数的平方
 * 输出所有符合中国身份证编码规则的完全平方数
 */
public class SFZTest {
    // 加权因子数组，用于计算校验码
    private static final int[] WEIGHT = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    // 校验码映射表，根据余数确定校验码
    private static final char[] CHECK_CODES = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

    public static void main(String[] args) {
        System.out.println("正在查找符合中国身份证编码规则的完全平方数...");
        long startTime = System.currentTimeMillis();
        // 18位数字的范围是：10^17 到 10^18-1
        // 即：100000000000000000 到 999999999999999999
        long min = 100000000000000000L;
        long max = 999999999999999999L;

        // 计算平方根的范围
        long sqrtMin = (long) Math.ceil(Math.sqrt(min));
        long sqrtMax = (long) Math.floor(Math.sqrt(max));

        System.out.println("搜索范围: " + sqrtMin + " 到 " + sqrtMax);
        System.out.println("大约需要检查 " + (sqrtMax - sqrtMin + 1) + " 个数字的平方");

        int count = 0;

        // 优化：完全平方数的个位数只能是 0, 1, 4, 5, 6, 9
        // 但身份证校验码的规则是基于前17位计算的，不是简单的个位数
        // 所以我们无法通过完全平方数的个位数特性来过滤

        // 进一步优化：我们先检查身份证校验码的计算规则
        // 身份证号前17位加权求和后对11取模，结果决定最后一位校验码
        // 但这个优化比较复杂，因为平方运算与模运算不直接相关

        // 现在采用更简单的优化：批量处理和进度报告
        long checkInterval = 1000000; // 每处理100万个数字报告一次进度
        long nextReport = sqrtMin + checkInterval;

        for (long i = sqrtMin; i <= sqrtMax; i++) {
            long square = i * i;
            if (square >= min && square <= max) {
                // 检查这个18位数字是否符合身份证校验规则
                if (isValidIDNumberOptimized(square)) {
                    //System.out.println(square + " (=" + i + " * " + i + ")");
                    count++;
                }
            }

            // 进度报告
            if (i >= nextReport) {
                System.out.println("已处理到: " + i + ", 进度: " + String.format("%.2f%%",
                    (double)(i - sqrtMin) / (sqrtMax - sqrtMin) * 100));
                nextReport += checkInterval;
            }
        }

        if (count == 0) {
            System.out.println("没有找到符合身份证编码规则的完全平方数。");
        } else {
            System.out.println("总共找到 " + count + " 个符合身份证编码规则的完全平方数。");
        }
        System.out.println("总耗时: " + (System.currentTimeMillis() - startTime) / 1000.0 + " 秒");
    }

    /**
     * 验证身份证号码是否符合编码规则（优化版本，直接处理long类型）
     * @param idNumber 身份证号码long值
     * @return 是否符合规则
     */
    public static boolean isValidIDNumberOptimized(long idNumber) {
        // 将long转换为字符串以获取各位数字
        String idStr = String.valueOf(idNumber);
        if (idStr.length() != 18) {
            return false;
        }

        // 检查前17位是否都是数字
        for (int i = 0; i < 17; i++) {
            if (!Character.isDigit(idStr.charAt(i))) {
                return false;
            }
        }

        // 检查最后一位是否是数字或X
        char lastChar = idStr.charAt(17);
        if (!(Character.isDigit(lastChar) || lastChar == 'X')) {
            return false;
        }

        // 计算前17位数字的加权和
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            int digit = idStr.charAt(i) - '0';
            sum += digit * WEIGHT[i];
        }

        // 计算余数
        int remainder = sum % 11;

        // 根据余数获取对应的校验码
        char expectedCheckCode = CHECK_CODES[remainder];

        // 比较计算出的校验码与实际的校验码
        return lastChar == expectedCheckCode;
    }
}
