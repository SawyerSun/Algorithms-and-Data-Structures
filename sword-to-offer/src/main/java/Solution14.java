/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/8 16:05
 */
public class Solution14 {
    /**
     * 两个指针，指针1先走k-1步，指针2开始走。当指针1到尾部，指针2正好到倒数第K个
     * 运行时间：33 ms
     * 占用内存：688K
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        int count = 0;
        while (p1 != null) {
            p1 = p1.next;
            count++;
            if (count > k) {
                p2 = p2.next;
            }
        }
        if (count < k) return null;
        return p2;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}


