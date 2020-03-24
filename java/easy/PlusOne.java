package com.yangchd.leetcode.easy;

/**
 * @author yangchd 2018/10/23
 *
 * 66.Plus One
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 *  Example 2:
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 */
public class PlusOne {
    /**
     * 使用进位作为循环结束的判断
     */
    class Solution {
        public int[] plusOne(int[] digits) {
            int index = digits.length - 1;
            if (index < 0) {
                return digits;
            }
            digits[index] += 1;
            if (digits[index] >= 10) {
                digits[index--] -= 10;
                int carry = 1;
                while (carry > 0) {
                    if (index < 0) {
                        int[] temp = new int[digits.length + 1];
                        temp[0] = 1;
                        System.arraycopy(digits, 0, temp, 1, digits.length);
                        return temp;
                    } else {
                        digits[index] += 1;
                        if (digits[index] >= 10) {
                            digits[index--] -= 10;
                        } else {
                            carry = 0;
                        }
                    }
                }
            }
            return digits;
        }
    }
}
