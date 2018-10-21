package com.yangchd.leetcode.medium;

/**
 * @author yangchd 2018/10/21
 *
 * 63.Unique Paths II
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
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
 *
 */
public class UniquePathsII {

    /**
     * 后一步的可能是左上两部分相加
     */
    public class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (obstacleGrid[r][c] == 1) {
                        obstacleGrid[r][c] = 0;
                    } else {
                        if (r == 0 && c == 0) {
                            obstacleGrid[r][c] = 1;
                        } else if (r == 0) {
                            obstacleGrid[r][c] = obstacleGrid[r][c - 1];
                        } else if (c == 0) {
                            obstacleGrid[r][c] = obstacleGrid[r - 1][c];
                        } else {
                            obstacleGrid[r][c] = obstacleGrid[r][c - 1] + obstacleGrid[r - 1][c];
                        }
                    }
                }
            }
            return obstacleGrid[m - 1][n - 1];
        }
    }
}
