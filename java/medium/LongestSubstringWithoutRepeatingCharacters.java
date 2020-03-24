package com.yangchd.leetcode.medium;

import java.util.HashSet;

/**
 * @author yangchd  2018/3/26.
 *
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    class Solution {
        /**
         * 通过HashSet来记录最长的字符串
         */
        public int lengthOfLongestSubstring(String s) {
            if (null == s) {
                return 0;
            }
            int max = 0;
            int i = 0;
            int j = 0;
            HashSet<Character> hashSet = new HashSet<Character>(s.length());
            while (i < s.length()) {
                if (!hashSet.contains(s.charAt(i))) {
                    hashSet.add(s.charAt(i++));
                    max = Math.max(max, hashSet.size());
                } else {
                    hashSet.remove(s.charAt(j++));
                }
            }
            return max;
        }

        /**
         * 记录一种看到的更好的解决方法
         * 通过字符所在字符串的位置来计算最长重复
         */
        public int solutionOne(String s) {
            int n = s.length(), ans = 0;
            int[] index = new int[128];
            for(int j=0, i=0; j<n; j++){
                i = Math.max(index[s.charAt(j)], i);
                ans = Math.max(ans, j-i+1);
                index[s.charAt(j)] = j+1;
            }
            return ans;
        }
    }

}
