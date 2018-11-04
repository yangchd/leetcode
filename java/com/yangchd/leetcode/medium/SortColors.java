package com.yangchd.leetcode.medium;

/**
 * @author yangchd 2018/11/4
 *
 * 75.Sort Colors
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 *
 */
public class SortColors {
    /**
     * 这种有确定种类的排序，可以直接采用计数赋值的方法
     */
    class Solution {
        public void sortColors(int[] nums) {
            int red = 0;
            int white = 0;
            int blue = 0;
            for (int num : nums) {
                if (num == 0) {
                    red++;
                }
                if (num == 1) {
                    white++;
                }
                if (num == 2) {
                    blue++;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (i < red) {
                    nums[i] = 0;
                } else if (i >= red && i < red + white) {
                    nums[i] = 1;
                } else if (i >= red + white && i < red + white + blue) {
                    nums[i] = 2;
                }
            }
        }
    }
}
