package Medium;

/**
 * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz",
 * so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * <p>
 * Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s.
 * In particular, your input is the string p and you need to output the number of different
 * non-empty substrings of p in the string s.
 * Note: p consists of only lowercase English letters and the size of p might be over 10000.
 * <p>
 * Example 1:
 * Input: "a"
 * Output: 1
 * <p>
 * Explanation: Only the substring "a" of string "a" is in the string s.
 * Example 2:
 * Input: "cac"
 * Output: 2
 * Explanation: There are two substrings "a", "c" of string "cac" in the string s.
 * <p>
 * Example 3:
 * Input: "zab"
 * Output: 6
 * Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
 *
 * @author sunyue
 * @version 1.0
 * @createOn 2017/9/10 20:42
 */
public class UniqueSubstringsinWraparoundString {
    /**
     * Find the max number of unique substring ends with each 26 letter
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Runtime: 25 ms
     */
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int maxCurLen = 0;

        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) {
                maxCurLen++;
            } else {
                maxCurLen = 1;
            }
            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxCurLen);
        }

        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];
        }
        return sum;
    }
}
