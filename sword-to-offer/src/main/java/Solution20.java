import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 调用min、push和pop时间都为O(1)
 * 时间限制：1秒 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/9 9:53
 */
public class Solution20 {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    /**
     * 使用辅助栈保存最小值
     * 运行时间：29ms
     * 占用内存：503k
     */
    public void push(int node) {
        dataStack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        } else {
            int min = minStack.peek();
            min = node < min ? node : min;
            minStack.push(min);
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
