package Medium;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * For example,
 * Consider the following matrix:
 * [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 *
 * @author sunyue
 * @version 1.0    2017/7/24 21:23
 */
public class Searcha2DMatrix {
    /**
     * Treat it as ordered array. Do binary search.
     * matrix[x][y] = a[x*cols+y]
     * a[x] = matrix[x/cols][x%cols]
     * Time Complexity: O(log (n * m))
     * Space Complexity: O(1)
     * Runtime: 1 ms
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int begin = 0;
        int end = rows * cols - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            int midValue = matrix[mid / cols][mid % cols];
            if (midValue == target) return true;
            else if (midValue < target) begin = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}
