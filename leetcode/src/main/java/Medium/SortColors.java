package Medium;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * <p>
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's,
 * then 1's and followed by 2's.
 * <p>
 * Could you come up with an one-pass algorithm using only constant space?
 *
 * @author sunyue
 * @version 1.0    2017/7/25 22:20
 */
public class SortColors {
    /**
     * Two pointer. low for 0; high for 2
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Runtime: 1 ms
     */
    public void sortColors(int[] nums) {
        if (null == nums || nums.length < 2) return;
        int low = 0;
        int high = nums.length - 1;
        for (int i = low; i <= high; ) {
            if (nums[i] == 0) {
                swap(nums, i++, low++);
            } else if (nums[i] == 2) {
                swap(nums, i, high--);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
