/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/8 14:03
 */
public class Solution11 {
    /**
     * 把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
     * 运行时间：30 ms
     * 占用内存：503K
     */
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
