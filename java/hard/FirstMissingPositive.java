package com.yangchd.leetcode.hard;

/**
 * @author yangchd  2018/8/3.
 *
 * 41. First Missing Positive
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 * Input: [1,2,0]
 * Output: 3
 *
 * Example 2:
 * Input: [3,4,-1,1]
 * Output: 2
 *
 * Example 3:
 * Input: [7,8,9,11,12]
 * Output: 1
 *
 * Note:
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int missing = 1;
            int oldmissing = 0;
            while (oldmissing != missing) {
                int i = 0;
                oldmissing = missing;
                while (i < nums.length) {
                    if (nums[i] == missing) {
                        missing++;
                    }
                    i++;
                }
            }
            return missing;
        }
    }
}
