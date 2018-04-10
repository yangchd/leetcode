package com.yangchd.exercise.leetcode.medium;

/**
 * @author yangchd 2018/4/10
 *
 * 8. String to Integer (atoi)
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 *
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class StringToInteger {

    /**
     * 得有多无聊，才能有这样的题！！！
     */
    class Solution {
        public int myAtoi(String str) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            long result = 0;
            char[] arr = str.toCharArray();
            boolean flag = false;
            int i = 0;

            // 去除前导空格
            while (i < arr.length && arr[i] == ' ') {
                i++;
            }

            // 判断正负
            if (i < arr.length) {
                if (arr[i] == '-') {
                    flag = true;
                    i++;
                } else if (arr[i] == '+') {
                    i++;
                }
            }

            if (i == arr.length) {
                return 0;
            }

            // 正负号后必须为数字
            if (i + 1 < arr.length && !(arr[i] >= '0' && arr[i] <= '9')) {
                return 0;
            }

            // 执行转换
            while (i < arr.length) {
                if (arr[i] >= '0' && arr[i] <= '9') {
                    if (flag) {
                        result = result * 10 - (arr[i] - '0');
                    } else {
                        result = result * 10 + (arr[i] - '0');
                    }

                    if (result > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    if (result < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    break;
                }
                i++;
            }
            return (int) result;
        }
    }
}
