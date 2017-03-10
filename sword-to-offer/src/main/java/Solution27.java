import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/10 15:54
 */
public class Solution27 {
    /**
     * 交换某一位，将结果加入tesset去重
     * 运行时间：142ms
     * 占用内存：1535k
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) return res;

        char[] chars = str.toCharArray();
        TreeSet<String> temp = new TreeSet<>();
        Permutation(chars, 0, temp);
        res.addAll(temp);
        return res;
    }

    private void Permutation(char[] chars, int begin, TreeSet<String> res) {
        if (chars == null || chars.length == 0 || begin < 0 || begin > chars.length - 1) return;
        if (begin == chars.length - 1) {
            res.add(String.valueOf(chars));
        } else {
            for (int i = begin; i <= chars.length - 1; i++) {
                swap(chars, begin, i);
                Permutation(chars, begin + 1, res);
                swap(chars, begin, i);
            }
        }
    }

    private void swap(char[] chars, int a, int b) {
        char t = chars[a];
        chars[a] = chars[b];
        chars[b] = t;
    }
}
