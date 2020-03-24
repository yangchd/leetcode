package com.yangchd.leetcode.easy;

/**
 * @author yangchd  2018/7/5.
 *
 * 35. Search Insert Position
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 *
 */
public class SearchInsertPosition {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums.length < 1) {
                return 0;
            }
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int index = (low + high) / 2;
                if (nums[index] == target) {
                    return index;
                }
                if (nums[index] > target) {
                    high = index - 1;
                } else {
                    low = index + 1;
                }
            }
            return low;
        }
    }
}
