package Hard;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * <p>
 * You may assume that there will be only one unique solution.
 * Tags: Backtracking， Hash Table
 *
 * @author sunyue
 * @version 1.0    2017/6/6 20:19
 */
public class SudokuSolver {
    /**
     * 回溯法
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     * 运行时间: 31 ms
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        helper(board);
    }

    private boolean helper(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            // 填入c
                            board[i][j] = c;
                            // 递归
                            if (helper(board)) return true;
                                // 回溯
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) return false;
            if (board[row][i] != '.' && board[row][i] == c) return false;
            // 检查3x3格子
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }
}
