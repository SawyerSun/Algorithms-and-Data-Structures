/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。、
 * <p>
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/1 11:14
 */
public class Solution40 {
    /***
     * 对数组求异或，结果为在这两个数字的异或结果，找到第一位为1的位置，以该位置分割数组，再异或求值。
     * num1,num2分别为长度为1的数组。传出参数
     * 将num1[0],num2[0]设置为返回结果
     * 运行时间：31ms
     * 占用内存：503k
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int xorRes = 0;
        for (int i = 0; i < array.length; i++) {
            xorRes ^= array[i];
        }
        int index = findFirstBit(xorRes);
        for (int i = 0; i < array.length; i++) {
            if (isBit(array[i], index)) num1[0] ^= array[i];
            else num2[0] ^= array[i];
        }
    }

    private int findFirstBit(int num) {
        int index = 0;
        while ((num & 1) == 0 && index < Integer.toBinaryString(num).length()) {
            num >>= 1;
            index++;
        }
        return index;
    }

    private boolean isBit(int num, int index) {
        return (num >> index & 1) == 1;
    }
}
