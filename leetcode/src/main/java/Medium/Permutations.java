package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * Tags: Backtracking
 *
 * @author sunyue
 * @version 1.0    2017/6/18 14:17
 */
public class Permutations {
    /**
     * 回溯法
     * 时间复杂度：O(n^2)
     * 空间复杂度： O(n)
     * 运行时间：8 ms
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, new ArrayList<>(), nums);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // 跳过重复
                if (temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                backTrack(res, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
