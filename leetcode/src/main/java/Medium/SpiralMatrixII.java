package Medium;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * <p>
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * @author sunyue
 * @version 1.0    2017/7/4 21:13
 */
public class SpiralMatrixII {
    /**
     * 按顺序赋值
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     * 运行时间：2 ms
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n <= 0) return matrix;
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int index = 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = index++;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = index++;
            }
            colEnd--;
            for (int i = colEnd; i >= colStart; i--) {
                if (rowStart <= rowEnd) {
                    matrix[rowEnd][i] = index++;
                }
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowStart; i--) {
                if (colStart <= colEnd) {
                    matrix[i][colStart] = index++;
                }
            }
            colStart++;
        }
        return matrix;
    }
}
