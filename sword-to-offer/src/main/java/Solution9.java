/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0 2017/1/25 下午9:35
 */
public class Solution9 {

    /**
     * 总结规律，规约等式：
     * f(n) = 2*f(n-1),(n>=2)
     * 运行时间：36ms
     * 占用内存：654k
     */
    public int JumpFloorII(int target) {
        if (target <= 0) return -1;
        else if (target == 1) return 1;
        else return 2 * JumpFloorII(target - 1);
    }
}
