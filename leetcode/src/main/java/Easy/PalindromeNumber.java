package Easy;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <p>
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the
 * reversed integer might overflow. How would you handle such case?
 * There is a more generic way of solving this problem.
 * <p>
 * Tags: Math
 *
 * @author sunyue
 * @version 1.0    2017/1/4 13:58
 */
public class PalindromeNumber {
    /**
     * 'No extra space'意味着 O(1) 空间复杂度，而'extra space'通常意味着 O(n) 空间复杂度.
     * 时间复杂度：O(n)
     * Leetcode运行时间：13ms
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }
}
