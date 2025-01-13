package com.example.helloworld.array;

/**
 * leetcode 1014. Best Sightseeing Pair , Google interview question
 *
 * code harmony video explanation : https://youtu.be/icOKLdBEtFM
 *
 * my leetcode solution : https://leetcode.com/problems/best-sightseeing-pair/solutions/6192756/easy-to-understand-100-java-c-python-detailed-video-explanation
 *
 * You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.
 *
 * The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.
 *
 * Return the maximum score of a pair of sightseeing spots.
 *
 *
 *
 * Example 1:
 *
 * Input: values = [8,1,5,2,6]
 * Output: 11
 * Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 * Example 2:
 *
 * Input: values = [1,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 2 <= values.length <= 5 * 104
 * 1 <= values[i] <= 1000
 */
public class BestSightseeingPair {

    public int maxScoreSightseeingPair(int[] values) {
        // Initialize 'first' to represent the maximum value of (values[i] + i) seen so far
        int first = values[0];

        // Get the size of the input array
        int n = values.length;

        // Initialize the answer to the minimum possible value
        int ans = Integer.MIN_VALUE;

        // Iterate through the array starting from index 1
        for(int j = 1; j < n; j++) {
            // Calculate 'second' as (values[j] - j) for the current index
            int second = values[j] - j;

            // Update the maximum score by considering the current 'first' and 'second'
            ans = Math.max(ans, first + second);

            // Update 'first' to include the current element's contribution to (values[i] + i)
            first = Math.max(first, values[j] + j);
        }

        // Return the maximum score of a sightseeing pair
        return ans;
    }
}