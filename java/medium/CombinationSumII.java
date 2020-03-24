package com.yangchd.leetcode.medium;

import java.util.*;

/**
 * @author yangchd  2018/7/19.
 *
 * 40. Combination Sum II
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 */
public class CombinationSumII {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            Stack<Integer> numStack = new Stack<Integer>();
            Arrays.sort(candidates);
            checkNum(candidates, 0, target, list, numStack);
            return list;
        }

        private void checkNum(int[] candidates, int start, int target, List<List<Integer>> list, Stack<Integer> numStack) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                list.add(new ArrayList<Integer>(numStack));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                numStack.push(candidates[i]);
                checkNum(candidates, i + 1, target - candidates[i], list, numStack);
                numStack.pop();
            }
        }
    }
}
