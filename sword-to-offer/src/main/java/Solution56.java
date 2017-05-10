/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * @author sunyue
 * @version 1.0    2017/5/10 21:10
 */
public class Solution56 {
    /**
     * 运行时间：37ms
     * 占用内存：654k
     */
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode p = pHead;
        ListNode pre = dummy;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                // 找到最后一个重复的节点
                while (p != null && p.val == val) {
                    p = p.next;
                }
                pre.next = p;
            } else {
                pre = p;
                p = p.next;
            }
        }
        return dummy.next;
    }
}
