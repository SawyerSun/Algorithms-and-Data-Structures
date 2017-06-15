package Hard;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p>
 * Your algorithm should run in O(n) time and uses constant space.
 * <p>
 * Tags: Array
 *
 * @author sunyue
 * @version 1.0    2017/6/8 21:33
 */
public class FirstMissingPositive {
    /**
     * 将所有正整数放置在其应该在的位置
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 运行时间: 12 ms
     */
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) i++;
                // 若nums[i]-1位置上数字不等于nums[i],交换
            else if (nums[nums[i] - 1] != nums[i]) swap(nums, i, nums[i] - 1);
            else i++;
        }
        // 二次遍历，找到缺失的值
        i = 0;
        while (i < nums.length && nums[i] == i + 1) i++;
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
