package com.yangchd.exercise.leetcode.medium;

/**
 * @author yangchd  2018/4/25.
 *
 * 11. Container With Most Water
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {
    class Solution {

        /**
         * 从两边开始缩小
         */
        public int maxArea(int[] height) {
            int water = 0;
            int left = 0;
            int right = height.length - 1;
            while (left < right){
                int high = Math.min(height[left],height[right]);
                water = Math.max(water,(right-left)*high);
                if(height[left] <= height[right]){
                    left++;
                }else{
                    right--;
                }
            }
            return water;
        }

        /**
         * 双重循环，这个方法超时了
         */
        public int solutionOne(int[] height) {
            int water = 0;
            for (int i = 0; i < height.length; i++) {
                for (int j = +1; j < height.length; j++) {
                    int high = Math.min(height[i], height[j]);
                    water = Math.max(water, (j - i) * high);
                }
            }
            return water;
        }
    }
}
