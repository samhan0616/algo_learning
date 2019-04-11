package leetcode.leetcode_51_100;

/**
 *  robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 *
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class Lc63_Unique_PathII {
    /**
     * the only difference is calculate the edges first
     * if the previous is obstacle, there is no way to pass
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] path = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1)  {
                path[i][0] = 0;
                //on the first column, if there is an obstacle, the rest are blocked.
                //no need to continue.
                break;
            } else
                path[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1)  {
                path[0][j] = 0;
                //First row, once obstacle found, the rest are blocked.
                break;
            } else
                path[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    path[i][j] = 0;
                else
                    path[i][j] = path[i-1][j] + path[i][j-1];
            }
        }
        return path[m-1][n-1];
    }
}
