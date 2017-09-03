package Medium;

/**
 * Implement pow(x, n).
 *
 * @author sunyue
 * @version 1.0    2017/6/21 20:57
 */
public class Pow {
    /**
     * 递归解法，参考Math.pow函数说明，考虑各种异常情况，几种情况可以综合成一个表达式
     * <p>
     * 时间复杂度: O(log n)
     * 空间复杂度: O(1)
     * 运行时间：23ms
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        // 注意两种为0的情况
        if (x > 1 && n <= Integer.MIN_VALUE) return 0;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
