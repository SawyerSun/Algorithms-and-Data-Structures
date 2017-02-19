/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0 2017/1/25 下午9:55
 */
public class Solution10 {
    /**
     * 依旧是斐波那契数列
     * 运行时间：647ms
     * 占用内存：654k
     */
    public int RectCover(int target) {
        if (target <= 0) return 0;
        else if (target == 1 || target == 2) return target;
        else return RectCover(target - 1) + RectCover(target - 2);
    }
}
