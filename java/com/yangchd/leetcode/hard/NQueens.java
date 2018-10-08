package com.yangchd.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangchd  2018/9/29.
 *
 * 51. N-Queens
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Example:
 * Input: 4
 * Output: [
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
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 *
 */
public class NQueens {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            char[][] s = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    s[i][j] = '.';
                }
            }
            List<List<String>> res = new ArrayList<List<String>>();
            dfs(s, 0, res);
            return res;
        }

        private void dfs(char[][] s, int row, List<List<String>> res) {
            if (row == s.length) {
                res.add(getList(s));
                return;
            }
            for (int i = 0; i < s.length; i++) {
                if (validate(s, row, i)) {
                    s[row][i] = 'Q';
                    dfs(s, row + 1, res);
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

        private List<String> getList(char[][] s) {
            List<String> list = new ArrayList<String>();
            for (char[] chs : s) {
                String str = new String(chs);
                list.add(str);
            }
            return list;
        }
    }
}
