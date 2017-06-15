package Easy;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * <p>
 * Tags: Stack, String
 *
 * @author sunyue
 * @version 1.0    2017/1/9 20:21
 */
public class ValidParentheses {
    /**
     * stack的典型应用场景。
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * 运行时间: 1 ms
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else if (s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[') {
                stack.pop();
            } else if (s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.empty();
    }
}
