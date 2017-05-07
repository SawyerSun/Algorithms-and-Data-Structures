/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * @author sunyue
 * @version 1.0    2017/5/7 21:11
 */
public class Solution52 {
    /**
     * 运行时间：32ms
     占用内存：629k
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;
        int strIndex = 0;
        int patternIndex = 0;
        return helper(str, strIndex, pattern, patternIndex);
    }

    private boolean helper(char[] str, int strIndex, char[] pattern, int patternIndex) {
        // 都到尾了，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) return true;
        // pattern到尾部，匹配不成功
        if (strIndex != str.length && patternIndex == pattern.length) return false;
        // pattern第2位为*，且str第1位和pattern第1位匹配，分三种情况
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if (strIndex != str.length && pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return helper(str, strIndex, pattern, patternIndex + 2) ||  // X* 匹配 0个 字符
                        helper(str, strIndex + 1, pattern, patternIndex + 2) || // X* 匹配 1个 字符
                        helper(str, strIndex + 1, pattern, patternIndex);   // X* 匹配 2个 字符，当前1个，再加下一个
            } else return helper(str, strIndex, pattern, patternIndex + 2);  // 都不匹配
        }
        // pattern第2位不是*，且str第1位和pattern第1位匹配，则都后移1位
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return helper(str, strIndex + 1, pattern, patternIndex + 1);
        }
        // 不匹配直接返回false
        return false;
    }
}
