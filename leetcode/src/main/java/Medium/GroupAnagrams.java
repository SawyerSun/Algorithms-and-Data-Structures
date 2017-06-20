package Medium;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note: All inputs will be in lower-case.
 * <p>
 * Tags: Hash Tabl, String
 *
 * @author sunyue
 * @version 1.0    2017/6/20 20:40
 */
public class GroupAnagrams {
    /**
     * 对每个单词字符排序，确定其值
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 运行时间：33ms
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
