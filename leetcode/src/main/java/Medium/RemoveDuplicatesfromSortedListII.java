package Medium;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * <p>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 *
 * @author sunyue
 * @version 1.0
 * @createOn 2017/9/9 20:44
 */
public class RemoveDuplicatesfromSortedListII {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Runtime: 1 ms
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) pre = pre.next;
            else pre.next = cur.next;
            cur = cur.next;
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
