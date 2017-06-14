package Medium;

import java.util.Arrays;

/**
 * @author sunyue
 * @version 1.0    2017/1/7 19:42
 */
public class ThreeSumClosest {
    /**
     * 两个指针同时遍历。
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     * 运行时间: 15 ms
     */
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
