package com.yangchd.leetcode.medium;

/**
 * @author yangchd  2018/11/2.
 *
 * 74.Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Example 1:
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 *
 * Example 2:
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 *
 */
public class SearchA2DMatrix {
    /**
     * 这个题要特别注意查找效率问题，直接遍历肯定会超时
     * 可以把整个矩阵看成一个数列来二分查找，也可以先确定具体在哪一行，然后二分查找
     */
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length <= 0 || matrix[0].length <= 0) {
                return false;
            }
            int index = 0;
            while (index < matrix.length) {
                if (target < matrix[index][0]) {
                    return false;
                }
                if (target >= matrix[index][0] && target <= matrix[index][matrix[0].length - 1]) {
                    int low = 0;
                    int high = matrix[0].length - 1;
                    return find(matrix[index], low, high, target);
                }
                index++;
            }
            return false;
        }

        /**
         * 使用二分查找，提高效率
         */
        private boolean find(int[] a, int low, int high, int target) {
            if (low > high) {
                return false;
            }
            int middle = (low + high) / 2;
            if (target == a[middle]) {
                return true;
            }
            if (target < a[middle]) {
                return find(a, low, middle - 1, target);
            } else {
                return find(a, middle + 1, high, target);
            }
        }
    }
}
