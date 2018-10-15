package com.yangchd.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangchd  2018/10/15.
 *
 * 60.Permutation Sequence
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the k^th permutation sequence.
 * Note:
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 *
 * Example 1:
 * Input: n = 3, k = 3
 * Output: "213"
 *
 * Example 2:
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class PermutationSequence {
    class Solution {
        public String getPermutation(int n, int k) {
            int fact = 1;
            List<Integer> list = new ArrayList<Integer>();
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                list.add(i);
                fact *= i;
            }
            k = k - 1;
            for (int i = n; i > 0; i--) {
                fact /= i;
                int bucket = k / fact;
                sb.append(list.get(bucket));
                list.remove(bucket);
                k %= fact;
            }
            return sb.toString();
        }
    }
}
