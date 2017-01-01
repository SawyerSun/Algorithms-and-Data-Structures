package Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Tags: Hash Table, Two Pointers, String
 *
 * @author sunyue
 * @version 1.0    2017/1/1 22:07
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * 暴力遍历，最终运行超时！！！
     * 时间复杂度：O(n^3)
     * 空间复杂度： O(min(n, m))，26字母和s长度中较小的值
     * Leetcode运行时间：Time Limit Exceeded ！
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) res = Math.max(res, j - i);
        return res;
    }

    private boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /**
     * 滑动窗口，使用HashSet保存滑动窗口[i,j），不断递进更新最大值
     * 时间复杂度：O(2n) = O(n)
     * 空间复杂度： O(min(n, m))，26字母和s长度中较小的值
     * Leetcode运行时间：24 ms
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int res = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // hashset保存滑动窗口[i,j）
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                res = Math.max(res, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }

    /**
     * 滑动窗口优化版，start标记起始位置，i不断向后递进，并且保存下i到达的位置。
     * 时间复杂度：O(n)
     * 空间复杂度： O(min(n, m))，26字母和s长度中较小的值
     * Leetcode运行时间：20 ms
     */
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, start = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                // 更新起始位置j
                start = Math.max(map.get(s.charAt(i)), start);
            }
            res = Math.max(res, i - start + 1);
            // 保存字符后一个索引位置
            map.put(s.charAt(i), i + 1);
        }
        return res;
    }
}
