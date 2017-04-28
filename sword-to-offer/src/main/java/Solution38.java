import java.util.ArrayDeque;
import java.util.Deque;

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

    /**
     * 非递归解法：层次遍历
     * 运行时间：29ms
     * 占用内存：510k
     */
    public int TreeDepth2(TreeNode root) {
        if (root == null) return 0;
        int level = 0;
        int count;
        int lastCount;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 本层已经遍历节点数
            count = 0;
            // 本层遍历完毕，queue中全是下层节点数
            lastCount = queue.size();
            while (count < lastCount) {
                TreeNode tmp = queue.poll();
                count++;
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
            }
            level++;
        }
        return level;

    }
}
