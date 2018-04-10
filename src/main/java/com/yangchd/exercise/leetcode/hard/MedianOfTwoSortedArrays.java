package com.yangchd.exercise.leetcode.hard;

/**
 * @author yangchd  2018/3/26.
 *
 * 4. Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 *
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */

public class MedianOfTwoSortedArrays {

    /**
     * 这个题先把两个数组组装成一个数组，然后根据总长度的奇偶找到中位值
     * 这里要特别注意int float double三种类型的数组在做运算时精确度以及结果。
     */
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            double median = 0;
            int maxLength = nums1.length + nums2.length;
            int[] nums = new int[maxLength];
            int i = 0;
            int j = 0;
            int k = 0;
            while (k <= (float) (maxLength / 2)) {
                if (i < nums1.length && j < nums2.length) {
                    if (nums1[i] <= nums2[j]) {
                        nums[k++] = nums1[i++];
                    } else {
                        nums[k++] = nums2[j++];
                    }
                } else {
                    if (i >= nums1.length && j >= nums2.length) {
                        break;
                    }
                    if (i >= nums1.length) {
                        nums[k++] = nums2[j++];
                    } else {
                        nums[k++] = nums1[i++];
                    }
                }

            }
            if (maxLength % 2 == 1) {
                median = nums[(maxLength / 2)];
            } else {
                median = (double) (nums[(maxLength / 2 - 1)] + nums[(maxLength / 2)]) / 2;
            }
            return median;
        }
    }
}
