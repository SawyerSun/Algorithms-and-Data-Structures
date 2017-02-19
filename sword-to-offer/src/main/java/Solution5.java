import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0 2017/1/24 下午1:03
 */
public class Solution5 {
    // 元素从栈1出栈，进入栈2，正好从先进后去变为先进先出
    //运行时间：32ms
    //占用内存：528k
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * push直接压入栈1
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * pop是从栈2出栈元素，若栈2为空，将栈1出栈压入栈2；若栈2不为空，直接出栈。
     * @return
     */
    public int pop() {
        if (stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Stack is empty");
        }
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
