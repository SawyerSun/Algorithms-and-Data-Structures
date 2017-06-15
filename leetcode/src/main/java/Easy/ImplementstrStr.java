package Easy;

/**
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Subscribe to see which companies asked this question.
 * <p>
 * Tags: Two Pointers, String
 *
 * @author sunyue
 * @version 1.0    2017/2/22 19:50
 */
public class ImplementstrStr {
    /**
     * 调用indexOf函数
     * 运行时间: 6 ms
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 运行时间: 14 ms
     */
    public int strStr2(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}

