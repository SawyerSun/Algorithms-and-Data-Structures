import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 * <p>
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * <p>
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/1 11:31
 */
public class Solution41 {
    /**
     * 初始化small=1，big=2;
     * small到big序列和小于sum，big++;大于sum，small++;
     * 当small增加到(1+sum)/2是停止
     * 运行时间：39ms
     * 占用内存：654k
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum <= 1) return res;
        int small = 1;
        int big = 2;
        while (small != (1 + sum) / 2) {
            int curSum = sumOfList(small, big);
            if (curSum == sum) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    tmp.add(i);
                }
                res.add(tmp);
                small++;
                big++;
            } else if (curSum < sum) big++;
            else small++;
        }
        return res;
    }

    private int sumOfList(int lo, int hi) {
        int sum = 0;
        for (int i = lo; i <= hi; i++) {
            sum += i;
        }
        return sum;
    }
}
