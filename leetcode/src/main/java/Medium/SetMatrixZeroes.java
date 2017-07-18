package Medium;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * <p>
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 * @author sunyue
 * @version 1.0    2017/7/18 20:53
 */
public class SetMatrixZeroes {
    /**
     * Store states of each cols in the col-0 and row-0
     * fr and fc represents row1 and col1 is (not) zero
     * Time Complexity: O(n * m)
     * Space Complexity: O(1)
     * Runtime: 13 ms
     */
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean fr = false;
        boolean fc = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        if (fr) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }
        if (fc) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * Wrong solution!
     * Retrieval after change is wrong
     */
    public void setZeroes2(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

    }
}
