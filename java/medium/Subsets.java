package com.yangchd.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangchd  2018/11/7.
 *
 * 78.Subsets
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 */
public class Subsets {
    /**
     * 这种获取所有子集的问题，拆分成所有包含n个子集的问题
     * 然后用回溯算法，得到包含n个子集的所有可能解
     */
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            for (int i = 0; i <= nums.length; i++) {
                backTracking(res, new ArrayList<Integer>(), 0, i, nums);
            }
            return res;
        }

        private void backTracking(List<List<Integer>> res, List<Integer> list, int begin, int k, int[] nums) {
            if (list.size() == k) {
                res.add(new ArrayList<Integer>(list));
            } else {
                for (int i = begin; i < nums.length; i++) {
                    list.add(nums[i]);
                    backTracking(res, list, i + 1, k, nums);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
