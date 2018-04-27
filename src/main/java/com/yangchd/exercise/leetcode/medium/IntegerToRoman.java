package com.yangchd.exercise.leetcode.medium;

/**
 * @author yangchd  2018/4/27.
 *
 * 12. Integer to Roman
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II.
 * The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 * Input: 3
 * Output: "III"
 *
 * Example 2:
 * Input: 4
 * Output: "IV"
 *
 * Example 3:
 * Input: 9
 * Output: "IX"
 *
 * Example 4:
 * Input: 58
 * Output: "LVIII"
 * Explanation: C = 100, L = 50, XXX = 30 and III = 3.
 *
 * Example 5:
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * */
public class IntegerToRoman {
    class Solution {
        public String intToRoman(int num) {
            StringBuilder sb = new StringBuilder();
            while (num > 0){
                if(num >= 1000){
                    sb.append(convertNum(num/1000,"M","",""));
                    num = num % 1000;
                }else if(num >= 100){
                    sb.append(convertNum(num/100,"C","D","M"));
                    num = num % 100;
                }else if(num >= 10){
                    sb.append(convertNum(num/10,"X","L","C"));
                    num = num % 10;
                }else{
                    sb.append(convertNum(num,"I","V","X"));
                    num = 0;
                }
            }
            return sb.toString();
        }

        private String convertNum(int i,String one,String five,String ten){
            StringBuilder sb = new StringBuilder();
            if(i <= 3){
                while (i > 0){
                    sb.append(one);
                    i--;
                }
            }else if(i == 4){
                sb.append(one).append(five);
            }else if(i == 9){
                sb.append(one).append(ten);
            }else{
                sb.append(five);
                i = i-5;
                sb.append(convertNum(i,one,five,ten));
            }
            return sb.toString();
        }
    }
}
