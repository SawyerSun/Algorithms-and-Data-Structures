import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/11 22:10
 */
public class Solution29 {
    /**
     * 使用treeset存储最小的k个元素
     * 运行时间：43ms
     * 占用内存：510k
     */
    public ArrayList<Integer> GetLeastNumbers(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0 || input.length < k || k <= 0) return res;

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            set.add(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            if (set.last() > input[i]) {
                set.pollLast();
                set.add(input[i]);
            }
        }

        res.addAll(set);
        return res;
    }

    // todo 堆排序
}
