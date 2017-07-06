package Medium;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 *
 * @author sunyue
 * @version 1.0    2017/7/6 21:07
 */
public class RotateList {
    /**
     * 需要考虑k很大的情况
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 运行时间: 17 ms
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int len = 0;

        // 找到链尾
        while (fast.next != null) {
            len++;
            fast = fast.next;
        }

        // 找到新链头前一个
        for (int i = 0; i < len - k % len; i++) {
            slow = slow.next;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
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
