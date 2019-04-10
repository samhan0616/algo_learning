package leetcode.leetcode_1to50;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Lc1_TwoSum {
    /**
     * use hashmap store the previous integer
     * use the concept of presum, although we did not sum up the
     * numbers!
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        //key : sum
        //value: index
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
