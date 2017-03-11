/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/10 17:11
 */
public class Solution28 {

    /**
     * 根据数组特点，有个数字出现次数比其它次数的和还多
     * 运行时间：36ms
     * 占用内存：503k
     */
    public int MoreThanHalfNum(int[] array) {
        if (array == null || array.length == 0) return 0;

        int res = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            // 次数为0 取下一个数字
            // 相同次数+1，不同次数-1
            if (times == 0) {
                res = array[i];
                times = 1;
            } else if (array[i] == res) {
                times++;
            } else {
                times--;
            }
        }

        times = 0;
        for (int i = 0; i < array.length; i++) {
            if (res == array[i]) {
                times++;
            }
        }
        if (times <= array.length / 2) {
            return 0;
        }
        return res;
    }
}
