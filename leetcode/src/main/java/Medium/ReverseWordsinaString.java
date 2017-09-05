package Medium;

/**
 * Given an input string, reverse the string word by word.
 * <p>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * <p>
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 * <p>
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 *
 * @author sunyue
 * @version 1.0
 * @createOn 2017/9/5 22:33
 */
public class ReverseWordsinaString {
    /**
     * 1. Reverse the string
     * 2. Reverse word
     * 3. Clean extra spaces
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Runtime: 8 ms
     */
    public String reverseWords(String s) {
        if (null == s) return null;
        char[] chars = s.toCharArray();
        int n = chars.length;

        reverse(chars, 0, n - 1);
        reverseWords(chars, n);
        return clean(chars, n);
    }

    private void reverse(char[] s, int i, int j) {
        while (i < j) {
            char t = s[i];
            s[i++] = s[j];
            s[j--] = t;
        }
    }

    private void reverseWords(char[] s, int n) {
        int i = 0;
        int j = 0;
        while (i < n) {
            while (i < j || i < n && s[i] == ' ') i++;
            while (j < i || j < n && s[j] != ' ') j++;
            reverse(s, i, j - 1);
        }
    }

    private String clean(char[] s, int n) {
        int i = 0;
        int j = 0;
        while (j < n) {
            while (j < n && s[j] == ' ') j++;             // skip spaces
            while (j < n && s[j] != ' ') s[i++] = s[j++]; // keep non spaces
            while (j < n && s[j] == ' ') j++;             // skip spaces
            if (j < n) s[i++] = ' ';                      // keep only one space
        }
        return new String(s).substring(0, i);
//        int index = 0;
//        for (int i = 0; i < n; i++) {
//            if (i > 0 && s[i] == ' ' && s[i - 1] == ' ') continue;
//            s[index++] = s[i];
//        }
//        return new String(s).substring(0, index).trim();
    }
}
