package com.example.helloworld.graph.cycle;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 802. Find Eventual Safe States , Google, Meta
 *
 * Code Harmony Video Explanation : https://youtu.be/uk12ve1hjlk
 *
 * My LeetCode Solution : https://leetcode.com/problems/find-eventual-safe-states/solutions/6323442/easy-explanation-cycle-in-graph-java-det-1b1m
 *
 *
 * logic used : detect cycle in directed graph.
 * <p>
 * There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
 * <p>
 * A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node.
 * <p>
 * Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Illustration of graph
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * Output: [2,4,5,6]
 * Explanation: The given graph is shown above.
 * Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
 * Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
 * Example 2:
 * <p>
 * Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
 * Output: [4]
 * Explanation:
 * Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == graph.length
 * 1 <= n <= 104
 * 0 <= graph[i].length <= n
 * 0 <= graph[i][j] <= n - 1
 * graph[i] is sorted in a strictly increasing order.
 * The graph may contain self-loops.
 * The number of edges in the graph will be in the range [1, 4 * 104].
 */
public class FindEventualSafeStates {
    // Prerequisite question: Detect Cycle in a Directed Graph
    // Link: https://github.com/sahilkumar1012/HelloWorld/blob/master/src/main/java/com/example/helloworld/graph/cycle/DetectCycleInDirectedGraph.java

    // Method to find all eventual safe nodes in a directed graph.
    // A node is considered safe if it is not part of any cycle.
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length; // Number of nodes in the graph

        // Arrays to keep track of visited nodes, nodes currently in the recursion stack, and nodes part of a cycle
        boolean[] visited = new boolean[n];
        boolean[] currVisited = new boolean[n];
        boolean[] inCycle = new boolean[n]; // Flag to mark nodes that are part of a cycle

        // Iterate through all nodes to detect cycles
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // Perform DFS to detect cycles starting from the current node
                cycle(i, visited, currVisited, inCycle, graph);
            }
        }

        // Add nodes that are not part of a cycle to the result list
        for (int i = 0; i < n; i++) {
            if (!inCycle[i])
                ans.add(i);
        }
        return ans;
    }

    // Helper method to perform DFS and detect cycles
    private boolean cycle(int s, boolean[] visited, boolean[] currVisited, boolean[] inCycle, int[][] graph) {
        visited[s] = true; // Mark the current node as visited
        currVisited[s] = true; // Mark the current node as being in the recursion stack

        // Explore all neighbors of the current node
        for (int i : graph[s]) {
            // If a neighbor is unvisited, recursively check for cycles
            if (!visited[i] && cycle(i, visited, currVisited, inCycle, graph)) {
                return inCycle[s] = true; // Mark current node as part of a cycle
            }
            // If a neighbor is visited and still in the recursion stack, a cycle is detected
            else if (visited[i] && currVisited[i]) {
                return inCycle[s] = true; // Mark current node as part of a cycle
            }
        }

        // Backtrack: remove the current node from the recursion stack
        return currVisited[s] = false;
    }
}
