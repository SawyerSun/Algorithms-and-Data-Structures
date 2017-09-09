package Easy;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 *
 * @author sunyue
 * @version 1.0
 * @createOn 2017/9/9 20:07
 */
public class RemoveDuplicatesfromSortedList {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Runtime: 1 ms
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next == null) break;
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
