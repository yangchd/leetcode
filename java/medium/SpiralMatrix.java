package com.yangchd.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangchd  2018/10/11.
 *
 * 54. Spiral Matrix
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 */
public class SpiralMatrix {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> list = new ArrayList<Integer>();
            addInteger(matrix, 0, list);
            return list;
        }

        private void addInteger(int[][] matrix, int time, List<Integer> list) {
            int high = matrix.length - 2 * time;
            if (high <= 0) {
                return;
            }
            int width = matrix[0].length - 2 * time;
            if (width <= 0) {
                return;
            }
            if (high == 1) {
                for (int line = 0; line < width; line++) {
                    list.add(matrix[time][time + line]);
                }
                return;
            }
            if (width == 1) {
                for (int col = 0; col < high; col++) {
                    list.add(matrix[time + col][time]);
                }
                return;
            }
            // 上边
            for (int top = 0; top < width - 1; top++) {
                list.add(matrix[time][top + time]);
            }
            // 右边
            for (int right = 0; right < high - 1; right++) {
                list.add(matrix[right + time][width + time - 1]);
            }
            // 下边
            for (int bottom = time + width - 1; bottom > time; bottom--) {
                list.add(matrix[high + time - 1][bottom]);
            }
            // 左边
            for (int left = high + time - 1; left > time; left--) {
                list.add(matrix[left][time]);
            }
            addInteger(matrix, time + 1, list);
        }
    }
}
