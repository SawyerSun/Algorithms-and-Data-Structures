/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/1 14:02
 */
public class Solution43 {
    /**
     * 需要考虑 n>len的情况
     * 运行时间：33ms
     * 占用内存：629k
     */
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) return "";
        int len = str.length();
        n = n % len;
        return str.substring(n) + str.substring(0, n);
    }
}
