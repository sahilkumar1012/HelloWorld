package com.example.helloworld.graph.topological;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

/**
 * leetcode 210. Course Schedule II | ( topological sort )
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 */
public class CourseScheduleII {
    ArrayList<ArrayList<Integer>> adj; // Adjacency list to represent the directed graph

    /**
     * Find the order of courses to take based on prerequisites.
     * @param numCourses The total number of courses.
     * @param prerequisites Array representing prerequisites.
     * @return An array representing the order of courses or an empty array if it's not possible.
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (!canFinish(numCourses, prerequisites))
            return new int[0];

        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();

        // DFS traversal to populate the stack with course order (Topological Sorting)
        for (int u = 0; u < numCourses; u++) {
            if (!visited[u])
                dfs(u, visited, stack);
        }

        // Populate the answer array from the stack , we have to finish course at the bottom of the Stack.
        int[] ans = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    /**
     * Depth-first search traversal to populate the stack with course order.
     * @param u The current course.
     * @param visited Array to track visited courses.
     * @param stack Stack to store the order of courses.
     */
    private void dfs(int u, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, visited, stack);
            }
        }
        stack.push(u); // Push the current course into the stack after exploring its prerequisites
    }

    /**
     * Check if it's possible to finish all courses without violating prerequisites.
     * @param numCourses The total number of courses.
     * @param prerequisites Array representing prerequisites.
     * @return True if it's possible to finish all courses, otherwise false.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Prepare adjacency list representation of the directed graph
        adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>()); // Initialize adjacency list for each course
        }

        // Populate the adjacency list based on prerequisites
        for (int[] edge : prerequisites) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v); // Add directed edge from u to v
        }

        // Step 2: Use DFS to detect cycles in the directed graph
        boolean[] visited = new boolean[numCourses]; // Track visited nodes in the current DFS path
        boolean[] globalVisited = new boolean[numCourses]; // Track nodes visited across all DFS calls

        // Check for cycle starting from each course if not already visited
        for (int i = 0; i < numCourses; i++) {
            if (cycle(adj, i, visited, globalVisited)) // Note: visited should be fresh in each DFS call
                return false; // If cycle is detected, return false (cannot finish the courses)
        }

        return true; // If no cycle detected, return true (can finish the courses)
    }

    /**
     * Helper function to detect cycle in a directed graph using DFS.
     * @param adj Adjacency list representation of the directed graph.
     * @param u Current node in the DFS traversal.
     * @param visited Array to track visited nodes in the current DFS path.
     * @param globalVisited Array to track nodes visited across all DFS calls.
     * @return True if a cycle is detected, otherwise false.
     */
    private boolean cycle(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, boolean[] globalVisited) {
        if (visited[u]) // If the current node is visited in the current DFS path, cycle detected
            return true;

        if (globalVisited[u]) // If the current node has been visited in a previous DFS call, no cycle detected
            return false;

        visited[u] = true; // Mark the current node as visited in the current DFS path
        globalVisited[u] = true; // Mark the current node as globally visited across all DFS calls

        // Explore neighbors of the current node
        for (int v : adj.get(u)) {
            if (cycle(adj, v, visited, globalVisited)) // Recursively check for cycle in neighbors
                return true; // If cycle detected in neighbors, return true
        }

        visited[u] = false; // Reset the visited status for the current node before backtracking
        return false; // No cycle detected for the current node and its neighbors
    }

}
