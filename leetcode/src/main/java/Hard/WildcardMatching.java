package Hard;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * <p>
 * Tags： Dynamic Programming, Backtracking, Greedy, String
 *
 * @author sunyue
 * @version 1.0    2017/6/15 10:08
 */
public class WildcardMatching {
    /**
     * 两个指针同时遍历
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     * 运行时间: 62 ms
     */
    public boolean isMatch(String s, String p) {
        int sIndex = 0;
        int pIndex = 0;
        int match = 0;
        int starIdx = -1;
        while (sIndex < s.length()) {
            // 匹配，s和p同时进一位
            if (pIndex < p.length() && (p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex))) {
                sIndex++;
                pIndex++;
            }
            // 遇到*
            else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                starIdx = pIndex;
                match = sIndex;
                pIndex++;
            }
            // * 匹配s多位
            else if (starIdx != -1) {
                pIndex = starIdx + 1;
                match++;
                sIndex = match;
            }
            // 不匹配
            else return false;
        }
        // 检查p剩余字符
        while (pIndex < p.length() && p.charAt(pIndex) == '*') {
            pIndex++;
        }

        return pIndex == p.length();
    }
}
