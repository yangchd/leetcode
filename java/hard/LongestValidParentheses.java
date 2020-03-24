package com.yangchd.leetcode.hard;

import java.util.Stack;

/**
 * @author yangchd  2018/7/2.
 *
 * 32. Longest Valid Parentheses
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 *
 * Example 2:
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 *
 */
public class LongestValidParentheses {
    class Solution {
        public int longestValidParentheses(String s) {
            int longest = 0;
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.empty()) {
                        stack.push(i);
                    } else {
                        longest = Math.max(longest, i - stack.peek());
                    }
                }
            }
            return longest;
        }
    }
}
