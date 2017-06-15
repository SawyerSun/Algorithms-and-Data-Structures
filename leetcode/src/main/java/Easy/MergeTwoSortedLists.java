package Easy;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together
 * the nodes of the first two lists.
 * <p>
 * Tags： Linked List
 *
 * @author sunyue
 * @version 1.0    2017/1/14 14:10
 */
public class MergeTwoSortedLists {
    /**
     * 递归解法，但不是尾递归，当列表太长会出现栈溢出。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 运行时间：1ms
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
