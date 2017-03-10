import java.util.HashMap;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/9 23:00
 */
public class Solution25 {
    public static void main(String[] args) {
        Solution25 s = new Solution25();
        RandomListNode head = s.constructList(new char[]{1, 2, 3, 4, 3, 5, '#', 2});
        RandomListNode h2 = s.Clone2(head);
        while (h2 != null) {
            System.out.println(h2.label);
            h2 = h2.next;
        }
    }

    /**
     * 递归法
     * 运行时间：34ms
     * 占用内存：692k
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;

        RandomListNode newHead = new RandomListNode(pHead.label);
        newHead.next = Clone(pHead.next);
        newHead.random = pHead.random;

        return newHead;
    }

    /**
     * 在旧链表中创建新链表，初始化新链表的兄弟节点，最后拆分
     */
    public RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null) return null;

        RandomListNode dummy = pHead;
        // 复制原始链表每个节点N，并新建节点N’，连接到N后面
        while (dummy != null) {
            RandomListNode cloneNode = new RandomListNode(dummy.label);
            cloneNode.next = dummy.next;
            dummy.next = cloneNode;
            dummy = cloneNode.next;
        }

        // 若N.ramdom = S,则N’.random = S'
        dummy = pHead;
        while (dummy != null) {
            if (dummy.random != null) {
                dummy.next.random = dummy.random.next;
            }
            dummy = dummy.next.next;
        }

        // 拆分
        dummy = pHead;
        RandomListNode cloneHead = dummy.next;
        RandomListNode cloneNode = cloneHead;
        while (dummy.next.next != null) {
            dummy = dummy.next.next;
            cloneNode.next = dummy.next;
            cloneNode = cloneNode.next;
        }
        return cloneHead;
    }

    /**
     * 哈希表法,空间换时间
     * 运行时间：35ms
     * 占用内存：692k
     */
    public RandomListNode Clone3(RandomListNode pHead) {
        if (pHead == null) return null;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode dummy = pHead.next;
        RandomListNode cloneHead = new RandomListNode(pHead.label);
        RandomListNode cloneDummy = cloneHead;

        // 复制新链表，并将新旧链表对应节点存到哈希表中
        while (dummy != null) {
            RandomListNode node = new RandomListNode(dummy.label);
            cloneDummy.next = node;
            cloneDummy = node;
            // 将新旧链表对应节点存到哈希表中
            map.put(dummy, node);
            dummy = dummy.next;
        }

        dummy = pHead;
        cloneDummy = cloneHead;
        // 根据哈希表快速为每个节点设置random
        while (dummy != null) {
            if (dummy.random != null) {
                cloneDummy.random = map.get(dummy.random);
            }
            dummy = dummy.next;
            cloneDummy = cloneDummy.next;
        }

        return cloneHead;
    }

    private RandomListNode constructList(char[] chars) {
        RandomListNode head = new RandomListNode(0);
        RandomListNode dummy = head;
        HashMap<Integer, RandomListNode> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            RandomListNode node = constructNode(i + 1);
            map.put(i + 1, node);
            dummy.next = node;
            dummy = dummy.next;
        }

        dummy = head.next;
        int index = 0;
        while (dummy != null) {
            if (chars[index] != '#') {
                dummy.random = map.get((int) (chars[index]));
            }
            index++;
            dummy = dummy.next;
        }

        return head.next;
    }

    private RandomListNode constructNode(int i) {
        return new RandomListNode(i);
    }

    private RandomListNode getNode(final RandomListNode head, int i) {
        int index = 1;
        RandomListNode dummy = head;
        while (dummy != null && index <= i) {
            index++;
            dummy = dummy.next;
        }
        return dummy;
    }

    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "label=" + label +
                    '}';
        }
    }
}
