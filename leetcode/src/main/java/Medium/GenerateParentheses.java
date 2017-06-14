package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * Tags： Backtracking， String
 *
 * @author sunyue
 * @version 1.0    2017/1/14 14:13
 */
public class GenerateParentheses {
    /**
     * 回溯法
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * 运行时间：4ms
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTrack(list, "", 0, 0, n);
        return list;
    }

    private void backTrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        if (open < max) {
            backTrack(list, str + "(", open + 1, close, max);
        }
        if (close < open) {
            backTrack(list, str + ")", open, close + 1, max);
        }
    }
}
