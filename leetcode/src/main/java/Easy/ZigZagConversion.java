package Easy;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * Subscribe to see which companies asked this question
 * <p>
 * Tags:String
 *
 * @author sunyue
 * @version 1.0    2017/1/3 10:00
 */
public class ZigZagConversion {
    /**
     * 使用StringBuilder按序append对应字符。
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * 运行时间: 11 ms
     */
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int len = s.length(), index = 0;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        while (index < len) {
            // 垂直下
            for (int i = 0; i < numRows && index < len; i++) {
                sb[i].append(chars[index++]);
            }
            // 曲折上
            for (int i = numRows - 2; i >= 1 && index < len; i--) {
                sb[i].append(chars[index++]);
            }
        }
        for (int i = 0; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
