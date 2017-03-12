/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/12 14:30
 */
public class Solution30 {
    /**
     * 对于一个数，若前几项结果为非负，加上该数能够不小于该数，则认为当前值是有贡献的;
     * 若前几项结果为负数，则认为前几项结果没有贡献，舍去，取结果和为该数值。
     * 运行时间：36ms
     * 占用内存：654k
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;

        // max和sum不能设为0，不然数组全是负数会出错
        int max = array[0];
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (sum <= 0) {
                sum = array[i];
            } else {
                sum += array[i];
            }
            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }
}
