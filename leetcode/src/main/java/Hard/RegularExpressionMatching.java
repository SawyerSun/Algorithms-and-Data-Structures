package Hard;

/**
 * @author sunyue
 * @version 1.0    2017/1/4 14:04
 */
public class RegularExpressionMatching {
    /**
     * 用Dynamic Programming构造一个2D DP矩阵。DP[i][j]表示S到i位置的子串和P到j位置的子串是否匹配。
     * “完全匹配”问题可以转换成“一部分匹配，取决于剩下部分是否匹配”。
     * 详细解释见：http://sawyersun.github.io/2016/09/02/Regular-Expression-Matching/
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n^2)
     * Leetcode运行时间: 7 ms
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        // 预处理
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                // p[j] == s[i] 或者  p[j] == '.'
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                // p[j] == '*' 由于*匹配前一字符的任意多个（包括0）。这是需要看前一字符的情况，即p[j-1]。
                if (p.charAt(j) == '*') {
                    // p[j-1] != s[i] 且 p[j-1] != '.' 此时，a*算作空
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        // p[j-1] == s[i]情况下，有三种情况：
                        // dp[i][j]取决于dp[i][j-2]，a*两个字符算做0个字符。
                        // dp[i][j]取决于dp[i][j-1]，a*两个字符只匹配1个字符a，即s[i]。
                        // dp[i][j]取决于dp[i-1][j]，a*两个字符匹配多个字符a，即s[i-1]和s[i]。
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
