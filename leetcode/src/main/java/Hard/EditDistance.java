package Hard;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 *
 * @author sunyue
 * @version 1.0    2017/7/16 16:18
 */
public class EditDistance {
    /**
     * Dynamic Programming Solution
     * Tips：use dp[m+1][n+1] to tackle 0-based index
     * Time Complexity: O(n * m)
     * Space Complexity: O(n * m)
     * Runtime: 13 ms
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // case 1: word1[i] == word2[j]
                // dp[i+1][j+1] = dp[i][j]
                if (word1.charAt(i) == word2.charAt(j)) dp[i + 1][j + 1] = dp[i][j];
                    // case 2: word1[i] != word2[j]
                    // dp[i+1][j+1] = 1 + min(dp[i+1][j],dp[i][j+1],dp[i][j])
                    // dp[i+!][j] represents 'insert'
                    // dp[i][j+1] represents 'delete'
                    // dp[i][j] represents 'replace'
                else dp[i + 1][j + 1] = 1 + Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j]));
            }
        }
        return dp[m][n];
    }
}
