package Medium;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order
 * and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * <p>
 * Linked: List, Math
 *
 * @author sunyue
 * @version 1.0    2017/1/1 13:55
 */
public class AddTwoNumbers {
    /**
     * 链表的常见解法：dummy节点作为伪头元素，帮助返回最终头结点。两个节点p和q，同时遍历两个链表，进行操作。最后还需要注意
     * 进位（carry）是否超过0，需要增加一个节点。
     * 时间复杂度 : O(max(m, n)), m、n分别为链表l1和l2的长度.
     * 空间复杂度 : O(max(m,n)). 新链表长度最大为 max(m,n) + 1.
     * Leetcode运行时间: 4 ms
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, cur = dummy;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p!=null)?p.val:0;
            int y = (q!=null)?q.val:0;
            int sum = carry + x+y;
            carry = sum/10;
            cur.next = new ListNode(sum%10);
            cur= cur.next;
            if (p!=null)p=p.next;
            if (q!=null)q=q.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
