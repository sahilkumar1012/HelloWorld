package com.example.helloworld.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode 435. Non-overlapping Intervals
 *
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 *
 * Example 2:
 *
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
 *
 * Example 3:
 *
 * Input: intervals = [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 *
 *
 *
 * Constraints:
 *
 *     1 <= intervals.length <= 105
 *     intervals[i].length == 2
 *     -5 * 104 <= starti < endi <= 5 * 104
 *
 */
public class NonOverlappingIntervals {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            int n = intervals.length;
            if( n == 0 ) return 0;

            // sort intervals
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));     // sort on basis of end point

            int ans = 0;

            for(int i=0; i<n; ++i){
                int end = intervals[i][1]; // current interval

                while(i+1 < n && intervals[i+1][0] < end){      // is next interval overlapping with current
                    ans++;
                    ++i;
                }
            }

            return ans;
        }
    }
}
