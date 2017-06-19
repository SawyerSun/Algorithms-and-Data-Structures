package Medium;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Could you do this in-place?
 * <p>
 * Tags: Array
 *
 * @author sunyue
 * @version 1.0    2017/6/19 19:34
 */
public class RotateImage {
    /**
     * 顺时针
     * 先上下交换，再对称交换
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     * 逆时针：
     * 先左右交换，再对称交换
     * 时间复杂度 O(n^2)
     * 空间复杂度 O（1）
     * 运行时间: 3 ms
     */
    public void rotate(int[][] matrix) {
        int start = 0;
        int end = matrix.length - 1;
        while (start < end) {
            int[] temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            start++;
            end--;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
