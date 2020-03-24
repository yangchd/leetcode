package com.yangchd.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangchd 2018/11/6
 *
 * 77.Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combinations {

    /**
     * Backtracking 回溯算法 以深度优先方式遍历
     */
    public class Solution {
        public List<List<Integer>> combine(int n, int k) {
            if (n <= 0 || n < k) {
                return null;
            }
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            addList(0, n, k, new ArrayList<Integer>(), res);
            return res;
        }

        private void addList(int begin, int n, int k, List<Integer> list, List<List<Integer>> res) {
            if (list.size() == k) {
                res.add(new ArrayList<Integer>(list));
            } else {
                for (int i = begin + 1; i <= n; i++) {
                    list.add(i);
                    addList(i, n, k, list, res);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
