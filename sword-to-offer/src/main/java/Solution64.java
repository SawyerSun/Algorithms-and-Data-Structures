import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/14 14:54
 */
public class Solution64 {
    /**
     * O(nm)解法
     * 运行时间：34ms
     * 占用内存：629k
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0) return res;
        for (int i = 0; i <= num.length - size; i++) {
            int max = 0;
            for (int j = i; j < i + size; j++) {
                if (num[j] > max) max = num[j];
            }
            res.add(max);
        }
        return res;
    }

    /**
     * 双端队列的O(n)解法
     * 运行时间：42ms
     * 占用内存：528k
     */
    public ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0) return res;
        int begin;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            if (q.isEmpty()) q.add(i);
            else if (begin > q.peekFirst()) q.pollFirst();

            while (!q.isEmpty() && num[q.peekLast()] <= num[i]) q.pollLast();
            q.add(i);
            if (begin >= 0) res.add(num[q.peekFirst()]);
        }
        return res;
    }
}
