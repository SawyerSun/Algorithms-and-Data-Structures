/**
 * 给定一个数组A[0,1,...,n-1],
 * 请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/7 21:02
 */
public class Solution51 {
    /**
     * 计算前i - 1个元素的乘积，及后N - i个元素的乘积分别保存在两个数组中
     * 运行时间：37ms
     * 占用内存：654k
     */
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] forward = new int[len];
        int[] backward = new int[len];
        int[] B = new int[len];
        forward[0] = 1;
        backward[0] = 1;
        for (int i = 1; i < len; i++) {
            forward[i] = A[i - 1] * forward[i - 1];
            backward[i] = A[len - i] * backward[i - 1];
        }
        for (int i = 0; i < len; i++) {
            B[i] = forward[i] * backward[len - i - 1];
        }
        return B;
    }
}
