/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 时间限制：1s
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0 2017/1/22 下午9:15
 */
public class Solution1 {
    /**
     * 常规解法：取最中间的值，判断target是右方还是下方，但存在两方存在交集！
     * 进阶解法：从右上角取值判断，若大于target，则去掉这一列；若小与target，则去掉这一行；若等于，则返回。
     * 运行时间：185ms
     * 占用内存：5022K
     */
    public boolean Find(int target, int [][] array) {
        int rows = array.length,cols = array[0].length;
        if(rows>=0 && cols>=0){
            int row = 0,col = cols-1;
            while (row<rows&&col>=0){
                if (array[row][col]==target)return true;
                else if (array[row][col]>target)col--;
                else row++;
            }
        }
        return false;
    }
}
