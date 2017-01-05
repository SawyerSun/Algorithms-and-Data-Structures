package Medium;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 * <p>
 * Tags： String
 *
 * @author sunyue
 * @version 1.0    2017/1/3 9:23
 */
public class LongestPalindromicSubstring {
    /**
     * 暴力方法。输入为很长的重复字符串时，运行超时。
     * 时间复杂度: O(n^3)
     * 空间复杂度: O(1)
     * Leetcode运行时间：Time Limit Exceeded
     */
    public String longestPalindrome1(String s) {
        int len = s.length();
        String res = null;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (isPalindrome(s, i, j) && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 动态规划。输入为很长的重复字符串时，运行超时。
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n^2)
     * Leetcode运行时间：Time Limit Exceeded
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        String res = null;
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]));
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    /**
     * 中间展开。选定中点向两边展开，判断是否为Palindrome。
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     * Leetcode运行时间：13ms
     */
    public String longestPalindrome3(String s) {
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            // aba型展开
            int len1 = expandAroundCenter(s, i, i);
            // abba型展开
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > r - l) {
                l = i - (len - 1) / 2;
                r = i + len / 2;
            }
        }
        return s.substring(l, r + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left + 1;
    }
}
