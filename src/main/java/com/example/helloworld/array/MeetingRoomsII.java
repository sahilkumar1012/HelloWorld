package com.example.helloworld.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * leetcode 253. Meeting Rooms II
 *
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
public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        List<int[]> timing = new ArrayList<>();

        for(int[] interval : intervals){
            timing.add(new int[]{interval[0], 1});      // 1 for arrival
            timing.add(new int[]{interval[1], 0});      // 0 for departure,  if same time arrival n departure, then departure first.
        }

        // increasing order mai sort arrival by time, dearpture is 0 so sorting order for those too if arrival time is same.
        Collections.sort(timing, (a, b)->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int max = 0;
        int room = 0;
        for(int[] time : timing){
            // System.out.println("time + " + time[0] + " " + time[1]);
            if( time[1] == 1 )
                room ++;
            else if( time[1] == 0 ){
                room --;
            }
            max = Math.max(max, room);
        }

        return max;
    }
}
