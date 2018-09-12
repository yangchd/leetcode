package com.yangchd.leetcode.hard;

/**
 * @author yangchd  2018/9/12.
 *
 * 45. Jump Game II
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Note:
 * You can assume that you can always reach the last index.
 */
public class JumpGameII {
    class Solution {
        public int jump(int[] nums) {
            int sc = 0;
            int e = 0;
            int max = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                max = Math.max(max, i + nums[i]);
                if (i == e) {
                    sc++;
                    e = max;
                }
            }
            return sc;
        }
    }
}
