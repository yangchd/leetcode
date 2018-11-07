package com.yangchd.leetcode.medium;

/**
 * @author yangchd  2018/11/7.
 *
 * 79.WordSearch
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 */
public class WordSearch {
    /**
     * 采用上下左右四个方向试探，效率比较低
     * 思路没啥问题，具体细节方面，需要优化效率——以后再说
     */
    public class Solution {
        public boolean exist(char[][] board, String word) {
            if (null == word || "".equals(word)) {
                return true;
            }
            if (board.length <= 0 || board[0].length <= 0) {
                return false;
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        // 找到头节点
                        int[][] index = new int[board.length][board[0].length];
                        for (int m = 0; m < board.length; m++) {
                            for (int n = 0; n < board[0].length; n++) {
                                index[m][n] = 0;
                            }
                        }
                        index[i][j] = 1;
                        if (find(board, index, word.substring(1), i, j)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private boolean find(char[][] board, int[][] index, String word, int x, int y) {
            if ("".equals(word)) {
                return true;
            } else {
                if (y - 1 >= 0 && index[x][y - 1] != 1 && board[x][y - 1] == word.charAt(0)) {
                    index[x][y - 1] = 1;
                    if (find(board, index, word.substring(1), x, y - 1)) {
                        return true;
                    }
                    index[x][y - 1] = 0;
                }
                if (x + 1 < board.length && index[x + 1][y] != 1 && board[x + 1][y] == word.charAt(0)) {
                    index[x + 1][y] = 1;
                    if (find(board, index, word.substring(1), x + 1, y)) {
                        return true;
                    }
                    index[x + 1][y] = 0;
                }
                if (y + 1 < board[0].length && index[x][y + 1] != 1 && board[x][y + 1] == word.charAt(0)) {
                    index[x][y + 1] = 1;
                    if (find(board, index, word.substring(1), x, y + 1)) {
                        return true;
                    }
                    index[x][y + 1] = 0;
                }
                if (x - 1 >= 0 && index[x - 1][y] != 1 && board[x - 1][y] == word.charAt(0)) {
                    index[x - 1][y] = 1;
                    if (find(board, index, word.substring(1), x - 1, y)) {
                        return true;
                    }
                    index[x - 1][y] = 0;
                }
                return false;
            }
        }
    }
}
