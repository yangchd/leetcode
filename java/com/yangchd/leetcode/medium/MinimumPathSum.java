package com.yangchd.leetcode.medium;

/**
 * @author yangchd 2018/10/21
 *
 * 64.Minimum Path Sum
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
public class MinimumPathSum {
    class Solution {
        public int minPathSum(int[][] grid) {
            if (grid.length <= 0 || grid[0].length <= 0) {
                return 0;
            }
            int x = grid.length;
            int y = grid[0].length;
            int[][] dp = new int[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = grid[i][i];
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    } else if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    } else {
                        dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                    }
                }
            }
            return dp[x - 1][y - 1];
        }
    }
}
