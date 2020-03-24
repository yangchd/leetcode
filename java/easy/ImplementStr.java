package com.yangchd.leetcode.easy;

/**
 * @author yangchd  2018/6/25.
 *
 * 28. Implement strStr()
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Clarification:
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 */
public class ImplementStr {
    class Solution {
        public int strStr(String haystack, String needle) {
            int hlength = haystack.length();
            int nlength = needle.length();
            if (hlength < nlength) {
                return -1;
            }
            if (nlength == 0) {
                return 0;
            }
            for (int i = 0; i < hlength - nlength + 1; i++) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    boolean flag = true;
                    for (int y = 1; y < nlength; y++) {
                        if (haystack.charAt(i + y) != needle.charAt(y)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        return i;
                    }
                }
            }
            return -1;
        }
    }
}
