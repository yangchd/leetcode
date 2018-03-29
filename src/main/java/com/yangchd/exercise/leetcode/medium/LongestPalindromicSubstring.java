package com.yangchd.exercise.leetcode.medium;

/**
 * @author yangchd  2018/3/27.
 *
 * 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {


    class Solution {

        /**
         * 从左向右遍历，对每一个遍历到的字符，进行奇偶两种校验，找到最长的回文
         */
        private int begin,end;
        public String longestPalindrome(String s) {
            if (null == s || s.length() < 2) {
                return s;
            }
            for (int i = 0; i < s.length() - 1; i++) {
                expandPalindrome(s, i, i);
                expandPalindrome(s, i, i + 1);
            }
            return s.substring(begin, end+1);
        }
        private void expandPalindrome(String s,int i,int j){
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }
            if ((end - begin + 1) < (j - i - 1)) {
                begin = i + 1;
                end = j - 1;
            }
        }

        /**
         * 从两头遍历，思路简单，但是执行效率很低
         */
        public String solutionOne(String s) {
            if(null == s || "".equals(s)){
                return s;
            }
            int length = s.length();
            String longestSubstring = "";
            for (int i = 0; i < length; i++) {
                if (longestSubstring.length() > (length - i)) {
                    break;
                }
                for (int j = length - 1; j >= i; j--) {
                    int left = i;
                    int right = j;
                    if (longestSubstring.length() >= (j - i + 1)) {
                        break;
                    }
                    if (s.charAt(left++) == s.charAt(right--)) {
                        boolean palindromic = true;
                        while (right > left) {
                            if (s.charAt(left++) != s.charAt(right--)) {
                                palindromic = false;
                                break;
                            }
                        }
                        if (palindromic) {
                            longestSubstring = s.substring(i, j + 1);
                        }
                    }
                }
            }
            return longestSubstring;
        }
    }
}
