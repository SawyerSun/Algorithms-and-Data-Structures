import java.util.ArrayList;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，
 * 其他行以此类推。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/11 11:22
 */
public class Solution59 {
    /**
     * 正常遍历二叉树，每一层添加时，如果是偶数层，加在list后面位置，如果是奇数层，加在list前面位置
     * 运行时间：32ms
     * 占用内存：503k
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        travel(pRoot, res, 0);
        return res;
    }

    private void travel(TreeNode cur, ArrayList<ArrayList<Integer>> res, int level) {
        if (cur == null) return;
        if (res.size() <= level) {
            ArrayList<Integer> newLine = new ArrayList<>();
            res.add(newLine);
        }

        ArrayList<Integer> list = res.get(level);
        if (level % 2 == 0) list.add(cur.val);
        else list.add(0, cur.val);

        travel(cur.left, res, level + 1);
        travel(cur.right, res, level + 1);
    }
}
