package Easy;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * <p>
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * <p>
 * Note: The sequence of integers will be represented as a string.
 * <p>
 * Tags: String
 *
 * @author sunyue
 * @version 1.0    2017/5/26 21:37
 */
public class CountandSay {
    public String countAndSay(int n) {
        StringBuilder cur = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i = 1; i < n; i++) {
            prev = cur;
            cur = new StringBuilder();
            count = 1;
            say = prev.charAt(0);
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) != say) {
                    cur.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                } else count++;
            }
            cur.append(count).append(say);
        }
        return cur.toString();
    }
}
