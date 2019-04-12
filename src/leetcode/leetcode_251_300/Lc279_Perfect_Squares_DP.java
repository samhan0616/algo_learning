package leetcode.leetcode_251_300;

import java.util.Arrays;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class Lc279_Perfect_Squares_DP {
    /**
     * dp solution
     * dp[i] means the least number of perfect square numbers to form i
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {

        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;

        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j*j <= i; j++) {
                //to form i we used j*j so we have to plus 1 here
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}