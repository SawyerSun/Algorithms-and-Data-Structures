package Hard;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * <p>
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * <p>
 * Tags： Array, Stack, Two Pointers
 *
 * @author sunyue
 * @version 1.0    2017/6/11 19:42
 */
public class TrappingRainWater {
    /**
     * 计算左右最大值为栅栏，可以储水。每个位置可以储存的水量为较低的栅栏高度减去当前点的高度。
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 运行时间: 32 ms
     */
    public int trap(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int sum = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (low <= high) {
            leftMax = Math.max(leftMax, height[low]);
            rightMax = Math.max(rightMax, height[high]);
            if (leftMax < rightMax) {
                sum += (leftMax - height[low]);
                low++;
            } else {
                sum += (rightMax - height[high]);
                high--;
            }
        }
        return sum;
    }
}
