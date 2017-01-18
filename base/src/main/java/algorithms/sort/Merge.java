package algorithms.sort;

/**
 * 归并排序是稳定的排序算法，是分治法的一个实例。
 * 最好时间复杂度：O（n log n）
 * 最坏时间复杂度：O（n log n）
 * 平均时间复杂度：O（n log n）
 * 空间复杂度：O（n）
 *
 * @author sunyue
 * @version 1.0    2017/1/18 15:11
 */
public class Merge {
    private static final int CUTOFF = 7;

    /**
     * 标准归并排序
     * @param a
     */
    public static void sort(Comparable[] a) {
        sort(a, new Comparable[a.length], 0, a.length - 1);
    }

    /**
     * 自下而上的非递归归并排序，比自上而下的递归归并排序慢10%
     * @param a
     */
    public static void bottomUpSort(Comparable[] a) {
        int len = a.length;
        Comparable[] aux = new Comparable[len];
        for (int sz = 1; sz < len; sz = sz + sz) {
            for (int lo = 0; lo < len - sz; lo += sz + sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, len - 1));
            }
        }
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        // 小数组使用插入排序更快
        if (hi <= lo + CUTOFF - 1) {
            Insertion.sort(a);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        // 如果已经有序，可以提前终止
        if (!Util.less(a[mid + 1], a[mid])) return;
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert Util.isSorted(a, lo, mid);
        assert Util.isSorted(a, mid + 1, hi);

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (Util.less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }

        assert Util.isSorted(a, lo, hi);
    }
}
