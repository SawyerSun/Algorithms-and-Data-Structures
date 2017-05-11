/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/11 10:59
 */
public class Solution57 {
    /**
     * 运行时间：42ms
     * 占用内存：729k
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 节点为空
        if (pNode == null) return null;
        // 如有右子树，找到其最左节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) pNode = pNode.left;
            return pNode;
        }
        // 如无右子树，则找第一个当前节点是父节点左孩子的节点
        while (pNode.next != null) {
            // 当前节点父节点的左子树就是其本身，则返回父节点
            if (pNode.next.left == pNode) return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }
}
