/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/4/27 21:27
 */
public class Solution38 {
    /**
     * 递归解法
     * 运行时间：24ms
     * 占用内存：629k
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(1 + TreeDepth(root.left), 1 + TreeDepth(root.right));
    }
}
