package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of
 * substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * <p>
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * <p>
 * You should return the indices: [0,9].
 * (order does not matter).
 * <p>
 * Tags： Hash Table， Two Pointers， String
 *
 * @author sunyue
 * @version 1.0    2017/2/23 10:19
 */
public class SubstringwithConcatenationofAllWords {
    /**
     * 暴力遍历匹配，s和words过长时会超出运行时间。
     * 时间复杂度: O(n * m)
     * 空间复杂度: O(2m)
     * runtime: Time Limit Exceeded
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (null == s || null == words || words.length == 0) {
            return res;
        }

        int len = words[0].length();
        // map存储words所有word出现次数
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - len * words.length; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            for (int j = 0; j < words.length; j++) {
                String str = s.substring(i + j * len, i + (j + 1) * len);
                if (copy.containsKey(str)) {
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) {
                        res.add(i);
                        break;
                    }
                }
            }
        }

        return res;
    }

    /**
     * 滑动窗口
     * 时间复杂度: O(n)
     * 空间复杂度: O(2m)
     * Runtime: 35 ms
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (null == s || null == words || words.length == 0) {
            return res;
        }

        int nums = words.length;
        int len = words[0].length();
        int windowLen = nums * len;
        int sLen = s.length();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            HashMap<String, Integer> cur = new HashMap<>();
            // 以work词长为单位移动滑动窗口
            // count用来记录cur中word比map中多的个数
            // start表示滑动窗口的起点
            for (int j = i, count = 0, start = i; j + len <= sLen; j += len) {
                if (start + len > sLen) break;
                String word = s.substring(j, j + len);
                // word不存在map中
                if (!map.containsKey(word)) {
                    cur.clear();
                    count = 0;
                    start = j + len;
                } else {
                    if (j == start + windowLen) {
                        // 去除当前窗口中前一个word
                        String prevWord = s.substring(start, start + len);
                        start += len;
                        int val = cur.get(prevWord);
                        if (val == 1) cur.remove(prevWord);
                        else cur.put(prevWord, val - 1);
                        if (val - 1 >= map.get(prevWord)) count--;
                    }
                    // cur添加新的word
                    cur.put(word, cur.getOrDefault(word, 0) + 1);
                    // cur中该word出现次数比map中期望多，count++
                    if (cur.get(word) > map.get(word)) count++;
                    // count为0 且 滑动窗口正确，才添加结果
                    if (count == 0 && start + windowLen == j + len) {
                        res.add(start);
                    }
                }
            }
        }
        return res;
    }
}
