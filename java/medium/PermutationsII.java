package com.yangchd.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yangchd  2018/9/18.
 *
 * 47. Permutations II
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 *
 */
public class PermutationsII {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
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
                if (!list.contains(temp)) {
                    list.add(temp);
                }
                return;
            }
            Set<Integer> set = new HashSet<Integer>();
            for (int i = start; i < nums.length; i++) {
                if (set.add(nums[i])) {
                    swap(nums, start, i);
                    backtrack(list, start + 1, nums);
                    swap(nums, start, i);
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
