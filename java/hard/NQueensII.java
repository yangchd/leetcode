package com.yangchd.leetcode.hard;

/**
 * @author yangchd  2018/10/10.
 *
 * 52. N-Queens II
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example:
 * Input: 4
 * Output: 2
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 *
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 *
 */
public class NQueensII {
    class Solution {
        public int totalNQueens(int n) {
            char[][] s = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    s[i][j] = '.';
                }
            }
            int[] count = new int[1];
            dfs(s, 0, count);
            return count[0];
        }

        private void dfs(char[][] s, int row, int[] count) {
            if (row == s.length) {
                count[0] += 1;
                return;
            }
            for (int i = 0; i < s.length; i++) {
                if (validate(s, row, i)) {
                    s[row][i] = 'Q';
                    dfs(s, row + 1, count);
                    s[row][i] = '.';
                }
            }
        }

        private boolean validate(char[][] s, int x, int y) {
            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < s.length; j++) {
                    if (i == x && j == y) {
                        continue;
                    }
                    if ((j == y || Math.abs(i - x) == Math.abs(j - y)) && s[i][j] == 'Q') {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
