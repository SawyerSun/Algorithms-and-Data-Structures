/**
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/3 21:18
 */
public class Solution47 {
    /**
     * 用逻辑与的短路特性实现递归终止
     * 运行时间：35ms
     * 占用内存：654k
     */
    public int Sum(int n) {
        int res = n;
        boolean b = (res > 0) && (res += Sum(n - 1)) > 0;
        return res;
    }
}
