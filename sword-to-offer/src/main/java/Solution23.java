/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出true,否则输出false。
 * 假设输入的数组的任意两个数字都互不相同。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/9 22:24
 */
public class Solution23 {

    public boolean VerifySquenceOfBST(int[] sequence) {
        /**
         * 使用辅助函数递归
         * 运行时间：37ms
         占用内存：654k
         */
        if (sequence == null || sequence.length == 0) return false;
        return isBST(sequence, 0, sequence.length - 1);
    }

    private boolean isBST(int[] sequence, int start, int end) {
        if (end <= start) return true;
        int root = sequence[end];
        int i = start;
        for (; i < end; i++) {
            // 找到左右子树边界，即第一个大于root的node
            if (sequence[i] > root) break;
        }
        for (int j = i; j < end; j++) {
            // 检查右子树是否有小于root的
            if (sequence[j] < root) return false;
        }
        return isBST(sequence, start, i - 1) && isBST(sequence, start, end - 1);
    }
}
