package Medium;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 *
 * @author sunyue
 * @version 1.0
 * @createOn 2017/9/5 22:20
 */
public class RemoveDuplicatesfromSortedArrayII {
    /**
     * In the sorted array, item arr[i] occurs more than twice if arr[i] = arr[i-2]
     * Time Complexity: O(k*n^2)
     * Space Complexity: O(n^2)
     * Runtime: 10 ms
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i++] = num;
            }
        }
        return i;
    }
}
