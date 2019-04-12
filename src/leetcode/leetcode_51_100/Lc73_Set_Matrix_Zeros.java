package leetcode.leetcode_51_100;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * Example 2:
 *
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 */
public class Lc73_Set_Matrix_Zeros {
    /**
     * if you find an element in matrix is 0
     * update the top and left edge is zero
     * when the element on the edge is zero
     * then mark them
     * start from 1, 1 instead of 0, 0
     * update all element according to the
     * top and lef edges
     * finally update top and left edges
     * if initially there are zeros
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0  || matrix[0].length == 0) return ;

        int m = matrix.length, n = matrix[0].length;

        boolean top = false, left = false;

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == 0 ) {
                    if (i == 0) top = true;
                    if (j == 0) left =true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                if (matrix[i][0] == 0 ) {
                    matrix[i][j] = 0;
                }
                if (matrix[0][j] == 0 ) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (top)
            for (int i = 0; i < n; i ++)
                matrix[0][i] = 0;

        if (left)
            for (int i = 0; i < m; i ++)
                matrix[i][0] = 0;

    }
}
