package com.example.helloworld.dp.hard;

/**
 * leetcode 1335. Minimum Difficulty of a Job Schedule
 * https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
 *
 * Code Harmony Solution Video : https://youtu.be/WuxHJyCIK5M
 *
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish all the jobs j where 0 <= j < i).
 *
 * You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done on that day.
 *
 * You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].
 *
 * Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: jobDifficulty = [6,5,4,3,2,1], d = 2
 * Output: 7
 * Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
 * Second day you can finish the last job, total difficulty = 1.
 * The difficulty of the schedule = 6 + 1 = 7
 * Example 2:
 *
 * Input: jobDifficulty = [9,9,9], d = 4
 * Output: -1
 * Explanation: If you finish a job per day you will still have a free day. you cannot find a schedule for the given jobs.
 * Example 3:
 *
 * Input: jobDifficulty = [1,1,1], d = 3
 * Output: 3
 * Explanation: The schedule is one job per day. total difficulty will be 3.
 *
 *
 * Constraints:
 *
 * 1 <= jobDifficulty.length <= 300
 * 0 <= jobDifficulty[i] <= 1000
 * 1 <= d <= 10
 *
 */
public class MinimumDifficultyofaJobSchedule {
    // Define a 2D array to store the computed values for dynamic programming.
    Integer[][] dp;

    public int minDifficulty(int[] jd, int d) {
        // If the number of jobs is less than the number of days, it's impossible to assign tasks.
        if(jd.length < d)
            return -1;

        // Initialize the 2D DP array with dimensions based on the number of jobs and days.
        dp = new Integer[jd.length][d+1];
        // Start the recursive function to compute the minimum difficulty.
        return sol(0, d, jd);
    }

    // Recursive function to find the minimum difficulty.
    private int sol(int i, int d, int[] jd){
        // If the value is already computed and stored in the DP array, return it.
        if(dp[i][d] != null)
            return dp[i][d];

        // Base case: If only one day is left, return the maximum difficulty among the remaining jobs.
        if(d == 1){
            int res = 0;
            for(int j=i; j<=jd.length-1; j++)
                res = Math.max(res, jd[j]);
            return res;
        }

        // Initialize the result as the maximum value.
        int res = Integer.MAX_VALUE;
        // Variable to keep track of the maximum difficulty for the current day.
        int dailyMax = 0;

        // Iterate over the jobs to find the minimum difficulty assignment.
        for(int j = i; j<= (jd.length-d); j++){
            // Update the daily maximum difficulty.
            dailyMax = Math.max(dailyMax, jd[j]);

            // Recursively compute the minimum difficulty for the remaining days.
            res = Math.min(res, dailyMax + sol(j+1, d-1, jd));
        }

        // Store the computed result in the DP array to avoid redundant calculations.
        return dp[i][d] = res;
    }

}
