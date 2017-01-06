package Easy;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Tags: Math, String
 *
 * @author sunyue
 * @version 1.0    2017/1/6 16:02
 */
public class RomantoInteger {

    /**
     * 弄明白罗马数字和阿拉伯数字转换很关键。
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * Leetcode运行时间: 8 ms
     */
    public int romanToInt(String s) {
        int res = toNumber(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (toNumber(s.charAt(i - 1)) < toNumber(s.charAt(i))) {
                res += toNumber(s.charAt(i)) - 2 * toNumber(s.charAt(i - 1));
            } else {
                res += toNumber(s.charAt(i));
            }
        }
        return res;
    }

    private int toNumber(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}
