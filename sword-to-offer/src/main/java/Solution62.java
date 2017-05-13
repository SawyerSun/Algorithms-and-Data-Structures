/**
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如，
 * 5
 * / \
 * 3 7
 * /\ /\
 * 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/13 20:51
 */
public class Solution62 {
    private int index = 0;

    /**
     * 中序递归
     * 运行时间：39ms
     * 占用内存：654k
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode node = KthNode(pRoot.left, k);
            if (node != null) return node;
            index++;
            if (index == k) return pRoot;
            node = KthNode(pRoot.right, k);
            if (node != null) return node;
        }
        return null;
    }
}
