package Hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 *
 * @author sunyue
 * @version 1.0  2017/10/28 12:19
 */
public class LargestRectangleinHistogram {
    /**
     * Divide and Conquer
     * Find the minimum, then the max area is maximum of following three values:
     * (1) Maximum area in left area side of minimum value (not including the minimum)
     * (2) Maximum area in right area side of minimum value (not including the minimum)
     * (3) Number of bars multiplied by minimum value
     * Time Complexity: O(n Log n)
     * Space Complexity: O(1)
     * Runtime: StackOverflowError
     */
    public int largestRectangleArea(int[] heights) {
        if (null == heights || heights.length == 0) return 0;
        return maxArea(heights, 0, heights.length - 1);
    }

    private int maxArea(int[] height, int start, int end) {
        if (start > end) return -1;
        if (start == end) return height[start];
        int min = getMinimum(height, start, end);
        return Math.max(Math.max(maxArea(height, start, min - 1), maxArea(height, min + 1, end)),
                (end - start + 1) * height[min]);
    }

    private int getMinimum(int[] height, int start, int end) {
        int min = height[start];
        int ret = start;
        for (int i = start + 1; i <= end; i++) {
            if (height[i] < min) {
                min = height[i];
                ret = i;
            }
        }
        return ret;
    }

    /**
     * Stack-based solution
     * https://discuss.leetcode.com/topic/7599/o-n-stack-based-java-solution
     * Time Complexity: O(n Log n)
     * Space Complexity: O(1)
     * Runtime: 20ms
     */
    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) stack.push(i);
            else {
                int tp = stack.pop();
                max = Math.max(max, heights[tp] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
                i--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleinHistogram l = new LargestRectangleinHistogram();
        System.out.println(l.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
