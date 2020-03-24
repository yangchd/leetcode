package com.yangchd.leetcode.medium;

import java.util.*;

/**
 * @author yangchd  2018/9/12.
 *
 * 46. Permutations
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            if (nums == null || nums.length == 0) {
                return list;
            }
            backtrack(list, 0, nums);
            return list;
        }
        private void backtrack(List<List<Integer>> list, int start, int[] nums) {
            if (start == nums.length) {
                List<Integer> temp = new ArrayList<Integer>();
                for (int num : nums) {
                    temp.add(num);
                }
                list.add(new ArrayList<Integer>(temp));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                backtrack(list, start + 1, nums);
                swap(nums, start, i);
            }
        }
        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
