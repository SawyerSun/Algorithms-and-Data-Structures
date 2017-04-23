/**
 * 统计一个数字在排序数组中出现的次数。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/4/23 13:19
 */
public class Solution37 {
    /**
     * 二分查找，找到第一个K和最后一个K
     * 两个二分查找复杂度都是O（log n）
     * 运行时间：30ms
     * 占用内存：629k
     */
    public int GetNumberOfK(int[] array, int k) {
        int num = 0;

        if (array != null && array.length > 0) {
            int fisrtIndex = getFirstK(array, 0, array.length - 1, k);
            int lastIndex = getLastK(array, 0, array.length - 1, k);
            if (fisrtIndex > -1 && lastIndex > -1)
                num = lastIndex - fisrtIndex + 1;
        }

        return num;
    }


    private int getFirstK(int[] array, int start, int end, int k) {
        if (start > end) return -1;

        int mid = start + (end - start >> 2);
        int midVal = array[mid];
        if (midVal == k) {
            // 若array[mid] == k，则检查是否为第一个k
            if ((mid > 0 && array[mid - 1] != k) || mid == 0) {
                return mid;
            } else {
                end = mid - 1;
            }
        } else if (midVal > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return getFirstK(array, start, end, k);
    }

    private int getLastK(int[] array, int start, int end, int k) {
        if (start > end) return -1;

        int mid = start + (end - start >> 2);
        int midVal = array[mid];
        if (midVal == k) {
            // 若array[mid] == k，则检查是否为最后一个k
            if ((mid < array.length - 1 && array[mid + 1] != k) || mid == array.length - 1) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (midVal > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return getLastK(array, start, end, k);
    }
}
