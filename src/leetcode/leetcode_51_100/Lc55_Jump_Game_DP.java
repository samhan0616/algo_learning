package leetcode.leetcode_51_100;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 */
public class Lc55_Jump_Game_DP {
    /**
     * We used dp to solve this question
     * the formula is dp[i] = Math.max(dp[i - 1] -1, nums[i])
     * means dp[i] represent the largest distance we can reach
     * so when dp[i] = 0 means we cannot jump anymore
     * and we do not have check the last stone so we loop from 1 to the nums.length - 2
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return true;
        }
        if(nums[0] == 0){
            return false;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        //loop to the second from the right
        for (int i = 1; i < nums.length - 1; i ++) {
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
            if (dp[i] == 0) return false;
        }
        return true;
    }
}
