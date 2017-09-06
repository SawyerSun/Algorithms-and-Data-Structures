package Medium;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are allowed?
 * <p>
 * Would this affect the run-time complexity? How and why?
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Write a function to determine if a given target is in the array.
 * The array may contain duplicates.
 *
 * @author sunyue
 * @version 1.0
 * @createOn 2017/9/6 21:43
 */
public class SearchinRotatedSortedArrayII {
    /**
     * Binary Search and corner case
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * Runtime: 1 ms
     */
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < nums[right] || nums[mid] < nums[left]) {
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            } else if (nums[mid] > nums[left] || nums[mid] > nums[right]) {
                if (target < nums[mid] && target >= nums[left]) right = mid - 1;
                else left = mid + 1;
            } else right--;
        }
        return false;
    }
}
