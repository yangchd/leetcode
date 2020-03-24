package com.yangchd.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yangchd  2018/7/13.
 *
 * 39. Combination Sum
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 *
 */
public class CombinationSum {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            Stack<Integer> numStack = new Stack<Integer>();
            checkNum(candidates, target, list, numStack);
            return list;
        }

        private void checkNum(int[] candidates, int target, List<List<Integer>> list, Stack<Integer> numStack) {
            for (int i = candidates.length - 1; i >= 0; i--) {
                if (candidates[i] <= target && (numStack.empty() || (!numStack.empty() && candidates[i] <= numStack.peek()))) {
                    numStack.push(candidates[i]);
                    target -= candidates[i];
                    if (target == 0) {
                        list.add(new ArrayList<Integer>(numStack));
                    } else {
                        checkNum(candidates, target, list, numStack);
                    }
                    target += candidates[i];
                    numStack.pop();
                }
            }
        }
    }
}
