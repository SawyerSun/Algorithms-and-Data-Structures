package algorithms.sort;

/**
 * 希尔排序又叫缩小增量排序，是一个泛化的插入排序。
 * 希尔排序对中等大小序列非常有效。对较大的序列不是最好的选择，但是所有O（n^2）算法中最快的。
 * 最好时间复杂度：O（n），序列已经完全排序
 * 最坏时间复杂度：O（n log^2 n）
 * 平均时间复杂度：取决于间隔序列。
 * 空间复杂度：O（1）
 *
 * @author sunyue
 * @version 1.0    2017/1/18 14:10
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int len = a.length;
        int h = 1;
        while (h < len / 3) h = 3 * h + 1;
        while (h > 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && Util.less(a[j], a[j - h]); j -= h) {
                    Util.exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
