package Easy;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * Your algorithm should use only constant space.
 * You may not modify the values in the list, only nodes itself can be changed.
 * <p>
 * Tags： Linked List
 *
 * @author sunyue
 * @version 1.0    2017/1/15 18:47
 */
public class SwapNodesinPairs {
    /**
     * 递归解法。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * Leetcode运行时间：1 ms
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = head.next;
        head.next = swapPairs(head.next.next);
        dummy.next = head;
        return dummy;
    }


    /**
     * 两个指针前后交替。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * Leetcode运行时间：1 ms
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }
}
