import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/9 22:43
 */
public class Solution24 {
    /**
     * 动态规划
     * 运行时间：38ms
     * 占用内存：636k
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null || target <= 0) return res;
        ArrayList<Integer> path = new ArrayList<>();
        path(root, target, res, path, 0);
        return res;
    }

    private void path(TreeNode root, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int sum) {
        if (root == null) return;
        sum += root.val;

        // 叶节点
        if (root.left == null && root.right == null) {
            if (sum == target) {
                path.add(root.val);
                res.add(new ArrayList<>(path));
                // 回退一个节点
                path.remove(path.size() - 1);
            }
        }

        // 非叶节点，继续递归
        path.add(root.val);
        path(root.left, target, res, path, sum);
        path(root.right, target, res, path, sum);
        path.remove(path.size() - 1);
    }
}
