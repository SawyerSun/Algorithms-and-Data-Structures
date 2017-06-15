package Easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * Tags: String
 *
 * @author sunyue
 * @version 1.0    2017/1/6 16:04
 */
public class LongestCommonPrefix {
    /**
     * 暴力方法，使用indexOf检查字符串是否在目标字符串中。以第一个字符串为最初最长前缀，不断比较，不断更新。
     * 时间复杂度: O(s), s为所有字符串所有字符数。
     * 空间复杂度: O(1)
     * 运行时间: 9 ms
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * 垂直扫描匹配。
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     * 运行时间: 12 ms
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 分而治之的递归解法。当输入过多，会堆栈溢出!!!
     * 时间复杂度: O(s), s为所有字符串所有字符数。
     * 空间复杂度: O(1)
     * 运行时间: StackOverflowError
     */
    @Deprecated
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return helper(strs, 0, strs.length - 1);
    }

    private String helper(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String left = helper(strs, 1, mid);
            String right = helper(strs, mid + 1, r);
            return commonPrefix(left, right);
        }
    }

    private String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    /**
     * 二分查找
     * 时间复杂度: O(s*log(n)), s为所有字符串所有字符数。
     * 空间复杂度: O(1)
     * 运行时间: 11 ms
     */
    public String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        int low = 1, high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str1)) {
                return false;
            }
        }
        return true;
    }
}
