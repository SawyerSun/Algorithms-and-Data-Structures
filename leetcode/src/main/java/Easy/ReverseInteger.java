package Easy;

/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p>
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer,
 * then the reverse of 1000000003 overflows. How should you handle such cases?
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * <p>
 * Update (2014-11-10):
 * Test cases had been added to test the overflow behavior.
 * <p>
 * Tags: Math
 *
 * @author sunyue
 * @version 1.0    2017/1/3 10:08
 */
public class ReverseInteger {
    /**
     * 正负数不影响除法和求余结果，long可以避免溢出。
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * Leetcode运行时间: 2 ms
     */
    public int reverse(int x) {
        // 使用long存储返回结果，避免溢出问题
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
            if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
                res = 0;
            }
        }
        return (int) res;
    }
}
