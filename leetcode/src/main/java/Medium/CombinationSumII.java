package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * Each number in C may only be used once in the combination.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * <p>
 * Tags: Array, Backtracking
 *
 * @author sunyue
 * @version 1.0    2017/6/7 21:21
 */
public class CombinationSumII {
    /**
     * 回溯法
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     * 运行时间：25ms
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                // 跳过重复
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                temp.add(candidates[i]);
                backTrack(res, temp, candidates, target - candidates[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
