package com.yangchd.exercise.leetcode.easy;

/**
 * @author yangchd  2018/4/3.
 *
 * 7. Reverse Integer
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Example 1:
 * Input: 123
 * Output:  321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 *
 * Note:
 * Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    class Solution {

        /**
         * 通过相加以后的值不相等判断越界
         */
        public int reverse(int x) {
            int result = 0;

            while (x != 0) {
                int tail = x % 10;
                int newResult = result * 10 + tail;
                if ((newResult - tail) / 10 != result) {
                    return 0;
                }
                result = newResult;
                x = x / 10;
            }

            return result;
        }

        /**
         * 遍历，通过异常判断越界
         */
        public int sulutionOne(int x) {
            if(x==0) {
                return x;
            }
            int i = x > 0 ? 1 : -1;

            String num = String.valueOf(Math.abs(x));
            StringBuilder sb = new StringBuilder();
            for (int m = num.length() - 1; m >= 0; m--) {
                sb.append(num.charAt(m));
            }
            try {
                x = Integer.valueOf(sb.toString()) * i;
            } catch (Exception e) {
                x = 0;
            }
            return x;
        }
    }
}
