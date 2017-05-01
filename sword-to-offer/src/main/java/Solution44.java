/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。正确的句子应该是“I am a student.”。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/1 14:10
 */
public class Solution44 {
    /**
     * 运行时间：33ms
     * 占用内存：636k
     */
    public String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        StringBuilder res = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ' ') {
                res.insert(0, " " + tmp);
                tmp = new StringBuilder();
            } else tmp.append(aChar);
        }
        if (tmp.length() != 0) res.insert(0, tmp);
        return res.toString();
    }
}
