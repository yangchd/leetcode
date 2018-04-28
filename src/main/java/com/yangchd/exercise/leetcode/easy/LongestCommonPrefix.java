package com.yangchd.exercise.leetcode.easy;

/**
 * @author yangchd  2018/4/28.
 *
 * 14. Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Note:
 * All given inputs are in lowercase letters a-z.
 *
 */
public class LongestCommonPrefix {
    class Solution {

        /**
         * 一位一位判断
         */
        public String longestCommonPrefix(String[] strs) {
            if(null == strs || strs.length < 1){
                return "";
            }
            if(strs.length == 1){
                return strs[0];
            }

            StringBuilder sb = new StringBuilder();
            int i = 0;
            char ch;

            while (true){
                if(i < strs[0].length()){
                    ch = strs[0].charAt(i);
                }else{
                    return sb.toString();
                }
                for(int j=1;j<strs.length;j++){
                    if(i < strs[j].length()){
                        if(ch != strs[j].charAt(i)){
                            return sb.toString();
                        }
                    }else{
                        return sb.toString();
                    }
                }
                sb.append(String.valueOf(ch));
                i++;
            }
        }
    }
}
