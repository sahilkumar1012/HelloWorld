package com.example.helloworld.graph.topological;

import java.util.ArrayList;

/**
 * leetcode 207. Course Schedule
 * reference : DetectCycleInDirectedGraph.java
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Prepare adjacency list representation of the directed graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>()); // Initialize adjacency list for each course
        }

        // Populate the adjacency list based on prerequisites
        for(int[] edge : prerequisites){
            int u = edge[0], v = edge[1];
            adj.get(u).add(v); // Add directed edge from u to v
        }

        // Step 2: Use DFS to detect cycles in the directed graph
        boolean[] visited = new boolean[numCourses];     // Track visited nodes in the current DFS path

        // draw a diagram , if you're not able to visualize the need to global visited array
        boolean[] globalVisited = new boolean[numCourses];// Track nodes visited across all DFS calls

        for(int i = 0; i < numCourses; i++){
            // Check for cycle starting from each course if not already visited
            if(cycle(adj, i, visited, globalVisited))   // Note: visited should be fresh in each DFS call
                return false; // If cycle is detected, return false (cannot finish the courses)
        }

        return true; // If no cycle detected, return true (can finish the courses)
    }

    // Helper function to detect cycle in a directed graph using DFS
    private boolean cycle(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, boolean[] globalVisited){
        if(visited[u])      // If the current node is visited in the current DFS path, cycle detected
            return true;

        if(globalVisited[u]) // If the current node has been visited in a previous DFS call, no cycle detected
            return false;

        visited[u] = true;      // Mark the current node as visited in the current DFS path
        globalVisited[u] = true;// Mark the current node as globally visited across all DFS calls

        // Explore neighbors of the current node
        for(int v : adj.get(u)){
            if(cycle(adj, v, visited, globalVisited)) // Recursively check for cycle in neighbors
                return true; // If cycle detected in neighbors, return true
        }

        visited[u] = false; // Reset the visited status for the current node before backtracking
        return false; // No cycle detected for the current node and its neighbors
    }
}
