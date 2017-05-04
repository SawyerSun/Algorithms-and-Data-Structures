import java.util.HashMap;
import java.util.Map;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/4 13:03
 */
public class Solution50 {
    /**
     * 运行时间：44ms
     * 占用内存：654k
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length == 0) {
            duplication[0] = -1;
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : numbers) {
            if (map.containsKey(i)) {
                duplication[0] = i;
                return true;
            } else {
                map.put(i, 1);
            }
        }
        return false;
    }
}
