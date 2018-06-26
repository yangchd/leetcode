package com.yangchd.leetcode.medium;

/**
 * @author yangchd  2018/6/26.
 *
 * 29. Divide Two Integers
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero.
 *
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 *
 * Example 2:
 * Input: dividend = 7, divisor = -3
 * Output: -2
 *
 * Note:
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 2^31 − 1 when the division result overflows.
 *
 */
public class DivideTwoIntegers {
    class Solution {
        public int divide(int dividend, int divisor) {
            boolean isDiff = false;
            if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
                isDiff = true;
            }
            long d1 = Math.abs((long) dividend);
            long d2 = Math.abs((long) divisor);
            long absDivisor = d2;
            long inc = 1;
            long res = 0;
            while (d1 >= d2) {
                d1 -= d2;
                res += inc;
                d2 <<= 1;
                inc <<= 1;
                while (d1 < d2 && d2 > absDivisor) {
                    d2 >>= 1;
                    inc >>= 1;
                }
            }
            if (res > Integer.MAX_VALUE) {
                return isDiff ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            return isDiff ? 0 - (int) res : (int) res;
        }
    }
}
