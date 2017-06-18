package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * Tags： Backtracking
 *
 * @author sunyue
 * @version 1.0    2017/6/18 14:37
 */
public class PermutationsII {
    /**
     * 回溯法
     * 时间复杂度：O(n^2)
     * 空间复杂度： O(n)
     * 运行时间：9 ms
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // used记录每位数字的使用情况，跳过用过的数字
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
                used[i] = true;
                temp.add(nums[i]);
                backTrack(res, temp, nums, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
