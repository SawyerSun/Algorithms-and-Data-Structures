package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 * Tags: Array, Backtracking
 *
 * @author sunyue
 * @version 1.0    2017/5/27 20:39
 */
public class CombinationSum {
    /**
     * 回溯法
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     * Leetcode运行时间：30ms
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int start) {
        if (target < 0) return;
        else if (target == 0) res.add(new ArrayList<>(temp));
        else {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                backTrack(res, temp, candidates, target - candidates[i], i); // 仍然从i开始，因为可以重复
                // 回溯
                temp.remove(temp.size() - 1);
            }
        }
    }
}
