package Medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 * <p>
 * Tags: Backtracking, String
 *
 * @author sunyue
 * @version 1.0    2017/1/8 17:05
 */
public class LetterCombinationsofaPhoneNumber {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * Leetcode运行时间：1 ms
     */
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (null == digits || digits.length() == 0) {
            return res;
        }
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i) {
                String s = res.remove();
                for (char c : mapping[x].toCharArray()) {
                    res.add(s + c);
                }
            }
        }
        return res;
    }
}
