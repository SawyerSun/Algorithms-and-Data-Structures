package Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>
 * UPDATE (2016/2/13):
 * The return format had been changed to zero-based indices. Please read the above updated description carefully.
 * <p>
 * Tags: Array, Hash Table
 *
 * @author sunyue
 * @version 1.0    2017/1/1 13:36
 */
public class TwoSum {
    /**
     * 两层循环，暴力遍历
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * Leetcode运行时间：39 ms
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * 使用HashMap存储每个数字，将第两层循坏转变成，在HashMap中寻找差值（O(1)时间复杂度）。空间换时间的概念体现。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * Leetcode运行时间：8 ms
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i <nums.length ; i++) {
            int complement = target - nums[i];
            // 预先存储所有num，这里需要判别差值是否是nums[i]本体
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i,map.get(complement)};
            }
        }
        return null;
    }

    /**
     * 对解法2的优化，两次遍历可以合并成一次。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * Leetcode运行时间：6 ms
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            int complement = target - nums[i];
            // 没有预先存储所有num，差值如果存在则肯定不是nums[i]本体
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            } else {
                map.put(nums[i],i);
            }
        }
        return null;
    }
}
