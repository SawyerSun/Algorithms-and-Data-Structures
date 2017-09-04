package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,3], a solution is:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 * @author sunyue
 * @version 1.0
 * @createOn 2017/9/4 22:16
 */
public class Subsets {
    /**
     * Backtracking
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     * Runtime: 3  ms
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sets = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(sets, new ArrayList<>(), nums, 0, nums.length);
        return sets;
    }

    private void backtrack(List<List<Integer>> sets, List<Integer> set, int[] nums, int start, int end) {
        sets.add(new ArrayList<>(set));
        for (int i = start; i < end; i++) {
            set.add(nums[i]);
            backtrack(sets, set, nums, i + 1, end);
            set.remove(set.size() - 1);
        }
    }
}
