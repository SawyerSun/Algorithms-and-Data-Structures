import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/3/8 17:53
 */
public class Solution19 {


    /**
     * 按顺序打印，注意边界
     * 运行时间：39ms
     * 占用内存：654k
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // 向右遍历
            for (int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }

            // 向下遍历
            for (int i = rowBegin + 1; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }

            // 避免不是一行
            if (rowBegin != rowEnd) {
                // 向左遍历
                for (int i = colEnd - 1; i >= colBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }

            // 避免不是一列
            if (colBegin != colEnd) {
                // 向上遍历,i > rowBegin
                for (int i = rowEnd - 1; i > rowBegin; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }

            rowBegin++;
            rowEnd--;
            colBegin++;
            colEnd--;
        }
        return res;
    }
}
