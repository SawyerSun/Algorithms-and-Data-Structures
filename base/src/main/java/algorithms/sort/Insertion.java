package algorithms.sort;

/**
 * 插入排序是原地并稳定的排序算法，适用于小文件。实际效率高于选择排序和冒泡排序。
 * 对于部分有序数组，插入排序需要线性运行时间。
 * 最好时间复杂度：O（n），数组为升序
 * 最坏时间复杂度：O（n^2），数组为降序
 * 平均时间复杂度：O（n^2）
 * 空间复杂度：O（1）
 * @author sunyue
 * @version 1.0    2017/1/18 14:02
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (Util.less(a[j], a[j - 1]))
                    Util.exch(a, j, i - 1);
                else break;
            }
        }
    }
}
