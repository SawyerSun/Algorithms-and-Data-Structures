package Medium;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * <p>
 * Tags： Array
 *
 * @author sunyue
 * @version 1.0    2017/2/28 14:16
 */
public class NextPermutation {
    /**
     * 在当前序列中，从尾端往前寻找两个相邻元素，前一个记为first，后一个记为second，并且满足first 小于 second。
     * 然后再从尾端寻找另一个元素number，如果满足first 小于number，即将第first个元素与number元素对调，
     * 并将second元素之后（包括second）的所有元素颠倒排序，即求出下一个序列
     *
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * Runtime: 23 ms
     */
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        int i = nums.length - 1;
        for (; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) break;
        }
        if (i != 0) {
            swap(nums, i - 1);
        }
        reverse(nums, i);
    }

    private void swap(int[] a, int i) {
        for (int j = a.length - 1; j > i; j--) {
            if (a[j] > a[i]) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                break;
            }
        }
    }

    private void reverse(int[] a, int i) {
        int first = i;
        int last = a.length - 1;
        while (first < last) {
            int t = a[first];
            a[first] = a[last];
            a[last] = t;
            first++;
            last--;
        }
    }
}
