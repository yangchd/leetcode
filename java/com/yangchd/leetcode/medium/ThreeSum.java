package com.yangchd.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangchd  2018/4/28.
 *
 * 15. 3Sum
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 */
public class ThreeSum {
    class Solution {

        /**
         * 这个就是比较容易超时
         */
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> rList = new ArrayList<List<Integer>>();

            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) {
                    return rList;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int sum = -nums[i];
                int left = i + 1, right = nums.length - 1;

                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        ArrayList<Integer> triplet = new ArrayList<Integer>();
                        triplet.add(nums[i]);
                        triplet.add(nums[left]);
                        triplet.add(nums[right]);
                        rList.add(triplet);
                        while (left < right && nums[left++] == nums[left]) {}
                        while (left < right && nums[right--] == nums[right]) {}
                    } else if (nums[left] + nums[right] < sum) {
                        while (left < right && nums[left++] == nums[left]) {}
                    } else {
                        while (left < right && nums[right--] == nums[right]) {}
                    }
                }
            }
            return rList;
        }
    }
}
