package com.example.helloworld.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 leetcode 56. Merge Intervals
 Medium

 Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 Example 1:

 Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]
 Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 Example 2:

 Input: intervals = [[1,4],[4,5]]
 Output: [[1,5]]
 Explanation: Intervals [1,4] and [4,5] are considered overlapping.


 Constraints:

 1 <= intervals.length <= 104
 intervals[i].length == 2
 0 <= starti <= endi <= 104
 */
class MergeIntervalsTest {
    public static void main(String[] args) {
        int ans[][] = new MergeIntervals().merge(new int[][]{{1, 4}, {0, 2}, {3, 5}});
        for (int[] a : ans) {
            System.out.println(a[0] + " " + a[1]);
        }
    }
}

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // sort intervals based on starting value.
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        ArrayList<Integer[]> res = new ArrayList<>();

        int n = intervals.length;
        int i = 0;
        for (i = 0; i < n - 1; ++i) {
            int start = intervals[i][0], end = intervals[i][1];
            while (i < n - 1 && intervals[i + 1][0] <= end) {
                start = Math.min(start, intervals[i + 1][0]);
                end = Math.max(end, intervals[i + 1][1]);
                ++i;
            }
            res.add(new Integer[]{start, end});
        }
        // whether an element is left in the last.
        if (i == n - 1) {
            res.add(new Integer[]{intervals[i][0], intervals[i][1]});
        }

        // converting back to 2d array
        int[][] ans = new int[res.size()][2];
        for (i = 0; i < res.size(); ++i) {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }

        return ans;
    }
}