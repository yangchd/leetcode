package com.yangchd.leetcode.easy;

/**
 * @author yangchd 2018/10/13
 *
 * 58. Length of Last Word
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 * Input: "Hello World"
 * Output: 5
 *
 */
public class LengthOfLastWord {
    class Solution {
        public int lengthOfLastWord(String s) {
            int num = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (!Character.isSpaceChar(s.charAt(i))) {
                    num++;
                } else if (num == 0) {
                    continue;
                } else {
                    break;
                }
            }
            return num;
        }
    }
}
