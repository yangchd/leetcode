package com.yangchd.leetcode.hard;

import java.util.*;

/**
 * @author yangchd  2018/6/27.
 *
 * 30. Substring with Concatenation of All Words
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 *
 * Example 1:
 * Input:
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 *
 * Example 2:
 * Input:
 * s = "wordgoodstudentgoodword",
 * words = ["word","student"]
 * Output: []
 *
 */
public class SubstringWithConcatenationOfAllWords {
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<Integer>();
            if (words.length < 1) {
                return res;
            }

            Map<String, Integer> map = new HashMap<String, Integer>(), curmap = new HashMap<String, Integer>();
            int wl = words[0].length();

            for (String str : words) {
                if (!map.containsKey(str)) map.put(str, 0);
                map.put(str, map.get(str) + 1);
            }

            for (int i = 0; i < wl; i++) {
                int left = i;
                curmap.clear();
                int count = words.length;
                for (int j = i; j <= s.length() - wl; j += wl) {
                    String cur = s.substring(j, j + wl);
                    if (!map.containsKey(cur)) {
                        curmap.clear();
                        count = words.length;
                        left = j + wl;
                    } else {
                        if (!curmap.containsKey(cur)) curmap.put(cur, 0);
                        curmap.put(cur, curmap.get(cur) + 1);
                        count--;
                        while (curmap.get(cur) > map.get(cur)) {
                            String tmp = s.substring(left, left + wl);
                            left += wl;
                            curmap.put(tmp, curmap.get(tmp) - 1);
                            count++;
                        }
                        if (count == 0) res.add(left);
                    }
                }
            }
            return res;
        }
    }
}
