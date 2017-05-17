import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * git是一种分布式代码管理工具，git通过树的形式记录文件的更改历史，
 * 比如： base'<--base<--A<--A' ^ | --- B<--B'
 * 小米工程师常常需要寻找两个分支最近的分割点，即base.
 * 假设git 树是多叉树，请实现一个算法，计算git树上任意两点的最近分割点。
 * （假设git树节点数为n,用邻接矩阵的形式表示git树：字符串数组matrix包含n个字符串，每个字符串由字符'0'或'1'组成，长度为n。
 * matrix[i][j]=='1'当且仅当git树种第i个和第j个节点有连接。节点0为git树的根节点。）
 * <p>
 * 输入例子:
 * [01011,10100,01000,10000,10000],1,2
 * <p>
 * 输出例子:
 * 1
 * <p>
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/16 21:15
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.getSplitNode(new String[]{"01011", "10100", "01000", "10000", "10000"}, 2, 1));
        System.out.println(s.getSplitNode(new String[]{"0001", "0001", "0001", "1110"}, 3, 2));
    }

    /**
     * 返回git树上两点的最近分割点
     *
     * @param matrix 接邻矩阵，表示git树，matrix[i][j] == '1' 当且仅当git树中第i个和第j个节点有连接，节点0为git树的根节点
     * @param indexA 节点A的index
     * @param indexB 节点B的index
     * @return 整型
     */
    public int getSplitNode(String[] matrix, int indexA, int indexB) {
        if (indexA == indexB) return indexA;
        int len = matrix.length;
        // 构造一个father数组，存放每个节点的父节点
        int[] father = new int[len];
        // 标志数组
        int[] flag = new int[len];
        // 根节点的父节点为-1
        father[0] = -1;
        // 根节点 已经访问过
        flag[0] = 1;
        Queue<Integer> children = new ArrayDeque<>();
        children.offer(0);

        // 构造father数组，从根节点0开始，从上往下构造。
        while (!children.isEmpty()) {
            int parent = children.poll();
            char[] chars = matrix[parent].toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (flag[i] != 1 && chars[i] == '1') {
                    // 设置父节点
                    father[i] = parent;
                    // 将其加入孩子队列
                    children.offer(i);
                    // 标记为 访问过
                    flag[i] = 1;
                }
            }
        }

        int ia = indexA;
        int ib = indexB;
        // 记录从根节点到本节点的路径
        Deque<Integer> queueA = new ArrayDeque<>();
        Deque<Integer> queueB = new ArrayDeque<>();
        while (ia != -1) {
            queueA.addFirst(ia);
            ia = father[ia];
        }
        while (ib != -1) {
            queueB.addFirst(ib);
            ib = father[ib];
        }

        // 找到公共父节点
        int commonParent = 0;
        while (queueA.peekFirst() == queueB.peekFirst()) {
            commonParent = queueA.peekFirst();
            queueA.pollFirst();
            queueB.pollFirst();
        }
        return commonParent;
    }
}
