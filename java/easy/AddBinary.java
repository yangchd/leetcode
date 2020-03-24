package com.yangchd.leetcode.easy;

/**
 * @author yangchd 2018/10/24
 *
 * 67.Add Binary
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 */
public class AddBinary {
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int m = a.length() - 1;
            int n = b.length() - 1;
            int carry = 0;
            while (m >= 0 || n >= 0) {
                int sum = carry;
                if (m >= 0) {
                    sum += a.charAt(m--) - '0';
                }
                if (n >= 0) {
                    sum += b.charAt(n--) - '0';
                }
                sb.append(sum % 2);
                carry = sum / 2;
            }
            if (carry != 0) {
                sb.append(carry);
            }
            return sb.reverse().toString();
        }
    }
}
