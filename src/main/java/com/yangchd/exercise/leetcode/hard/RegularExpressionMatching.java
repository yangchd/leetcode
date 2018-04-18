package com.yangchd.exercise.leetcode.hard;

/**
 * @author yangchd  2018/4/17.
 *
 * 10. Regular Expression Matching
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 *
 * Example 1:
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 * Example 3:
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 * Example 4:
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 *
 * Example 5:
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 *
 */
public class RegularExpressionMatching {
    class Solution {
        public boolean isMatch(String s, String p) {
            char point = '.';
            char star = '*';
            if(p.contains(".*")){
                StringBuilder sb = new StringBuilder();
                while (p.contains(".*")){
                    int i = p.indexOf(".*");
                    if(i-1>=0 && i+3 < p.length() &&
                            (p.charAt(i-1) == star || p.charAt(i+3) == star)){
                        if(p.charAt(i-1) == star){
                            p = p.substring(0,i-2)+p.substring(i);
                        }else {
                            p = p.substring(0,i+2)+p.substring(i+4);
                        }
                    }else {
                        sb.append(p.substring(0,i+2));
                        p = p.substring(i+2);
                    }
                }
                p = sb.append(p).toString();
            }
            if("".equals(s)){
                if("".equals(p)){
                    return true;
                }else{
                    if(p.length() % 2 != 0){
                        return false;
                    }else{
                        for(int i=1;i<p.length();i=i+2){
                            if(p.charAt(i) != star){
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }else{
                if("".equals(p)){
                    return false;
                }
                if(!p.contains(String.valueOf(point))
                        && !p.contains(String.valueOf(star))){
                    return s.equals(p);
                }
                int sNum = 0;
                int pNum = 0;
                int sLength = s.length();
                int pLength = p.length();
                while (sNum < sLength && pNum < pLength){
                    if(s.charAt(sNum) != p.charAt(pNum) && p.charAt(pNum) != point){
                        if(pNum + 1 < pLength){
                            if(p.charAt(pNum+1)=='*'){
                                return isMatch(s,p.substring(pNum+2));
                            }else{
                                return false;
                            }
                        }else{
                            return false;
                        }
                    }else{
                        if(pNum + 1 < pLength){
                            if(p.charAt(pNum+1)=='*'){
                                if(p.charAt(pNum) != point){
                                    while (sNum+1 < sLength && s.charAt(sNum) == s.charAt(sNum + 1)){
                                        sNum++;
                                    }
                                    int rNum = 0;
                                    if(pNum + 2 < pLength){
                                        while(pNum + 2 + rNum < pLength && p.charAt(pNum + 2 + rNum) == p.charAt(pNum)){
                                            rNum++;
                                        }
                                    }
                                    String s1 = s.substring(1 + sNum);
                                    String p1 = p.substring(pNum + 2 + rNum);
                                    String pStr = String.valueOf(p.charAt(pNum));
                                    while(p1.contains(pStr)){
                                        if(isMatch("",p1.substring(0,p1.indexOf(pStr)))){
                                            rNum++;
                                        }
                                        if(s1.contains(pStr)){
                                            rNum--;
                                        }
                                        s1 = s1.substring(s1.indexOf(pStr) + 1);
                                        p1 = p1.substring(p1.indexOf(pStr)+1);
                                    }
                                    if(rNum < 0){
                                        rNum = 1;
                                    }
                                    if(sNum==0){
                                        if(1-rNum < 0){
                                            return false;
                                        }else{
                                            while (rNum >=0){
                                                if(isMatch(s.substring(1-rNum),p.substring(2))){
                                                    return true;
                                                }else{
                                                    rNum--;
                                                }
                                            }
                                            return false;
                                        }
                                    }
                                    if(sNum - rNum + 1 < 0){
                                        return false;
                                    }
                                    while (rNum >= 0){
                                        if(isMatch(s.substring(sNum+1-rNum),p.substring(pNum+2))){
                                            return true;
                                        }else{
                                            rNum--;
                                        }
                                    }
                                    return false;
                                }else{
                                    if(pNum + 2 < pLength){
                                        if(p.charAt(pNum+2) != point){
                                            String p2 = String.valueOf(p.charAt(pNum+2));
                                            if(s.contains(p2)){
                                                while(s.contains(p2)){
                                                    if(isMatch(s.substring(s.indexOf(p2)),p.substring(pNum+2))){
                                                        return true;
                                                    }else {
                                                        if(s.indexOf(p2,1) >= 0){
                                                            s = s.substring(s.indexOf(p2,1));
                                                        }else{
                                                            break;
                                                        }
                                                    }
                                                }
                                                return false;
                                            }else{
                                                return false;
                                            }
                                        }else{
                                            if(pNum + 3 < pLength){
                                                if(p.charAt(pNum + 3)==star){
                                                    return isMatch(s,p.substring(pNum+2));
                                                }else{
                                                    int rNum = 1;
                                                    if(pNum + 2 < pLength){
                                                        while(pNum + 2 + rNum < pLength && p.charAt(pNum + 2 + rNum) == p.charAt(pNum)){
                                                            rNum++;
                                                        }
                                                    }
                                                    if(pNum + 2 + rNum < pLength){
                                                        if(p.charAt(pNum + 2 + rNum) != star){
                                                            if(sLength < rNum){
                                                                return false;
                                                            }
                                                            return isMatch(s.substring(rNum),p.substring(pNum + 2 + rNum));
                                                        }else{
                                                            if(rNum - 1 <= sLength){
                                                                return isMatch(s.substring(rNum-1),p.substring(pNum + 2 + rNum -1));
                                                            }else{
                                                                return false;
                                                            }
                                                        }
                                                    }else{
                                                        return sLength >= rNum;
                                                    }

                                                }
                                            }else{
                                                return true;
                                            }
                                        }
                                    }else{
                                        return true;
                                    }
                                }
                            }else{
                                return isMatch(s.substring(1),p.substring(1));
                            }
                        }else{
                            if(sNum + 1 < sLength){
                                return false;
                            }else{
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
        }
    }
}
