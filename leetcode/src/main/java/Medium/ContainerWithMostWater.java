package Medium;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical
 * lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container.
 * <p>
 * Tags: Array, Two Pointers
 *
 * @author sunyue
 * @version 1.0    2017/1/5 15:31
 */
public class ContainerWithMostWater {
    /**
     * 暴力方法，两轮遍历。
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     * 运行时间：Time Limit Exceeded
     */
    public int maxArea1(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }

    /**
     * 两个指针，同时向中间遍历。
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * Leetcode运行时间：7ms
     */
    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left],height[right]*(right-left)));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
