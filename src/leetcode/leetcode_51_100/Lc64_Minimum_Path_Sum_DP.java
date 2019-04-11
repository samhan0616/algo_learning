package leetcode.leetcode_51_100;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class Lc64_Minimum_Path_Sum_DP {
    /**
     * Typical DP Max/Min question
     * Once you move to (m, n), your last step
     * must be either (m-1, n) OR (m, n -1)
     * so you current minimum path is
     * Math.max((m-1, n), (m, n -1)) + gird[m][n]
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m ; i ++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j== 0) continue;
                grid[i][j] = Math.min(i == 0 ? Integer.MAX_VALUE : grid[i - 1][j] ,
                        j == 0 ? Integer.MAX_VALUE : grid[i][j - 1])
                        + grid[i][j];
            }
        }
        return grid[m - 1][n - 1];
    }
}
