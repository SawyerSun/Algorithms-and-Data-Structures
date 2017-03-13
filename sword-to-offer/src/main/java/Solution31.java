/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/13 14:39
 */
public class Solution31 {
    /**
     * https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6
     * 运行时间：30ms
     * 占用内存：503k
     */
    public int NumberOf1Between1AndN(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10) {
            int temp = n / m % 10 == 1 ? 1 : 0;
            ones += (n / m + 8) / 10 * m + temp * (n % m + 1);
        }
        return ones;
    }

}