package Medium;

/**
 * Given a list of positive integers, the adjacent integers will perform the float division.
 * For example, [2,3,4] -> 2 / 3 / 4.
 * However, you can add any number of parenthesis at any position to change the priority of operations.
 * You should find out how to add parenthesis to get the maximum result,
 * and return the corresponding expression in string format.
 * Your expression should NOT contain redundant parenthesis.
 * <p>
 * Example:
 * Input: [1000,100,10,2]
 * Output: "1000/(100/10/2)"
 * Explanation:
 * 1000/(100/10/2) = 1000/((100/10)/2) = 200
 * However, the bold parenthesis in "1000/((100/10)/2)" are redundant,
 * since they don't influence the operation priority. So you should return "1000/(100/10/2)".
 * <p>
 * Other cases:
 * 1000/(100/10)/2 = 50
 * 1000/(100/(10/2)) = 50
 * 1000/100/10/2 = 0.5
 * 1000/100/(10/2) = 2
 * <p>
 * Note:
 * The length of the input array is [1, 10].
 * Elements in the given array will be in range [2, 1000].
 * There is only one optimal division for each test case.
 *
 * @author sunyue
 * @version 1.0
 * @createOn 2017/9/3 16:28
 */
public class OptimalDivision {
    /**
     * X1 is always the numerator and X2 is always denominator.
     * The maximum is always X1/(X2/X3/X4) = (X1*X3*X4)/X2.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * Runtime: 7 ms
     */
    public String optimalDivision(int[] nums) {
        if (null == nums || nums.length == 0) return null;

        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);

        if (nums.length == 1) return sb.toString();
        if (nums.length == 2) return sb.append("/").append(nums[1]).toString();


        sb.append("/(").append(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            sb.append("/").append(nums[i]);
        }
        sb.append(")");
        return sb.toString();
    }
}

