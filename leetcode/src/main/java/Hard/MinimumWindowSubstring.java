package Hard;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in
 * complexity O(n).
 * <p>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 *
 * @author sunyue
 * @version 1.0    2017/7/26 21:56
 */
public class MinimumWindowSubstring {
    /**
     * HashMap and two pointer.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Runtime: 4 ms
     */
    public String minWindow(String s, String t) {
        if (null == s || s.length() == 0 || null == t || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        // simple hashmap
        int[] map = new int[128];
        for (char c : tChars) {
            map[c]++;
        }

        // check whether substring is valid
        int counter = t.length();
        int begin = 0;
        int end = 0;
        int d = Integer.MAX_VALUE;
        int head = 0;

        while (end < sChars.length) {
            if (map[sChars[end++]]-- > 0) counter--;
            while (counter == 0) {
                // valid
                if (end - begin < d) d = end - (head = begin);
                if (map[sChars[begin++]]++ == 0) counter++;    // make it invalid
            }
        }
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }
}
