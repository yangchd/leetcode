package com.yangchd.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangchd  2018/10/12.
 *
 * 56. Merge Intervals
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 *
 */
public class MergeIntervals {
    public class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    /**
     * 将需要合并的画在数组上，最后从数组中取出最后结果
     */
    class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            int max = 0;
            for (Interval interval : intervals) {
                max = Math.max(max, interval.end);
            }
            int[] flags = new int[max + 1];
            for (int i = 0; i <= max; i++) {
                flags[i] = 0;
            }
            for (Interval interval : intervals) {
                if (interval.start == interval.end) {
                    if (flags[interval.start] == 0) {
                        flags[interval.start] = 2;
                    }
                } else {
                    for (int m = interval.start; m < interval.end; m++) {
                        flags[m] = 1;
                    }
                }
            }
            List<Interval> res = new ArrayList<Interval>();
            for (int n = 0; n <= max; n++) {
                if (flags[n] == 2) {
                    res.add(new Interval(n, n));
                    continue;
                }
                if (flags[n] >= 1) {
                    int index = 0;
                    while (n + index <= max && flags[n + index] >= 1) {
                        if (flags[n + index] == 2) {
                            break;
                        } else {
                            index++;
                        }
                    }
                    Interval interval = new Interval(n, n + index);
                    res.add(interval);
                    n = n + index;
                }
            }
            return res;
        }
    }
}
