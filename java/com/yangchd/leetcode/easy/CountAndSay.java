package com.yangchd.leetcode.easy;

/**
 * @author yangchd  2018/7/12.
 *
 * 38. Count and Say
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the n~th term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example 1:
 * Input: 1
 * Output: "1"
 *
 * Example 2:
 * Input: 4
 * Output: "1211"
 *
 */
public class CountAndSay {
    class Solution {
        public String countAndSay(int n) {
            if (n == 1) {
                return "1";
            }
            String temp = countAndSay(n - 1);
            int repeat = 1;
            StringBuilder answer = new StringBuilder();
            int i = 1;
            for (; i < temp.length(); i++) {
                if (temp.charAt(i) == temp.charAt(i - 1)) {
                    repeat++;
                } else {
                    answer.append(repeat);
                    answer.append(temp.charAt(i - 1));
                    repeat = 1;
                }
            }
            answer.append(repeat);
            answer.append(temp.charAt(i - 1));
            return answer.toString();
        }
    }
}
