package com.yangchd.exercise.leetcode.easy;

/**
 * @author yangchd  2018/4/17.
 *
 * 9. Palindrome Number
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 * Input: 121
 * Output: true
 *
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Follow up:
 * Coud you solve it without converting the integer to a string?
 */
public class PalindromeNumber {
    class Solution {
        /**
         * 这个是转成String进行校验
         */
        public boolean isPalindrome(int x) {
            if (x == 0) {
                return true;
            }
            if (x < 0) {
                return false;
            }
            String str = String.valueOf(x);
            int length = str.length();
            for (int i = 0; i < (length - i - 1); i++) {
                if (str.charAt(i) != str.charAt(length - i - 1)) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 不用转换成String，转换一半，然后两边相比较
         */
        public boolean solutionOne(int x) {
            if (x < 0 || (x != 0 && x % 10 == 0)) {
                return false;
            }
            int rev = 0;
            while (x > rev) {
                rev = rev * 10 + x % 10;
                x = x / 10;
            }
            return (x == rev || x == rev / 10);
        }
    }
}
