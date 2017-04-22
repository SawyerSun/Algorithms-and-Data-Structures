import java.util.HashMap;
import java.util.Map;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置。如果字符串为空,返回-1
 *
 * @author sunyue
 * @version 1.0    2017/4/20 22:01
 */
public class Solution34 {
    /**
     * Map保存次数，O（n）复杂度
     * 运行时间：46ms
     * 占用内存：825k
     */
    public int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
