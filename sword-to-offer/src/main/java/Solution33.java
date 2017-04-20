/**
 * 把只包含素因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/4/20 20:45
 */
public class Solution33 {
    /**
     * 每个丑数都是前某个丑数乘以2、3、5的结果，使用动态规划来做
     * 运行时间：29ms
     * 占用内存：654k
     */
    public static int GetUglyNumber(int index) {
        if (index < 7) return index;
        int[] res = new int[index];
        res[0] = 1;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        for (int i = 1; i < index; i++) {
            res[i] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
            if (res[i] == res[t2] * 2) t2++;
            if (res[i] == res[t3] * 3) t3++;
            if (res[i] == res[t5] * 5) t5++;
        }
        return res[index - 1];
    }
}
