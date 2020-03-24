package com.yangchd.leetcode.hard;

import java.util.*;

/**
 * @author yangchd  2018/7/6.
 *
 * 37. Sudoku Solver
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 * 1、Each of the digits 1-9 must occur exactly once in each row.
 * 2、Each of the digits 1-9 must occur exactly once in each column.
 * 3、Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 *
 * Note:
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique solution.
 * The given board size is always 9x9.
 */
public class SudokuSolver {
    class Solution {
        public void solveSudoku(char[][] board) {
            int num = 0;
            char[][] row = new char[9][128];
            char[][] col = new char[9][128];
            char[][] piece = new char[9][128];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char a = board[i][j];
                    if ('.' == a) {
                        continue;
                    }
                    num++;
                    row[i][a] = a;
                    col[j][a] = a;
                    piece[j / 3 + (i / 3) * 3][a] = a;
                }
            }
            char[] option = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
            tryAdd(board, row, col, piece, option, num);
        }

        private boolean tryAdd(char[][] board, char[][] row, char[][] col, char[][] piece, char[] option, int num) {
            int[] nextIndex = new int[]{Integer.MAX_VALUE, -1, -1};
            List<int[]> callBackList = new ArrayList<int[]>();
            boolean hasOnly = true;
            while (num < 81 && hasOnly) {
                hasOnly = false;
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        char a = board[i][j];
                        if ('.' != a) {
                            continue;
                        }
                        int checked = 0;
                        char only = '\0';
                        for (char ch : option) {
                            if (row[i][ch] != ch && col[j][ch] != ch && piece[j / 3 + (i / 3) * 3][ch] != ch) {
                                checked++;
                                only = ch;
                            }
                        }
                        if (checked == 0) {
                            for (int[] back : callBackList) {
                                char ch = board[back[0]][back[1]];
                                board[back[0]][back[1]] = '.';
                                row[back[0]][ch] = '\0';
                                col[back[1]][ch] = '\0';
                                piece[back[1] / 3 + (back[0] / 3) * 3][ch] = '\0';
                                num--;
                            }
                            callBackList.clear();
                            return false;
                        }
                        if (checked == 1) {
                            hasOnly = true;
                            board[i][j] = only;
                            row[i][only] = only;
                            col[j][only] = only;
                            piece[j / 3 + (i / 3) * 3][only] = only;
                            callBackList.add(new int[]{i, j});
                            num++;
                            nextIndex[0] = Integer.MAX_VALUE;
                            nextIndex[1] = -1;
                            nextIndex[2] = -1;
                        } else {
                            if (checked < nextIndex[0]) {
                                nextIndex[0] = checked;
                                nextIndex[1] = i;
                                nextIndex[2] = j;
                            }
                        }
                    }
                }
            }
            if (num == 81) {
                return true;
            } else {
                int i = nextIndex[1];
                int j = nextIndex[2];
                for (char ch : option) {
                    if (row[i][ch] != ch && col[j][ch] != ch && piece[j / 3 + (i / 3) * 3][ch] != ch) {
                        num++;
                        board[i][j] = ch;
                        row[i][ch] = ch;
                        col[j][ch] = ch;
                        piece[j / 3 + (i / 3) * 3][ch] = ch;
                        if (tryAdd(board, row, col, piece, option, num)) {
                            return true;
                        } else {
                            num--;
                            board[i][j] = '.';
                            row[i][ch] = '\0';
                            col[j][ch] = '\0';
                            piece[j / 3 + (i / 3) * 3][ch] = '\0';
                        }
                    }
                }
                for (int[] back : callBackList) {
                    char ch = board[back[0]][back[1]];
                    board[back[0]][back[1]] = '.';
                    row[back[0]][ch] = '\0';
                    col[back[1]][ch] = '\0';
                    piece[back[1] / 3 + (back[0] / 3) * 3][ch] = '\0';
                    num--;
                }
                callBackList.clear();
                return false;
            }
        }
    }
}
