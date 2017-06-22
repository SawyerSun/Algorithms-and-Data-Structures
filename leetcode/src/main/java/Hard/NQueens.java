package Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
 * both indicate a queen and an empty space respectively.
 * <p>
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 *
 * @author sunyue
 * @version 1.0    2017/6/22 14:16
 */
public class NQueens {
    /**
     * 回溯法。按行添加皇后，检查是否有效。
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     * 运行时间: 10 ms
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        placeQueens(0, new int[n], res, n);
        return res;
    }

    private void placeQueens(int row, int[] cols, List<List<String>> res, int n) {
        if (row == n) res.add(construct(cols));
        for (int col = 0; col < n; col++) {
            if (isValid(cols, row, col)) {
                cols[row] = col;
                placeQueens(row + 1, cols, res, n);
            }
        }
    }

    /**
     * 根据cols构造解法
     *
     * @param cols 每行皇后所在列位置
     * @return 解法
     */
    private List<String> construct(int[] cols) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < cols.length; i++) {
            int col = cols[i];
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < cols.length; j++) {
                if (j == col) sb.append('Q');
                else sb.append('.');
            }
            res.add(sb.toString());
        }
        return res;
    }

    /**
     * 检查将皇后置于(row1,col1)位置是否有效，只需要检查比row1的行
     * @param cols
     * @param row1
     * @param col1
     * @return
     */
    private boolean isValid(int[] cols, int row1, int col1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int col2 = cols[row2];
            if (col1 == col2) return false;
            int colDis = Math.abs(col1 - col2);
            int rowDis = Math.abs(row1 - row2);
            if (colDis == rowDis) return false;
        }
        return true;
    }
}
