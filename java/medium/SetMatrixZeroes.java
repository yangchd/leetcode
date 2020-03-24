package com.yangchd.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangchd 2018/10/31
 *
 * 73.Set Matrix Zeroes
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
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
 *
 * Example 2:
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
 *
 * Follow up:
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 */
public class SetMatrixZeroes {
    /**
     * 找出所有0所在的行和列，然后在赋值
     */
    class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            Set<Integer> x = new HashSet<Integer>();
            Set<Integer> y = new HashSet<Integer>();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        x.add(i);
                        y.add(j);
                    }
                }
            }
            for (int i : x) {
                for (int m = 0; m < matrix[0].length; m++) {
                    matrix[i][m] = 0;
                }
            }
            for (int j : y) {
                for (int n = 0; n < matrix.length; n++) {
                    matrix[n][j] = 0;
                }
            }
        }
    }
}
