/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当
 * 从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/10 20:22
 */
public class Solution54 {
    /**
     * 一个字符占8位，因此不会超过256个，可以申请一个256大小的数组来实现一个简易的哈希表。
     * 运行时间：31ms
     * 占用内存：636k
     */
    int[] buffer = new int[256];
    StringBuilder sb = new StringBuilder();

    //Insert one char from stringstream
    public void Insert(char ch) {
        sb.append(ch);
        if (buffer[ch] == 0) buffer[ch] = 1;
        else buffer[ch] += 1;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char[] str = sb.toString().toCharArray();
        for (char c : str) {
            if (buffer[c] == 1) return c;
        }
        return '#';
    }
}
