package Easy;

/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * @author sunyue
 * @version 1.0    2017/7/10 22:27
 */
public class PlusOne {
    /**
     * Plus one from end to start
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Runtime: 1 ms
     */
    public int[] plusOne(int[] digits) {
        int l = digits.length;
        for (int i = l - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                // break the loop
                return digits;
            }
            // 9+1 = 10
            digits[i] = 0;
        }
        // 99+1 = 100
        int[] res = new int[l + 1];
        res[0] = 1;
        return res;
    }
}
