package Easy;

/**
 * Implement atoi to convert a string to an integer.
 * <p>
 * Requirements for atoi:
 * <p>
 * 1. The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits
 * as possible, and interprets them as a numerical value.
 * <p>
 * 2. The string can contain additional characters after those that form the integral number, which are ignored and have no
 * effect on the behavior of this function.
 * <p>
 * 3. If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists
 * because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * 4. If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of
 * representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * <p>
 * Tags: Math, String
 *
 * @author sunyue
 * @version 1.0    2017/1/3 10:11
 */
public class StringtoInteger {
    /**
     * 各种边界问题和异常都需要考虑。
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * Leetcode运行时间: 4 ms
     */
    public static int myAtoi(String str) {
        int sign = 1, total = 0, index = 0;
        // null字符串
        if (str == null) return 0;
        // 去除前后空格
        str = str.trim();
        // trim后为空字符串
        if (str.length() == 0) return 0;
        // 判别符号
        char temp = str.charAt(index);
        if (temp == '+' || temp == '-') {
            sign = temp == '+' ? +1 : -1;
            index++;
        }
        //转换数字，处理溢出
        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            // 非法字符跳出
            if (digit < 0 || digit > 9) break;
            // 溢出问题
            if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10 * total + digit;
            index++;
        }
        return total * sign;
    }
}
