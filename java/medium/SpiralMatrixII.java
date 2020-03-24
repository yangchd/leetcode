package com.yangchd.leetcode.medium;

/**
 * @author yangchd 2018/10/14
 *
 * 59.Spiral Matrix II
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 */
public class SpiralMatrixII {
    class Solution {
        public int[][] generateMatrix(int n) {
            if (n <= 0) {
                return new int[0][0];
            }
            int[][] a = new int[n][n];
            setNum(a, 0, 1);
            return a;
        }

        private void setNum(int[][] a, int time, int num) {
            int width = a.length - 2 * time - 1;
            if (width <= 0) {
                if (width == 0) {
                    a[time][time] = num;
                    return;
                } else {
                    return;
                }
            }
            for (int top = time; top < time + width; top++) {
                a[time][top] = num++;
            }
            for (int right = time; right < time + width; right++) {
                a[right][time + width] = num++;
            }
            for (int bottom = time + width; bottom > time; bottom--) {
                a[time + width][bottom] = num++;
            }
            for (int left = time + width; left > time; left--) {
                a[left][time] = num++;
            }
            setNum(a, time + 1, num);
        }
    }
}
