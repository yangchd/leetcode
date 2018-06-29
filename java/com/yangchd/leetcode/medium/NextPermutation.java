package com.yangchd.leetcode.medium;

import java.util.Arrays;

/**
 * @author yangchd  2018/6/29.
 *
 * 31. Next Permutation
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place and use only constant extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {
    class Solution {
        public void nextPermutation(int[] nums) {
            if (null == nums || nums.length <= 1) {
                return;
            }
            int index = nums.length - 1;
            while (index > 0 && nums[index] <= nums[index - 1]) {
                index--;
            }
            if (index == 0) {
                while (index < nums.length - 1 - index) {
                    int temp = nums[index];
                    nums[index] = nums[nums.length - 1 - index];
                    nums[nums.length - 1 - index] = temp;
                    index++;
                }
                return;
            }
            int left = nums[index - 1];
            int right = nums[index];
            int rIndex = index;
            for (int i = index + 1; i < nums.length; i++) {
                if (nums[i] < right && nums[i] > left) {
                    right = nums[i];
                    rIndex = i;
                }
            }
            nums[index - 1] = right;
            nums[rIndex] = left;
            Arrays.sort(nums, index, nums.length);
        }
    }
}
