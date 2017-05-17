/**
 * 世界上有10种人，一种懂二进制，一种不懂。那么你知道两个int32整数m和n的二进制表达，有多少个位(bit)不同么？
 * 输入例子:
 * 1999 2299
 * <p>
 * 输出例子:
 * 7
 * <p>
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/17 22:04
 */
public class Solution2 {
    /**
     * 获得两个整形二进制表达位数不同的数量
     * 运行时间：34ms
     * 占用内存：479k
     *
     * @param m 整数m
     * @param n 整数n
     * @return 整型
     */
    public int countBitDiff(int m, int n) {
        // 做异或运算
        int dif = m ^ n;
        int count = 0;
        while (dif != 0) {
            // dif & （dif-1）可以消去最低位的1
            dif &= (dif - 1);
            count++;
        }
        return count;
    }
}
