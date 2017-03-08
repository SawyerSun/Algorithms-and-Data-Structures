/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/8 14:33
 */
public class Solution12 {
    /**
     * 异常输入处理
     * 运行时间：40 ms
     * 占用内存：654K
     */
    public double Power(double base, int exponent) {
        double res = base;
        int abs = Math.abs(exponent);
        if (exponent == 0) {
            res = 1;
        }
        for (int i = 1; i < abs; i++) {
            res *= base;
        }
        return exponent < 0 ? 1 / res : res;
    }
}
