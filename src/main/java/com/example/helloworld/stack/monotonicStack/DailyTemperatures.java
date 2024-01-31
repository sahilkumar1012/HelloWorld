package com.example.helloworld.stack.monotonicStack;

import java.util.Stack;

/**
 * leetcode 739. Daily Temperatures
 *
 * code harmony solution video : https://youtu.be/tjHldRvn9Fw
 *
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 *
 *
 * Constraints:
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 */
public class DailyTemperatures {

    /**
     * Method to find the number of days to wait for a warmer temperature
     * after each day.
     *
     * @param temp The array of daily temperatures.
     * @return An array where answer[i] is the number of days to wait after
     *         the ith day to get a warmer temperature.
     */
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;

        // Stack to store indices of temperatures
        Stack<Integer> s = new Stack<>();

        // Array to store the result
        int[] ans = new int[n];

        // Iterate the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Remove indices with temperatures smaller or equal to the current temperature
            while (!s.isEmpty() && temp[s.peek()] <= temp[i]) {
                s.pop();
            }

            // If there are indices left in the stack, calculate the days to wait
            if (!s.isEmpty()) {
                ans[i] = s.peek() - i;
            }

            // Push the current index to the stack
            s.push(i);
        }

        return ans;
    }
}
