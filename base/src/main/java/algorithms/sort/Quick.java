package algorithms.sort;

/**
 * 快速排序
 * todo
 * @author sunyue
 * @version 1.0    2017/1/18 10:14
 */
public class Quick {
    private static final int CUTOFF = 10;

    /**
     * 线性时间找到第K个元素
     *
     * @param a 数组
     * @param k k索引
     * @return 第k个元素
     */
    public static Comparable select(Comparable[] a, int k) {
        Util.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int j = partition(a, lo, hi);
            if (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;
            else return a[k];
        }
        return a[k];
    }

    /**
     * 排序数组
     *
     * @param a 数组
     */
    public static void sort(Comparable[] a) {
        // shuffle获得更好性能
        Util.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    /**
     * 3路划分对重复值较多的数组，性能更好。
     *
     * @param a 数组
     */
    public static void threeWaySort(Comparable[] a) {
        Util.shuffle(a);
        threeWaySort(a, 0, a.length - 1);
    }

    private static void threeWaySort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi, i = lo;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) Util.exch(a, lt++, i++);
            else if (cmp > 0) Util.exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        // 小数组使用插入排序更快
        if (hi <= lo + CUTOFF - 1) {
            Insertion.sort(a);
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi;
        while (true) {
            // 找到比划分元素小的
            while (Util.less(a[++i], a[lo])) {
                if (i == hi) break;
            }
            // 找到比划分元素大的
            while (Util.less(a[lo], a[--j])) {
                if (j == lo) break;
            }
            // 检查指针是否相遇
            if (i >= j) break;
            Util.exch(a, i, j);
        }
        Util.exch(a, lo, j);
        // 返回划分元素索引
        return j;
    }
}
