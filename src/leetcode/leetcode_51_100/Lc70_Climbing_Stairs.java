package leetcode.leetcode_51_100;

import java.util.Arrays;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class Lc70_Climbing_Stairs {
    /**
     * this is just a fibonacci
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[2];
        Arrays.fill(dp, 1);
        fb(n - 1,dp);
        return dp[1];
    }

    void fb(int n, int[] dp) {
        if (n == 0) return;
        int temp = dp[0] + dp[1];
        dp[0] = dp[1];
        dp[1] = temp;
        fb(n - 1, dp);
    }

}