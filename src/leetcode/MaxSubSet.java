package leetcode;

import java.util.Arrays;

/**
 * @author create by Xiao Han 10/30/18
 * @version 1.0
 * @since jdk 1.8
 */
public class MaxSubSet {
  int res;
  public int maxSubArray(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, Integer.MIN_VALUE);
    if (nums.length > 0) {
      res = nums[0];
      helper(nums, dp, 0);
    } else {
      res = 0;
    }
    return res;
  }

  public int helper(int[] nums, int[] dp, int index) {
    if (index < 0 || index > dp.length - 1) {
      return 0;
    }

    if (dp[index] >= nums[index]) {
      return dp[index];
    } else {
      int part =  Math.max(helper(nums,dp,index-1) + nums[index], nums[index]);
      dp[index] = part;
      res = Math.max(res, part);
      return helper(nums,dp,index + 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(new MaxSubSet().maxSubArray(new int[]{-1}));
  }
}
