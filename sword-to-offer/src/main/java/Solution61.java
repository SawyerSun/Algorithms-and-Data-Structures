import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 时间限制：1秒
 * 空间限制：32768K
 * 破题目连个样例都没有！！！！
 *
 * @author sunyue
 * @version 1.0    2017/5/12 22:10
 */
public class Solution61 {
    private static final String spliter = ",";
    private static final String NN = "#";

    /**
     * 递归
     * 运行时间：44ms
     * 占用内存：779k
     */
    public String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append(NN).append(spliter);
            return sb.toString();
        }
        sb.append(root.val).append(spliter).append(Serialize(root.left)).append(Serialize(root.right));
        return sb.toString();
    }

    public TreeNode Deserialize(String str) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(str.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }
}
