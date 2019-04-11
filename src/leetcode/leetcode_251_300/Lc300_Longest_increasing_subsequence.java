package leetcode.leetcode_251_300;

import java.util.Arrays;

/**
 *Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class Lc300_Longest_increasing_subsequence {

    /**
     * n^2 solution
     * count the smaller element before current!
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] >nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }



    /**
     * nlogn solution!
     * use dp to record the first index
     * in dp that elements in dp first larger
     * than nums[i]
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i ++) {
            int index = Arrays.binarySearch(dp, nums[i]);
            if (index < 0) index = -(index + 1);
            dp[index] = nums[i];
        }

        for (int i = nums.length; i >= 1 ; i --) {
            if (dp[i] != Integer.MAX_VALUE) return i;
        }
        return 0;
    }

}
