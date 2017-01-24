/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 时间限制：1s
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0 2017/1/22 下午9:32
 */
public class Solution2 {
    /**
     * 直接调用string的replace函数。。。
     * 若用C语言：可以先遍历出空格的数量，新字符串长度等于原先长度+2*空格数。使用两个指针遍历复制，遇到空格，插入"%20",指针p2前进3格。
     * 运行时间：36ms
     * 占用内存：636k
     */
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }
}
