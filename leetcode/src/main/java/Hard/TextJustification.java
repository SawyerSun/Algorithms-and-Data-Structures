package Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunyue
 * @version 1.0    2017/7/16 8:58
 */
public class TextJustification {
    /**
     * https://discuss.leetcode.com/topic/9147/simple-java-solution/2
     * Time Complexity: O(n * l)
     * Space Complexity: O(1)
     * Runtime: 1 ms
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();

        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                // middle justified
                int spaces = (maxWidth - count) / diff;
                int r = (maxWidth - count) % diff;
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            lines.add(sb.toString());
            index = last;
        }
        return lines;
    }
}
