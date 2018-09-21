package com.yangchd.leetcode.medium;

import java.util.*;

/**
 * @author yangchd  2018/9/21.
 *
 * 49. Group Anagrams
 * Given an array of strings, group anagrams together.
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 *
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 */
public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<String, List<String>>(strs.length);
            for (String s : strs) {
                char[] a = s.toCharArray();
                Arrays.sort(a);
                String key = new String(a);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<String>());
                }
                map.get(key).add(s);
            }
            return new ArrayList<List<String>>(map.values());
        }
    }
}
