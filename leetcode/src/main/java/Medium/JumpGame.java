package Medium;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * <p>
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 *
 * @author sunyue
 * @version 1.0    2017/6/25 20:17
 */
public class JumpGame {
    /**
     * 从后往前回溯，判断从当前点走相应步数，是否超过终点。
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 运行时间: 7 ms
     */
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= last) last = i;
        }
        return last <= 0;
    }
}
