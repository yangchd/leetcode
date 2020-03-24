package com.yangchd.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangchd 2018/10/13
 *
 * 57. Insert Interval
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {
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

    class Solution {
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            if (null == intervals || intervals.size() < 1) {
                List<Interval> res = new ArrayList<Interval>();
                res.add(newInterval);
                return res;
            }
            for (int i = 0; i < intervals.size(); i++) {
                if (check(intervals.get(i), newInterval)) {
                    newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
                    for (int j = i + 1; j < intervals.size(); j++) {
                        if (check(newInterval, intervals.get(j))) {
                            newInterval = new Interval(Math.min(intervals.get(j).start, newInterval.start), Math.max(intervals.get(j).end, newInterval.end));
                            intervals.remove(j--);
                        }
                    }
                    intervals.set(i, newInterval);
                    return intervals;
                } else {
                    if (newInterval.end < intervals.get(i).start) {
                        intervals.add(i, newInterval);
                        return intervals;
                    }
                    if (i + 1 < intervals.size()) {
                        if (newInterval.start > intervals.get(i).end && newInterval.end < intervals.get(i + 1).start) {
                            intervals.add(i + 1, newInterval);
                            return intervals;
                        }
                    } else {
                        intervals.add(newInterval);
                        return intervals;
                    }
                }
            }
            return intervals;
        }

        private boolean check(Interval a, Interval b) {
            return (a.start >= b.start && a.start <= b.end) || (a.end >= b.start && a.end <= b.end)
                    || (a.start <= b.start && a.end >= b.end) || (a.start >= b.start && a.end <= b.end);
        }
    }
}
