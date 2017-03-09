/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/8 16:23
 */
public class Solution15 {
    /**
     * 递归解法
     * 运行时间：34 ms
     * 占用内存：528K
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return dummy;
    }

    /**
     * 非递归解法
     * 运行时间：37 ms
     * 占用内存：654K
     */
    public ListNode ReverseList2(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode prev = null;
        ListNode dummy = null;

        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) dummy = cur;

            // 反转
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return dummy;
    }
}
