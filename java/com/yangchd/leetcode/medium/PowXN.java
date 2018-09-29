package com.yangchd.leetcode.medium;

/**
 * @author yangchd  2018/9/29.
 *
 * 50. Pow(x, n)
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 *
 * Example 1:
 * Input: 2.00000, 10
 * Output: 1024.00000
 *
 * Example 2:
 * Input: 2.10000, 3
 * Output: 9.26100
 *
 * Example 3:
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 *
 * Note:
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 */
public class PowXN {
    class Solution {
        public double myPow(double x, int n) {
            if (n >= 0) {
                if (n == 0) {
                    return 1;
                }
                if (n == 1) {
                    return x;
                }
                int count = 1;
                double result = x;
                while (count < n / 2) {
                    result = result * result;
                    count *= 2;
                }
                result = result * myPow(x, n - count);
                return result;
            }
            if (n == Integer.MIN_VALUE) {
                return 1 / myPow(x, Integer.MAX_VALUE) / x;
            }
            return 1 / myPow(x, Math.abs(n));
        }
    }
}
