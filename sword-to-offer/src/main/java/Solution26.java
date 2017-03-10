/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/10 15:41
 */
public class Solution26 {
    /**
     * 递归解法
     * 运行时间：34ms
     * 占用内存：503k
     */
    public TreeNode Convert(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;

        // 左子树转为双链表
        TreeNode left = Convert(root.left);
        TreeNode p = left;
        // 定位左子树最右边节点
        while (p != null && p.right != null) {
            p = p.right;
        }
        // 将root追加到左子树链表
        if (left != null) {
            p.right = root;
            root.left = p;
        }
        // 右子树转为双链表
        TreeNode right = Convert(root.right);
        // 添加到root后面
        if (right != null) {
            right.left = root;
            root.right = right;
        }

        return left != null ? left : root;
    }
}
