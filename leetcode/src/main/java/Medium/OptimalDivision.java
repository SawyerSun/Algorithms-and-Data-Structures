package Medium;

/**
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

