package com.yangchd.leetcode.medium;

/**
 * @author yangchd  2018/11/13.
 *
 * 81. Search in Rotated Sorted Array II
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 *
 * Example 2:
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 *
 * Follow up:
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 *
 */
public class SearchInRotatedSortedArrayII {
    /**
     * 旋转的二分查找
     * 通过中间值与最左边的值大小比较，找出一定递增的区间，然后判断
     * 如果中间值与左边相等，抛弃左边的值，从新确定区间
     */
    class Solution {
        public boolean search(int[] nums, int target) {
            if (null == nums || nums.length <= 0) {
                return false;
            }
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] == target) {
                    return true;
                }
                if (nums[mid] > nums[low]) {
                    if (target >= nums[low] && target < nums[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else if (nums[mid] < nums[low]) {
                    if (target > nums[mid] && target <= nums[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                } else {
                    low++;
                }
            }
            return false;
        }
    }
}
