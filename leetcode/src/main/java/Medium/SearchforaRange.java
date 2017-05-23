package Medium;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * <p>
 * Tags: Binary Search, Array
 *
 * @author sunyue
 * @version 1.0    2017/5/23 20:30
 */
public class SearchforaRange {
    private int firstGreaterEqual(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    /**
     * 二分搜索找到第一个等于target的 和第一个大于target的
     * 时间复杂度 O(log n)
     * 空间复杂度 O（1）
     * Leetcode运行时间: 9 ms
     */
    public int[] searchRange(int[] nums, int target) {
        int start = firstGreaterEqual(nums, target);
        if (start == nums.length || nums[start] != target) return new int[]{-1, -1};
        return new int[]{start, firstGreaterEqual(nums, target + 1) - 1};

    }
}
