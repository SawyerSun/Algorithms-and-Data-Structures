import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/13 21:00
 */
public class Solution63 {
    // 计数器
    private int count;
    // PriorityQueue默认内部是自然排序，结果为小顶堆，
    private Queue<Integer> minHeap = new PriorityQueue<>();
    // PriorityQueue也可以自定义排序器，反转比较，完成大顶堆。
    private Queue<Integer> maxHeap = new PriorityQueue<>(11, Comparator.reverseOrder());

    /**
     * 使用大顶堆和小顶堆满足时间效率，且满足：
     * 1. 两个堆中数目差不超过1
     * 2. 大顶堆所有数据　小于　小顶堆
     * 　运行时间：39ms
     * 占用内存：525k
     */
    public void Insert(Integer num) {
        count++;
        // 偶数
        if ((count & 1) == 0) {
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        double res = -0.0;
        if ((count & 1) == 1) res = maxHeap.peek();
        else res = (minHeap.peek() + maxHeap.peek()) / 2.0;
        return res;
    }
}
