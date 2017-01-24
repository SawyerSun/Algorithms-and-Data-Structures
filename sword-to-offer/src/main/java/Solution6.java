/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 时间限制：3秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0 2017/1/24 下午1:46
 */
public class Solution6 {
    /**
     * 二分查找，复杂度O（log N）
     * 运行时间：147ms
     * 占用内存：3042k
     */
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;

        int left = 0, right = array.length - 1, mid = 0;
        // 确保旋转了
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = left + (right - left) / 2;
            // 三者相等无法确定
            if (array[left] == array[right] && array[left] == array[mid]) {
                return min(array, left, right);
            }
            // 左边非递减，最小值在右边
            if (array[mid] >= array[left]) left = mid;
            else right = mid;
        }
        return array[mid];
    }

    private int min(int[] array, int left, int right) {
        int res = array[left];
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < res) res = array[i];
        }
        return res;
    }

    /**
     * 顺序查找，复杂度O（N）
     * 运行时间：157ms
     * 占用内存：4114k
     */
    public int minNumberInRotateArray2(int[] array) {
        if (array.length == 0) return 0;

        // 前半部分旋转，只要找到比前一元素小的即可。
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i + 1]) return array[i + 1];
        }
        // 完全旋转，最小值就是第一个元素。
        return array[0];
    }
}
