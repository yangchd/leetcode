package com.yangchd.exercise.leetcode.easy;

import java.util.HashMap;

/**
 * @author yangchd  2018/3/20.
 *
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    /**
     * 将输入转换成哈希，通过索引提高速度
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int num = target - nums[j];
            if (numMap.containsKey(num) && numMap.get(num) != j) {
                return new int[]{j, numMap.get(num)};
            }
        }
        return null;
    }

}
