package com.yangchd.leetcode.medium;

/**
 * @author yangchd  2018/7/3.
 *
 * 33. Search in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 */
public class SearchInRotatedSortedArray {
    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length <= 0) {
                return -1;
            }
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int middle = low + (high - low) / 2;
                if (nums[middle] == target) {
                    return middle;
                }
                if (nums[low] > nums[middle]) {
                    if (nums[middle] < target && target <= nums[high]) {
                        low = middle + 1;
                    } else {
                        high = middle - 1;
                    }
                } else {
                    if (target < nums[middle] && target >= nums[low]) {
                        high = middle - 1;
                    } else {
                        low = middle + 1;
                    }
                }
            }
            return -1;
        }
    }
}
