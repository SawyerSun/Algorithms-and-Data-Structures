/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/8 14:18
 */
public class Solution13 {
    /**
     * 空间换时间，O（3n）解法
     * 运行时间：32 ms
     * 占用内存：654K
     */
    public void reOrderArray(int[] array) {
        int[] res = new int[array.length];
        int oddBegin = 0;
        int oddCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                oddCount++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                res[oddBegin++] = array[i];
            } else {
                res[oddCount++] = array[i];
            }
        }
        for (int i = 0; i < res.length; i++) {
            array[i] = res[i];
        }
    }
}
