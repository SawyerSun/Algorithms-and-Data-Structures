package Hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * <p>
 * Tags: Dynamic Programming, String
 *
 * @author sunyue
 * @version 1.0    2017/2/28 14:37
 */
public class LongestValidParentheses {
    /**
     * 用栈解决很容易超时！
     * Time Limit Exceeded
     */
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int longest = 0;
        int n = chars.length;
        // 栈存储字符的下标
        Deque<Integer> stack = new ArrayDeque<>();
        // 遍历字符，消去所有配对的()
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && chars[stack.peek()] == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        if (stack.isEmpty()) {
            longest = n;
        } else {
            int a = n;
            int b = 0;
            while (!stack.isEmpty()) {
                b = stack.peek();
                stack.pop();
                longest = Math.max(longest, a - b - 1);
                a = b;
            }
            longest = Math.max(longest, a);
        }
        return longest;
    }

    /**
     * 动态规划解决，one pass遍历
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * Runtime: 19 ms
     */
    public int longestValidParentheses2(String s) {
        // 存储到目前位置，有几组有效对
        int[] dp = new int[s.length() + 1];
        int longest = 0;
        for (int i = 1; i < s.length(); i++) {
            // 只有出现了），才向前寻找是否能匹配到（
            if (s.charAt(i) == ')' && i - dp[i] >= 1 && s.charAt(i - dp[i] - 1) == '(') {
                dp[i + 1] = dp[i - dp[i] - 1] + dp[i] + 2;
                longest = Math.max(longest, dp[i + 1]);
            }
        }
        return longest;
    }
}
