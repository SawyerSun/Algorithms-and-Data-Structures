package Hard;

/**
 * Validate if a given string is numeric.
 * <p>
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous.
 * You should gather all requirements up front before implementing one.
 *
 * @author sunyue
 * @version 1.0    2017/7/11 20:21
 */
public class ValidNumber {
    /**
     * The description is ambiguous !
     * Valid Number: [-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Runtime: 4 ms
     */
    public boolean isNumber(String s) {
        s = s.trim();
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = false;

        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) return false;
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberAfterE) return false;
                numberAfterE = false;
                eSeen = true;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else return false;
        }
        return numberSeen && numberAfterE;
    }
}

