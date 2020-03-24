package com.yangchd.leetcode.easy;

/**
 * @author yangchd  2018/10/10.
 *
 * 53. Maximum Subarray
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int cur = 0;
            int large = Integer.MIN_VALUE;
            for (int num : nums) {
                cur = Math.max(cur + num, num);
                large = Math.max(large, cur);
            }
            return large;
        }
    }
}
