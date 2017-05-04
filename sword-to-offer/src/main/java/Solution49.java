/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * <p>
 * 输入例子:
 * +2147483647
 * 1a33
 * <p>
 * 输出例子:
 * 2147483647
 * 0
 * <p>
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/4 11:26
 */
public class Solution49 {

    /**
     * 1. long解决int溢出问题
     * 2. 处理异常字符
     * 3. 处理正负号
     * 运行时间：30ms
     * 占用内存：354k
     */
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        long num = 0;
        boolean isPositive = true;
        if (chars[0] == '-') isPositive = false;
        for (char c : chars) {
            if (c == '+' || c == '-') continue;
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else {
                num = 0;
                break;
            }
        }
        long res = isPositive ? num : num * -1;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) res = 0;
        return (int) res;
    }
}
