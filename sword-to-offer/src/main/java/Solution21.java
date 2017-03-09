import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/9 10:20
 */
public class Solution21 {
    /**
     * 如果下一个出栈元素是栈顶元素，那么直接出栈；如果不是，将入栈序列中的元素入栈，直到下一个要出栈的元素在栈顶。
     * 如果所有元素入栈后，栈顶仍然不是要出栈的元素，则出栈序列是可能的。
     * 运行时间：41ms
     * 占用内存：654k
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length)
            return false;

        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        stack.push(pushA[i++]);
        while (j <= popA.length - 1) {
            while (popA[j] != stack.peek()) {
                // 入栈序列检查完毕
                if (i == pushA.length) return false;
                stack.push(pushA[i++]);
            }
            j++;
            stack.pop();
        }
        return true;
    }
}
