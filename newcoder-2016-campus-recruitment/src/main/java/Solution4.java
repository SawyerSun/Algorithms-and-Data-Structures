import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * A string s is LUCKY if and only if the number of different characters in s is a fibonacci number.
 * 'Given a string consisting of only lower case letters , output all its lucky non-empty substrings in lexicographical order.
 * Same substrings should be printed once.
 * <p>
 * 输入描述:
 * a string consisting no more than 100 lower case letters.
 * <p>
 * 输出描述:
 * output the lucky substrings in lexicographical order.one per line. Same substrings should be printed once.
 * <p>
 * 输入例子:
 * aabcd
 * <p>
 * 输出例子:
 * a
 * aa
 * aab
 * aabc
 * ab
 * abc
 * b
 * bc
 * bcd
 * c
 * cd
 * d
 * <p>
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/18 11:08
 */
public class Solution4 {
    /**
     * 运行时间：78ms
     * 占用内存：755k
     */
    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        String s = in.next();

        // 构造fibonacci数set
        // 输入字符串不多于100，所以只需要构造100以内
        Set<Integer> fib = new HashSet<>();
        int a = 1;
        int b = 1;
        for (int i = 1; i <= 20; i++) {
            if (b > 100) break;
            fib.add(b);
            int sum = a + b;
            a = b;
            b = sum;
        }

        // 用来保存子串中的字符，set的size代表不同字符的个数
        Set<Character> temp = new HashSet<>();
        // treeSet用来排序结果
        Set<String> res = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            temp.add(s.charAt(i));
            for (int j = i; j < s.length(); j++) {
                if (j > i) temp.add(s.charAt(j));
                // 检查该数子是否是fibonacci数
                if (fib.contains(temp.size())) res.add(s.substring(i, j + 1));
            }
            temp.clear();
        }

        // 输出
        for (String s1 : res) {
            System.out.println(s1);
        }
    }
}
