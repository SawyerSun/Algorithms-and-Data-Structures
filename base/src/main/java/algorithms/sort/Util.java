package algorithms.sort;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author sunyue
 * @version 1.0    2017/1/18 13:52
 */
public class Util {
    /**
     * 检查数组是否为升序。
     *
     * @param a 数组
     * @return true or false
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    /**
     * 检查部分数组是否为升序。
     *
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    public static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    /**
     * 判断a是否小于b
     *
     * @param a 对象a
     * @param b 对象b
     * @return true or false
     */
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    /**
     * 判断数组索引i元素是否小于索引j元素
     *
     * @param a 数组
     * @param i 索引
     * @param j 索引
     * @return true or false
     */
    public static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    /**
     * 交换数组i和j位
     *
     * @param a 数组
     * @param i i位
     * @param j j位
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 打乱数组
     *
     * @param a 数组
     */
    public static void shuffle(Comparable[] a) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = a.length - 1; i > 0; i--) {
            int r = rnd.nextInt(i + 1);
            exch(a, i, r);
        }
    }
}
