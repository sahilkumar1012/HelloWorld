package com.example.helloworld.greedy;

import java.util.Arrays;

/**
 *
 * Leetcode 253. Meeting Rooms II
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 */
public class MeetingRoomII {

    public int minMeetingRooms(int[][] intervals){
        int n = intervals.length;

        int[] start = new int[n];
        int[] end = new int[n];

        for(int i=0; i<n; ++i){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i=1, j=0;
        int rooms = 1, max = 1;

        while(i<n){
            if(start[i] < end[j]){
                rooms++;
                i++;
                if(rooms>max)
                    max = rooms;
            }else {
                rooms--;
                j++;
            }
        }

        return max;
    }
}
