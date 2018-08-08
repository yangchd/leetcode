package com.yangchd.leetcode.hard;

/**
 * @author yangchd  2018/8/8.
 *
 * 44. Wildcard Matching
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 *
 * Example 1:
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 *
 * Example 3:
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 *
 * Example 4:
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 *
 * Example 5:
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 *
 */
public class WildcardMatching {
    class Solution {
        public boolean isMatch(String s, String p) {
            int sLen = s.length();
            int pLen = p.length();

            if (sLen == 0 && pLen == 0) {
                return true;
            }
            if (sLen > 0 && pLen == 0) {
                return false;
            }

            boolean[][] table = new boolean[sLen + 1][pLen + 1];

            table[0][0] = true;

            for (int i = 1; i <= sLen; i++) {
                table[i][0] = false;
            }

            for (int i = 1; i <= pLen; i++) {
                if (p.charAt(i - 1) == '*') {
                    table[0][i] = table[0][i - 1];
                } else {
                    table[0][i] = false;
                }
            }

            for (int i = 1; i <= sLen; i++) {
                for (int j = 1; j <= pLen; j++) {
                    if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                        table[i][j] = table[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        table[i][j] = table[i][j - 1] || table[i - 1][j];
                    } else {
                        table[i][j] = false;
                    }
                }
            }

            return table[sLen][pLen];
        }
    }
}
