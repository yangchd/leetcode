package com.yangchd.leetcode.medium;

/**
 * @author yangchd  2018/3/27.
 *
 * 6. ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 *
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {

    /**
     * 创建多个StringBuilder存储每个单词
     * 这里要格外注意StringBuilder需要单独初始化，通过两个计数器将输入值正确放到输出中
     *
     * 网上还有另外一种，是根据数的规律，直接从输入中取出结果。
     */
    class Solution {
        public String convert(String s, int numRows) {
            if(null == s || s.length() <= 2 || numRows <= 1){
                return s;
            }
            int readNum = 0;
            int nextNum = 1;
            StringBuilder[] sbs = new StringBuilder[numRows];
            for(int i=0;i<s.length();i++){
                if(null == sbs[readNum]){
                    sbs[readNum] = new StringBuilder();
                }
                sbs[readNum].append(s.charAt(i));
                readNum += nextNum;
                if(readNum==0 || readNum == (numRows-1)){
                    nextNum = 0-nextNum;
                }
            }
            StringBuilder result = new StringBuilder();
            for(StringBuilder sb:sbs){
                if(null != sb){
                    result.append(sb.toString());
                }
            }
            return result.toString();
        }
    }
}
