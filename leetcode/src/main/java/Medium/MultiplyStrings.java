package Medium;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 * <p>
 * Note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * <p>
 * Tags: Math, String
 *
 * @author sunyue
 * @version 1.0    2017/6/14 22:09
 */
public class MultiplyStrings {
    /**
     * https://discuss.leetcode.com/topic/30508/easiest-java-solution-with-graph-explanation/2
     * 乘法原理解法
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     * 运行时间：30ms
     */
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] pos = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mu1 = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mu1 + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int po : pos) {
            if (!(sb.length() == 0 && po == 0)) sb.append(po);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public String multiply2(String num1, String num2) {
        int res = stringToInt(num1)*stringToInt(num2);
        return String.valueOf(res);
    }

    private int stringToInt(String str){
        int num=0;
        for (int i = 0; i < str.length(); i++) {
            num *= 10;
            int p = str.charAt(i)-'0';
            num += p;
        }
        return num;
    }
}
