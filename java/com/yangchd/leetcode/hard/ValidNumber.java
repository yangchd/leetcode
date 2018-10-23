package com.yangchd.leetcode.hard;

/**
 * @author yangchd 2018/10/23
 *
 * 65.Valid Number
 * Validate if a given string can be interpreted as a decimal number.
 *
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 *
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:
 *
 * Numbers 0-9
 * Exponent - "e"
 * Positive/negative sign - "+"/"-"
 * Decimal point - "."
 * Of course, the context of these characters also matters in the input.
 *
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.
 */
public class ValidNumber {
    class Solution {
        public boolean isNumber(String s) {
            s = s.trim();
            boolean n = false;
            boolean p = false;
            boolean e = false;
            boolean afe = true;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                    n = true;
                    afe = true;
                } else if (s.charAt(i) == '.' && p == false && e == false) {
                    p = true;
                } else if (s.charAt(i) == 'e' && e == false && n == true) {
                    e = true;
                    afe = false;
                } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e')) {
                    //do nothing
                } else {
                    return false;
                }
            }
            return (n && afe);
        }
    }
}
