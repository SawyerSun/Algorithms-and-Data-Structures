package Easy;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 * which is more subtle.
 *
 * @author sunyue
 * @version 1.0    2017/6/23 21:10
 */
public class MaximumSubarray {
    /**
     * 动态规划。
     * maxSubArray(A, i) = A[i] + maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0;
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 运行时间：16 ms
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
