package Medium;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * <p>
 * For example,
 * Given board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 * @author sunyue
 * @version 1.0
 * @createOn 2017/9/5 21:55
 */
public class WordSearch {
    /**
     * Use bit mask to indicate visited cell, rather than extra matrix
     * Time Complexity: O(k*n^2)
     * Space Complexity: O(n^2)
     * Runtime: 10 ms
     */
    public boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (exist(board, x, y, wordArray, 0)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int x, int y, char[] word, int i) {
        if (i == word.length) return true;
        if (y < 0 || x < 0 || y == board[0].length || x == board.length) return false;
        if (board[x][y] != word[i]) return false;
        // bit mask
        board[x][y] ^= 256;
        boolean exist = exist(board, x - 1, y, word, i + 1)
                || exist(board, x + 1, y, word, i + 1)
                || exist(board, x, y - 1, word, i + 1)
                || exist(board, x, y + 1, word, i + 1);
        board[x][y] ^= 256;
        return exist;
    }
}
