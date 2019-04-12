package leetcode.leetcode_1to50;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 *
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 *
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 *
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 */
public class Lc44_Wildcard_Matching_DP {
    /**
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int sl = s.length(), pl = p.length();
        boolean[][] dp = new boolean[sl + 1][pl + 1];

        dp[0][0] = true;

        for (int i = 1; i <= pl; i ++)
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';

        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j<= pl; j ++) {
                char sc = s.charAt(i - 1), pc = p.charAt(j - 1);
                if (sc == pc || pc == '?') dp[i][j] = dp[i - 1][j - 1];
                else if (pc == '*') dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
            }
        }
        return dp[sl][pl];
    }
}
