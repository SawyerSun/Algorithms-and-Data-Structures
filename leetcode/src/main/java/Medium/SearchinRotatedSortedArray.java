package Medium;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * <p>
 * Tags: Binary Search, Array
 *
 * @author sunyue
 * @version 1.0    2017/3/1 22:06
 */
public class SearchinRotatedSortedArray {
    /**
     * 二分查找
     * 时间复杂度：O(log n)
     * 空间复杂度： O(1)
     * Runtime: 15 ms
     */
    public int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 旋转点在后一半，前一半递增
            if (nums[lo] <= nums[mid]) {
                // target在前一半
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return nums[lo] == target ? lo : -1;
    }
}
