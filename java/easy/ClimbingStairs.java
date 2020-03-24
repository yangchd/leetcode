package com.yangchd.leetcode.easy;

/**
 * @author yangchd 2018/10/30
 *
 * 70.Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 *  Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 */
public class ClimbingStairs {
    class Solution {
        public int climbStairs(int n) {
            if (n <= 0) {
                return 0;
            }
            int i = 0;
            int step = 0;
            while (2 * i <= n) {
                step += Cmn(n - i, i);
                i++;
            }
            return step;
        }

        private int Cmn(int m, int n) {
            int index = 1;
            int middle = Math.min(m, n);
            int max = Math.max(m, n);
            long big = 1;
            for (int i = 1; i <= middle; i++) {
                big = big * (max - i + 1);
                while (big % index == 0 && index <= middle) {
                    big = big / index;
                    index++;
                }
            }
            return (int) big;
        }
    }
}
