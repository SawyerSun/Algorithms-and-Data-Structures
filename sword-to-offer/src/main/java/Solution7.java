/**
 * 斐波那契数列，要求输入一个整数n，请你输出斐波那契数列的第n项。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0 2017/1/25 下午9:23
 */
public class Solution7 {
    /**
     * 复用中间结果
     * 运行时间：31ms
     * 占用内存：503k
     */
    public int Fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1 || n == 2) return 1;
        int fn1 = 1;
        int fn2 = 1;
        while (n-- > 2) {
            fn1 += fn2;
            fn2 = fn1 - fn2;
        }
        return fn1;
    }
}
