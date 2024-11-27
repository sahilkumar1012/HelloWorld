package com.example.helloworld.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 3243. Shortest Distance After Road Addition Queries I , Graph ,
 *
 * Code Harmony Video Explanation : https://youtu.be/BGNh6BejCII
 *
 * You are given an integer n and a 2D integer array queries.
 *
 * There are n cities numbered from 0 to n - 1. Initially, there is a unidirectional road from city i to city i + 1 for all 0 <= i < n - 1.
 *
 * queries[i] = [ui, vi] represents the addition of a new unidirectional road from city ui to city vi. After each query, you need to find the length of the shortest path from city 0 to city n - 1.
 *
 * Return an array answer where for each i in the range [0, queries.length - 1], answer[i] is the length of the shortest path from city 0 to city n - 1 after processing the first i + 1 queries.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5, queries = [[2,4],[0,2],[0,4]]
 *
 * Output: [3,2,1]
 *
 * Explanation:
 *
 *
 *
 * After the addition of the road from 2 to 4, the length of the shortest path from 0 to 4 is 3.
 *
 *
 *
 * After the addition of the road from 0 to 2, the length of the shortest path from 0 to 4 is 2.
 *
 *
 *
 * After the addition of the road from 0 to 4, the length of the shortest path from 0 to 4 is 1.
 *
 * Example 2:
 *
 * Input: n = 4, queries = [[0,3],[0,2]]
 *
 * Output: [1,1]
 *
 * Explanation:
 *
 *
 *
 * After the addition of the road from 0 to 3, the length of the shortest path from 0 to 3 is 1.
 *
 *
 *
 * After the addition of the road from 0 to 2, the length of the shortest path remains 1.
 *
 *
 *
 * Constraints:
 *
 * 3 <= n <= 500
 * 1 <= queries.length <= 500
 * queries[i].length == 2
 * 0 <= queries[i][0] < queries[i][1] < n
 * 1 < queries[i][1] - queries[i][0]
 * There are no repeated roads among the queries.
 */
public class ShortestDistanceAfterRoadAdditionQueriesI {
    // Adjacency list to represent the graph
    List<List<Integer>> adj;

    // dp array to store the shortest distance from city 0 to each city
    int[] dp;

    // Total number of cities
    int n;

    /**
     * This method computes the shortest path after each query.
     *
     * @param n The number of cities.
     * @param queries A 2D array representing the queries with new roads to be added.
     * @return An array representing the shortest path after each query.
     */
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // Initialize the number of cities and the adjacency list
        this.n = n;
        adj = new ArrayList<>();

        // Initialize adjacency list with an empty list for each city
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Initially, there are roads from city i to city i+1
        for (int i = 0; i <= n - 2; i++) {
            adj.get(i).add(i + 1);
        }

        // Array to store the answer for each query
        int[] ans = new int[queries.length];

        // Variable to iterate over the queries
        int i = 0;

        // Initialize the dp array to store shortest distances
        dp = new int[n];

        // Process each query
        for (int[] query : queries) {
            // Add the new road to the graph
            adj.get(query[0]).add(query[1]);

            // Reset the dp array for the new query
            Arrays.fill(dp, -1);

            // Compute the shortest path from city 0 to city n-1 and store it in the answer array
            ans[i++] = sol(0);
        }

        // Return the array with the shortest path lengths for each query
        return ans;
    }

    /**
     * This method computes the shortest path from city u to city n-1 using DFS and memoization.
     *
     * @param u The current city.
     * @return The shortest distance from city u to city n-1.
     */
    private int sol(int u) {
        // If we have reached city n-1, return 0 as the distance is 0 (no more roads to traverse)
        if (u == n - 1) {
            return 0;
        }

        // If the shortest distance from city u has already been computed, return the cached result
        if (dp[u] != -1)
            return dp[u];

        // Initialize the minimum distance to a large number (infinity)
        int min = n + 1;

        // Explore all the neighbors (cities that can be reached from the current city u)
        for (Integer nei : adj.get(u)) {
            // Recursively compute the shortest distance for each neighbor and update the minimum distance
            min = Math.min(min, 1 + sol(nei));
        }

        // Store the computed shortest distance in the dp array for city u and return the result
        return dp[u] = min;
    }
}
