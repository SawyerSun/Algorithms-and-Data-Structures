/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/4/28 22:08
 */
public class Solution39 {
    /**
     * 基于树深度的解法
     * 运行时间：32ms
     * 占用内存：629k
     */
    public boolean IsBalanced(TreeNode root) {
        if (root == null) return true;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if (Math.abs(left - right) > 1) return false;
        return IsBalanced(root.left) && IsBalanced(root.right);
    }

    /**
     * 上面方法的缺点是节点会被重复遍历
     * 改进方法，使用后序遍历
     * 遍历到一个节点，其左右子树已经遍历  依次自底向上判断，每个节点只需要遍历一次
     * 运行时间：30ms
     * 占用内存：503k
     */
    public boolean IsBalanced2(TreeNode root) {
        if (root == null) return true;
        boolean isBalanced = true;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if (Math.abs(left - right) > 1) isBalanced = false;
        return isBalanced;
    }

    private int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(1 + TreeDepth(root.left), 1 + TreeDepth(root.right));
    }

}
