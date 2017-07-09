package Medium;

/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 *
 * @author sunyue
 * @version 1.0    2017/7/9 16:02
 */
public class MinimumPathSum {
    /**
     * Dynamic Programming Solution
     * Tips: Should not modify the input parameter. Make copy of origin grid
     * Time Complexity: O(n * m)
     * Space Complexity: O(n * m)
     * Runtime: 4 ms
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] copy = new int[m][n];
        System.arraycopy(grid, 0, copy, 0, grid.length);

        for (int i = 1; i < m; i++) {
            copy[i][0] = copy[i][0] + copy[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            copy[0][j] = copy[0][j] + copy[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                copy[i][j] = copy[i][j] + Math.min(copy[i - 1][j], copy[i][j - 1]);
            }
        }
        return copy[m - 1][n - 1];
    }
}
