package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 *
 * @author sunyue
 * @version 1.0    2017/7/5 21:01
 */
public class PermutationSequence {
    /**
     * https://discuss.leetcode.com/topic/17348/explain-like-i-m-five-java-solution-in-o-n/2
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 运行时间: 20 ms
     */
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int[] factrial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        int sum = 1;
        factrial[0] = 1;
        // factorial[] = {1, 1, 2, 6, 24, ... n!}
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factrial[i] = sum;
        }

        // nums = {1, 2, 3, 4}
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        k--;
        for (int i = 1; i <= n; i++) {
            int index = k / factrial[n - i];
            sb.append(String.valueOf(nums.get(index)));
            nums.remove(index);
            k -= index * factrial[n - i];
        }

        return sb.toString();
    }
}
