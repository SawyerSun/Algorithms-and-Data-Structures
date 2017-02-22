package Medium;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 * <p>
 * <p>
 * Tags；Math, Binary Search
 *
 * @author sunyue
 * @version 1.0    2017/2/22 20:17
 */
public class DivideTwoIntegers {
    /**
     * 被除数不断减去除数的倍数，确定结果
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * Runtime: 47 ms
     */
    public int divide(int dividend, int divisor) {
        // 处理越界问题
        // （1）被除数为0
        // （2）被除数为Integer最小值，除数为-1，因为abs(Integer.MIN_VALUE) = Integer.MAX_VALUE + 1
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);
        int res = 0;
        while (longDividend >= longDivisor) {
            long temp = longDivisor;
            long multiple = 1;
            // 被除数减去除数的最大倍数，倍数从大到小
            while (longDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            longDividend -= temp;
            res += multiple;
        }
        return sign == 1 ? res : -res;
    }
}
