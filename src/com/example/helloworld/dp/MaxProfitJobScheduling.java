package com.example.helloworld.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * leetcode 1235. Maximum Profit in Job Scheduling
 *
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 *
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
 *
 * You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
 *
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 */
public class MaxProfitJobScheduling {
    static class Job{
        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    /**
     * this is causing TLE on leetcode.
     * 1. first sort all the jobs according to their endTime.
     * 2. with greedy and dp calculate the maximum profit.
     * @param startTime
     * @param endTime
     * @param profit
     * @return
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[] dp = new int[n];

        List<Job> jobs = new ArrayList<>();
        for(int i=0; i<n; ++i){
            jobs.add(new Job(startTime[i],endTime[i],profit[i]));
        }
        Collections.sort(jobs, (a,b)-> a.end-b.end );

        dp[0] = jobs.get(0).profit;

        for(int i=1; i<n; ++i){

            dp[i] = jobs.get(i).profit;

            for(int j=0; j<i; ++j){
                if( jobs.get(i).start < jobs.get(j).end )
                    continue;
                dp[i] = Math.max( jobs.get(i).profit + dp[j], dp[i] );
            }
        }

        int max = dp[0];
        for(int i=1; i<n; ++i)
            if( max < dp[i] )
                max = dp[i];

        return max;
    }
}