/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/10 20:53
 */
public class Solution55 {
    /**
     * 先找到相汇点，此时p1先走了一个换的长度，p2重新从头开始，再次相遇则为环的入口
     * 运行时间：34ms
     * 占用内存：629k
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while (p1 != null && p1.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                p2 = pHead;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                if (p1 == p2) return p1;
            }
        }
        return null;
    }
}

