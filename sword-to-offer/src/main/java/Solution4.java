/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0 2017/1/24 下午12:37
 */
public class Solution4 {
    /**
     * 递归解法
     * 运行时间：188ms
     * 占用内存：4871k
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length <= 0 || in.length <= 0) return null;
        return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode construct(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) return null;
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = construct(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = construct(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
            }
        }
        return root;
    }
}
