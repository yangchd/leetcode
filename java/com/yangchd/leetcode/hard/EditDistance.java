package com.yangchd.leetcode.hard;

/**
 * @author yangchd 2018/10/31
 *
 * 72.Edit Distance
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * Example 1:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 *  Example 2:
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class EditDistance {
    /**
     * 经典的DP算法
     * 用二阶矩阵来记录每一步的可能
     */
    class Solution {
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 0; i < word1.length() + 1; i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j < word2.length() + 1; j++) {
                dp[0][j] = j;
            }
            for (int m = 1; m < word1.length() + 1; m++) {
                for (int n = 1; n < word2.length() + 1; n++) {
                    if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
                        dp[m][n] = dp[m - 1][n - 1];
                    } else {
                        dp[m][n] = Math.min(dp[m - 1][n - 1], Math.min(dp[m][n - 1], dp[m - 1][n])) + 1;
                    }
                }
            }
            return dp[word1.length()][word2.length()];
        }
    }
}
