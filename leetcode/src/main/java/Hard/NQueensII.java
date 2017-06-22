package Hard;

import java.util.HashSet;
import java.util.Set;

/**
 * Follow up for N-Queens problem.
 * <p>
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 *
 * @author sunyue
 * @version 1.0    2017/6/22 15:27
 */
public class NQueensII {


    /**
     * 跟前一题N-Queen不同的是，该题只要统计解法数目，不用真正生成解法。
     * 用set检查解法是否相同。
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     * 运行时间: 13 ms
     */
    public int totalNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> Diag1s = new HashSet<>();
        Set<Integer> Diag2s = new HashSet<>();
        return backtrack(0, 0, n, cols, Diag1s, Diag2s);
    }

    private int backtrack(int row, int count, int n, Set<Integer> cols, Set<Integer> Diag1s, Set<Integer> Diag2s) {
        if (row == n) count++;

        for (int col = 0; col < n; col++) {
            if (cols.contains(col)) continue;
            int diag1 = row - col;
            if (Diag1s.contains(diag1)) continue;
            int diag2 = row + col;
            if (Diag2s.contains(diag2)) continue;

            cols.add(col);
            Diag1s.add(diag1);
            Diag2s.add(diag2);
            count = backtrack(row + 1, count, n, cols, Diag1s, Diag2s);
            cols.remove(col);
            Diag1s.remove(diag1);
            Diag2s.remove(diag2);

        }
        return count;
    }

    /**
     * boolean数组比set更快更省空间
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     * 运行时间: 2 ms
     */
    public int totalNQueens2(int n) {
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2 * n];
        boolean[] d2 = new boolean[2 * n];
        return backtrack2(0, 0, n, cols, d1, d2);
    }

    private int backtrack2(int row, int count, int n, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == n) count++;
        for (int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if (cols[col] || d1[id1] || d2[id2]) continue;

            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;
            count = backtrack2(row + 1, count, n, cols, d1, d2);
            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }
        return count;
    }
}
