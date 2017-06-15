package Hard;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * <p>
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Tags: Linked List
 *
 * @author sunyue
 * @version 1.0    2017/1/16 22:24
 */
public class ReverseNodesinkGroup {
    /**
     * 递归解法。先找到k+1，逆转前k个，递归逆转后部分。
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 运行时间: 7 ms
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        // 找到 第 k+1 node
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            // 以k+1 node为头结点逆转list
            cur = reverseKGroup(cur, k);
            // 逆 前 K 个 node
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }
}
