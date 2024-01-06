package com.example.helloworld.dp.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * leetcode 1235. Maximum Profit in Job Scheduling
 *
 * Code Harmony solution video : https://youtu.be/saBb0xk2gQo
 *
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
 *
 * You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
 *
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * Output: 120
 * Explanation: The subset chosen is the first and fourth job.
 * Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
 * Example 2:
 *
 *
 *
 * Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
 * Output: 150
 * Explanation: The subset chosen is the first, fourth and fifth job.
 * Profit obtained 150 = 20 + 70 + 60.
 * Example 3:
 *
 *
 *
 * Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
 * Output: 6
 *
 *
 * Constraints:
 *
 * 1 <= startTime.length == endTime.length == profit.length <= 5 * 104
 * 1 <= startTime[i] < endTime[i] <= 109
 * 1 <= profit[i] <= 104
 */
public class MaximumProfitinJobScheduling {
    int[] memo;  // Memoization array to store results for sub-problems.
    int n;       // Number of jobs.

    /**
     * Find the index of the next job that can be scheduled after the current job ends.
     */
    private int findNextJob(int[] startTime, int lastEndingTime) {
        int left = 0, right = startTime.length - 1, nextIndex = startTime.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (startTime[mid] >= lastEndingTime) {
                nextIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nextIndex;
    }

    /**
     * Recursive function to find the maximum profit.
     */
    private int findMaxProfit(List<Integer[]> jobs, int[] startTime, int idx) {
        if (idx == n) {
            return 0;
        }
        if (memo[idx] != -1) {
            return memo[idx];
        }

        int nextIndex = findNextJob(startTime, jobs.get(idx)[1]);

        int maxProfit = Math.max(
                findMaxProfit(jobs, startTime, idx + 1),                       // Profit by excluding the current job.
                jobs.get(idx)[2] + findMaxProfit(jobs, startTime, nextIndex)    // Profit by including the current job.
        );

        return memo[idx] = maxProfit;  // Memoize the result for current index.
    }

    /**
     * Main function to calculate maximum profit from jobs.
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;  // Set the number of jobs.
        memo = new int[50001]; // Initialize memoization array.

        List<Integer[]> jobs = new ArrayList<>();
        Arrays.fill(memo, -1); // Initialize memo array with -1.

        // Create a list of jobs with their start time, end time, and profit.
        for (int i = 0; i < n; i++) {
            jobs.add(new Integer[]{startTime[i], endTime[i], profit[i]});
        }

        jobs.sort(Comparator.comparingInt(a -> a[0]));  // Sort jobs based on start time.

        // Extract start times after sorting.
        for (int i = 0; i < n; i++) {
            startTime[i] = jobs.get(i)[0];
        }

        // Return the maximum profit by calling the recursive function.
        return findMaxProfit(jobs, startTime, 0);
    }
}