package com.yangchd.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangchd  2018/6/19.
 *
 * 22. Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParentheses {
    /**
     * 如果左括号小于n，可以添加一个左括号
     * 如果右括号小于n，可以添加一个右括号
     * 当左右括号都达到n个时，将结果添加到最终结果中去
     */
    class Solution {
        private void generate(List<String> result, StringBuilder cur, int start, int open, int closed, int n) {
            if (closed == n) {
                result.add(cur.toString());
                return;
            }
            if (open < n) {
                cur.append("(");
                generate(result, cur, start + 1, open + 1, closed, n);
                cur.setLength(cur.length() - 1);
            }
            if (closed < open) {
                cur.append(")");
                generate(result, cur, start + 1, open, closed + 1, n);
                cur.setLength(cur.length() - 1);
            }
        }

        public List<String> generateParenthesis(int n) {
            StringBuilder start = new StringBuilder("(");
            List<String> result = new ArrayList<String>();
            generate(result, start, 1, 1, 0, n);
            return result;
        }
    }
}
