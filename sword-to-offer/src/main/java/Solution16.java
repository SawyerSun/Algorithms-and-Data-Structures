/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/8 16:43
 */
public class Solution16 {
    /**
     * 递归解法
     * 运行时间：39 ms
     * 占用内存：503K
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = null;
        if (list1.val <= list2.val) {
            head = list1;
            head.next = Merge(list1.next, list2);
        } else {
            head = list2;
            head.next = Merge(list1, list2.next);
        }
        return head;
    }

    /**
     * 非递归解法
     * 运行时间：45 ms
     * 占用内存：654K
     */
    public ListNode Merge2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = null;
        ListNode cur = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (head == null) {
                    head = cur = list1;
                } else {
                    cur.next = list1;
                    cur = cur.next;
                }
                list1 = list1.next;
            } else {
                if (head == null) {
                    head = cur = list2;
                } else {
                    cur.next = list2;
                    cur = cur.next;
                }
                list2 = list2.next;
            }
        }

        if (list1 == null) cur.next = list2;
        if (list2 == null) cur.next = list1;
        return head;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
