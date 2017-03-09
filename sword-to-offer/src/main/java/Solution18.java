import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定的二叉树，将其变换为源二叉树的镜像。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/8 17:22
 */
public class Solution18 {
    /**
     * 递归解法
     * 运行时间：40ms
     * 占用内存：528k
     */
    public void Mirror(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }

    /**
     * 非递归解法，使用栈
     * 运行时间：41ms
     * 占用内存：528k
     */
    public void Mirror2(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null || node.right != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }
}
