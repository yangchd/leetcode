package com.yangchd.leetcode.easy;

import java.util.Stack;

/**
 * @author yangchd  2018/6/15.
 *
 * 20. Valid Parentheses
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 * Input: "()"
 * Output: true
 *
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 * Input: "{[]}"
 * Output: true
 *
 */
public class ValidParentheses {
    class Solution {
        public boolean isValid(String s) {
            Stack<String> stack = new Stack<String>();
            char[] chs = s.toCharArray();
            for (char ch : chs) {
                if ('(' == ch || '[' == ch || '{' == ch) {
                    stack.push(String.valueOf(ch));
                } else if (!stack.empty() && (')' == ch || ']' == ch || '}' == ch)) {
                    if(!matchString(stack.pop(), String.valueOf(ch))){
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return stack.empty();
        }

        private boolean matchString(String a, String b) {
            return ("(".equals(a) && ")".equals(b)) || ("[".equals(a) && "]".equals(b)) || ("{".equals(a) && "}".equals(b));
        }
    }
}
