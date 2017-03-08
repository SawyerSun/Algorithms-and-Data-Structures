import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0 2017/1/22 下午9:49
 */
public class Solution3 {
    /**
     * 递归解法
     * 运行时间：33ms
     * 占用内存：629k
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(res, listNode);
        return res;
    }

    private void helper(ArrayList<Integer> res, ListNode head) {
        if (head != null) {
            if (head.next != null) {
                helper(res, head.next);
            }
            res.add(head.val);
        }
    }

    /**
     * 从尾到头，即先进后出，使用栈。
     * 注意：JDK推荐使用Deque代替Stack。
     * 运行时间：35ms
     * 占用内存：654k
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
