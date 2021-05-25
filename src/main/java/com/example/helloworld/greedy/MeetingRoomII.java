package com.example.helloworld.greedy;

import java.util.Arrays;

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
