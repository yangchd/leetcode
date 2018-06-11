package com.yangchd.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangchd  2018/6/11.
 *
 * 17. Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 */
public class LetterCombinationsOfAPhoneNumber {
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<String>();

            List<char[]> charList = new ArrayList<char[]>();
            for(int i = 0;i<digits.length();i++){
                charList.add(getCharByNum(digits.charAt(i)));
            }
            for (char[] chs : charList) {
                if (result.size() > 0 && chs.length > 0) {
                    List<String> newList = new ArrayList<String>();
                    for (String str : result) {
                        for (char ch : chs) {
                            newList.add(str + String.valueOf(ch));
                        }
                    }
                    result = newList;
                } else {
                    for (char ch : chs) {
                        result.add(String.valueOf(ch));
                    }
                }
            }
            return result;
        }

        private char[] getCharByNum(char num){
            switch (num){
                case '2':return new char[]{'a','b','c'};
                case '3':return new char[]{'d','e','f'};
                case '4':return new char[]{'g','h','i'};
                case '5':return new char[]{'j','k','l'};
                case '6':return new char[]{'m','n','o'};
                case '7':return new char[]{'p','q','r','s'};
                case '8':return new char[]{'t','u','v'};
                case '9':return new char[]{'w','x','y','z'};
                default:return null;
            }
        }
    }

}
