package Hard;

import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Tags: Divide and Conquer, Linked List, Heap
 *
 * @author sunyue
 * @version 1.0    2017/1/15 18:39
 */
public class MergekSortedLists {
    /**
     * 使用优先队列
     * 时间复杂度：O(n * log (K))
     * 空间复杂度：O(n)
     * 运行时间：27 ms
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> {
            if (o1.val < o2.val) {
                return -1;
            } else if (o1.val == o2.val) {
                return 0;
            } else {
                return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null) {
                queue.add(tail.next);
            }
        }

        return dummy.next;
    }

    /**
     * 递归的归并解法。
     * 时间复杂度：O(n * log (n))
     * 空间复杂度：O(n)
     * 运行时间：13 ms
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }

    private ListNode partion(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start < end) {
            int mid = start + (end - start) / 2;
            ListNode l1 = partion(lists, start, mid);
            ListNode l2 = partion(lists, mid + 1, end);
            return merge(l1, l2);
        } else {
            return null;
        }
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }
}
