package com.yangchd.leetcode.medium;

/**
 * @author yangchd  2018/10/17.
 *
 * 62.Unique Paths
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 *
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * Note: m and n will be at most 100.
 *
 * Example 1:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 * Example 2:
 * Input: m = 7, n = 3
 * Output: 28
 */
public class UniquePaths {
    class Solution {
        public int uniquePaths(int m, int n) {
            if (m < 1 || n < 1) {
                return 0;
            }
            int right = m - 1;
            int down = n - 1;
            int sum = right + down;
            int index = Math.min(right, down);
            double top = 1.0;
            double bottom = 1.0;
            while (index >= 1) {
                top = top * (sum - index + 1);
                bottom = bottom * index;
                index--;
            }
            return (int) (top / bottom);
        }
    }
}
