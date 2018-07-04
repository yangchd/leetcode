package com.yangchd.leetcode.medium;

/**
 * @author yangchd  2018/7/4.
 *
 * 34. Search for a Range
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 */
public class SearchForARange {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length < 2) {
                if (nums.length == 1 && nums[0] == target) {
                    return new int[]{0, 0};
                } else {
                    return new int[]{-1, -1};
                }
            }
            int find = -1;
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int middle = (low + high) / 2;
                if (nums[middle] == target) {
                    find = middle;
                    break;
                }
                if (nums[middle] > target) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }
            int[] index = new int[2];
            if (find != -1) {
                int left = find;
                int right = find;
                while (left >= 0 && nums[left] == target) {
                    left--;
                }
                index[0] = left + 1;
                while (right <= nums.length - 1 && nums[right] == target) {
                    right++;
                }
                index[1] = right - 1;
            } else {
                index = new int[]{-1, -1};
            }
            return index;
        }
    }
}
