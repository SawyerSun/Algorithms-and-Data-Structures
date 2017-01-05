package Medium;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Tags: Math, String
 *
 * @author sunyue
 * @version 1.0    2017/1/5 15:43
 */
public class IntegertoRoman {
    /**
     * 使用类似字母表的设计。
     * 时间复杂度: O(1)
     * 空间复杂度: O(1)
     * Leetcode运行时间：11ms
     */
    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }
}
