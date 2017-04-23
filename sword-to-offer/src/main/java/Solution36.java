/**
 * 输入两个链表，找出它们的第一个公共结点。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/4/23 11:46
 */
public class Solution36 {
    /**
     * 两个链表有公共结点一定是Y字形，则从后往前找最后一个相同的结点，就是第一个公共结点
     * 遍历两个链表得到长度，第二次遍历，较长的先走若干步，然后两个链表一起走，找到第一个相同结点
     * 时间复杂度O（n）
     * 运行时间：40ms
     * 占用内存：654k
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = getLengthOfList(pHead1);
        int len2 = getLengthOfList(pHead2);
        int lenDiff = Math.abs(len1 - len2);

        ListNode longHead = pHead1;
        ListNode shortHead = pHead2;
        if (len2 > len1) {
            longHead = pHead2;
            shortHead = pHead1;
        }

        for (int i = 0; i < lenDiff; i++) {
            longHead = longHead.next;
        }

        while (longHead != null && shortHead != null && longHead != shortHead) {
            longHead = longHead.next;
            shortHead = shortHead.next;
        }

        return longHead;
    }

    private int getLengthOfList(ListNode head) {
        int len = 0;
        ListNode dummy = head;
        while (dummy != null) {
            len++;
            dummy = dummy.next;
        }
        return len;
    }
}
