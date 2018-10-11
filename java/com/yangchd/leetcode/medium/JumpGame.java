package com.yangchd.leetcode.medium;

/**
 * @author yangchd  2018/10/11.
 *
 * 55. Jump Game
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 *
 */
public class JumpGame {
    public class Solution {
        public boolean canJump(int[] nums) {
            int index = 0;
            int step = nums[0];
            if (step >= nums.length - 1) {
                return true;
            }
            while (step > 0) {
                index++;
                step--;
                if (index == nums.length - 1) {
                    return true;
                }
                step = Math.max(step, nums[index]);
            }
            return false;
        }
    }
}
