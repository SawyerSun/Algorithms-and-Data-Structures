import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/9 22:16
 */
public class Solution22 {
    /**
     * 层次遍历
     * 运行时间：29ms
     * 占用内存：688k
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return res;
    }
}
