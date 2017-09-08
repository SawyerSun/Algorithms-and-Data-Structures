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
    public static void main(String[] args) {
        Solution29 s = new Solution29();
        System.out.println(s.GetLeastNumbers2(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4));
    }

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

    /**
     * array based Min-heap
     */
    public ArrayList<Integer> GetLeastNumbers2(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0 || input.length < k || k <= 0) return res;

        Heap heap = new Heap(input.length);
        for (int i = 0; i < input.length; i++) {
            heap.insert(input[i]);
        }

        for (int i = 0; i < k; i++) {
            res.add(heap.pop());
        }
        return res;
    }

    private class Heap {
        private int[] data;
        private int N;

        public Heap(int capacity) {
            data = new int[capacity + 1];
        }

        public void insert(int x) {
            data[N] = x;
            swim(N++);
        }

        public int pop() {
            int ret = data[0];
            swap(0, --N);
            sink(0);
            return ret;
        }

        private void swim(int k) {
            while (k > 0 && large((k - 1) / 2, k)) {
                swap((k - 1) / 2, k);
                k = (k - 1) / 2;
            }
        }

        private void sink(int k) {
            while ((2 * k + 1) <= N) {
                int j = 2 * k + 1;
                if (j < N & j + 1 < N && large(j, j + 1)) j++;
                if (!large(k, j)) break;
                swap(k, j);
                k = j;
            }
        }

        private boolean large(int i, int j) {
            return data[i] > data[j];
        }

        private void swap(int i, int j) {
            int t = data[i];
            data[i] = data[j];
            data[j] = t;
        }
    }
}
