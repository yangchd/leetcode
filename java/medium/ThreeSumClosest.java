package com.yangchd.leetcode.medium;

import java.util.Arrays;

/**
 * @author yangchd  2018/6/6.
 *
 * 16. 3Sum Closest
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int result = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length - 2; i++) {
                int sum = target - nums[i];
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        return target;
                    }
                    if (Math.abs(result - target) > Math.abs(nums[i] + nums[left] + nums[right] - target)) {
                        result = nums[i] + nums[left] + nums[right];
                    }
                    if (nums[left] + nums[right] < sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return result;
        }
    }
}
