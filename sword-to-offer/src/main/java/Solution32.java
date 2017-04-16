import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/4/16 22:10
 */
public class Solution32 {
    /**
     * 将字符串拼接后比较大小
     * 运行时间：36ms
     * 占用内存：573k
     */
    public String PrintMinNumber(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, (o1, o2) -> {
            String s1 = o1 + "" + o2;
            String s2 = o2 + "" + o1;
            return s1.compareTo(s2);
        });
        for (Integer integer : list) {
            sb.append(integer);
        }
        return sb.toString();
    }
}
