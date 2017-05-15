/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/15 22:19
 */
public class Solution66 {
    /**
     * 状态矩阵+递归
     * 运行时间：33ms
     * 占用内存：629k
     */
    public int movingCount(int threshold, int rows, int cols) {
        // 状态矩阵标记每个位置是否被访问过
        int[][] flag = new int[rows][cols];
        return helper(0, 0, rows, cols, threshold, flag);
    }

    private int helper(int i, int j, int rows, int cols, int threshold, int[][] flag) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || sum(i) + sum(j) > threshold || flag[i][j] == 1) return 0;
        flag[i][j] = 1;
        //递归
        return helper(i - 1, j, rows, cols, threshold, flag)
                + helper(i + 1, j, rows, cols, threshold, flag)
                + helper(i, j - 1, 1, cols, threshold, flag)
                + helper(i, j + 1, rows, cols, threshold, flag)
                + 1;
    }

    private int sum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }
}
