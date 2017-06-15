package Easy;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Tags: Array, Two Pointers
 *
 * @author sunyue
 * @version 1.0    2017/2/22 19:33
 */
public class RemoveElement {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 运行时间: 12 ms
     */
    public int removeElement(int[] nums, int val) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}
