/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0 2017/1/25 下午9:31
 */
public class Solution8 {
    /**
     * 也是斐波那契数列
     * 运行时间：690ms
     * 占用内存：654k
     */
    public int JumpFloor(int target) {
        if (target <= 0) return -1;
        else if (target == 1) return 1;
        else if (target == 2) return 2;
        else return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
}
