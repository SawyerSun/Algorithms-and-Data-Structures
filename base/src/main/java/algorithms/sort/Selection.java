package algorithms.sort;

/**
 * 选择排序是原地但不稳定的排序算法，适用于小文件，常用数值较大而键值较小的文件。
 * 最好时间复杂度：O（n）
 * 最坏时间复杂度：O（n^2）
 * 平均时间复杂度：O（n^2）
 * 空间复杂度：O（1）
 *
 * @author sunyue
 * @version 1.0    2017/1/18 13:55
 */
public class Selection {
    public static void sort(Comparable[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (Util.less(a[j], a[min])) {
                    min = j;
                }
                Util.exch(a, i, min);
            }
        }
    }
}
