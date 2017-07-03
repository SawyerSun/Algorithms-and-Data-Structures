package Easy;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * For example,
 * Given s = "Hello World",
 * return 5.
 *
 * @author sunyue
 * @version 1.0    2017/7/3 16:39
 */
public class LengthofLasWord {
    /**
     * 先trim，在从后往前处理
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 运行时间：5 ms
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = 0;
        String str = s.trim();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') len++;
            else break;
        }
        return len;
    }
}
