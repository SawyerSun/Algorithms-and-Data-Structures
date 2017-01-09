package Easy;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * For example,
 * Given input array nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 * <p>
 * Tags： Array， Two Pointers
 *
 * @author sunyue
 * @version 1.0    2017/1/9 20:18
 */
public class RemoveDuplicatesfromSortedArray {
    /**
     * 只是要求返回无重复数组的个数，所以并不需要真正去除。
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * Leetcode运行时间: 1 ms
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
