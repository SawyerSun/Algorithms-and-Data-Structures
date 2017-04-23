import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 * <p>
 * 输入例子:
 * 1,2,3,4,5,6,7,0
 * 输出例子:
 * 7
 *
 * @author sunyue
 * @version 1.0    2017/4/22 15:07
 */
public class Solution35 {

    /**
     * O(n^2) 复杂度，超出时间要求
     */
    public int InversePairs(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int cur = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > cur) count++;
            }
        }
        return count;
    }

    /**
     * 参考剑指Offer，复杂度O（n log n）
     * 归并排序的改进，把数据分成前后两个数组(递归分到每个数组仅有一个数据项)，
     * 合并数组，合并时，出现前面的数组值array[i]大于后面数组值array[j]时；则前面
     * 数组array[i]~array[mid]都是大于array[j]的，count += mid+1 - i
     * 注意对1000000007求余
     * <p>
     * 运行时间：320ms
     * 占用内存：4729k
     */
    public int InversePairs2(int[] array) {
        if (array == null || array.length <= 0) return 0;
        int[] copy = Arrays.copyOf(array, array.length);
        int count = InversePairsCore(array, copy, 0, array.length - 1);
        return count;
    }

    private int InversePairsCore(int[] array, int[] copy, int lo, int hi) {
        if (lo == hi) return 0;

        // +- 优先级 高于 移位运算符 >>
        int mid = lo + (hi - lo >> 1);

        int leftCount = InversePairsCore(array, copy, lo, mid) % 1000000007;
        int rightCount = InversePairsCore(array, copy, mid + 1, hi) % 1000000007;

        int count = 0;
        int i = mid;
        int j = hi;
        int copyIndex = hi;
        while (i >= lo && j >= mid + 1) {
            // 左边最大 > 右边最大，则array[i]可以和右边数字组成逆序对
            if (array[i] > array[j]) {
                count += (j - mid);
                if (count >= 1000000007) count %= 1000000007;
                copy[copyIndex--] = array[i--];
            } else {
                copy[copyIndex--] = array[j--];
            }
        }
        // 复制剩余数字
        while (i >= lo) {
            copy[copyIndex--] = array[i--];
        }
        while (j >= mid + 1) {
            copy[copyIndex--] = array[j--];
        }
        // 将排序过来的复制回原数组
        for (int k = lo; k <= hi; k++) {
            array[k] = copy[k];
        }
        return (leftCount + rightCount + count) % 1000000007;
    }
}
