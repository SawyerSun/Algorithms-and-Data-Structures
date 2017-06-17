package Hard;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 Each element in the array represents your maximum jump length at that position.
 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]
 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

 Note:
 You can assume that you can always reach the last index.

 Tags: Array, Greedy

 * @author sunyue
 * @version 1.0    2017/6/17 21:36
 */
public class JumpGameII {
    /**
     * 贪心算法，在当前区域内，保存最远距离和最远端点。
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 运行时间: 11 ms
     */
    public int jump(int[] nums) {
        int curEnd = 0;
        int curFarthest = 0;
        int steps = 0;
        for (int i = 0; i < nums.length-1; i++) {
            curFarthest = Math.max(curFarthest,i+nums[i]);
            if (i == curEnd) {
                steps++;
                curEnd = curFarthest;
            }
        }
        return steps;
    }
}
