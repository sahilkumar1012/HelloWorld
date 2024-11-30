package com.example.helloworld.graph.eulerianpath;

import java.util.*;

/**
 * leetcode : 2097. Valid Arrangement of Pairs , Eulerian Path , Meta Interview Question
 *
 * Code Harmony Video Explanation : https://youtu.be/280LNDYnX-M
 *
 * Pre-requisite Euler Path Introduction : https://youtu.be/KoLMNBEU5Po
 *
 * You are given a 0-indexed 2D integer array pairs where pairs[i] = [starti, endi]. An arrangement of pairs is valid if for every index i where 1 <= i < pairs.length, we have endi-1 == starti.
 *
 * Return any valid arrangement of pairs.
 *
 * Note: The inputs will be generated such that there exists a valid arrangement of pairs.
 *
 *
 *
 * Example 1:
 *
 * Input: pairs = [[5,1],[4,5],[11,9],[9,4]]
 * Output: [[11,9],[9,4],[4,5],[5,1]]
 * Explanation:
 * This is a valid arrangement since endi-1 always equals starti.
 * end0 = 9 == 9 = start1
 * end1 = 4 == 4 = start2
 * end2 = 5 == 5 = start3
 * Example 2:
 *
 * Input: pairs = [[1,3],[3,2],[2,1]]
 * Output: [[1,3],[3,2],[2,1]]
 * Explanation:
 * This is a valid arrangement since endi-1 always equals starti.
 * end0 = 3 == 3 = start1
 * end1 = 2 == 2 = start2
 * The arrangements [[2,1],[1,3],[3,2]] and [[3,2],[2,1],[1,3]] are also valid.
 * Example 3:
 *
 * Input: pairs = [[1,2],[1,3],[2,1]]
 * Output: [[1,2],[2,1],[1,3]]
 * Explanation:
 * This is a valid arrangement since endi-1 always equals starti.
 * end0 = 2 == 2 = start1
 * end1 = 1 == 1 = start2
 *
 *
 * Constraints:
 *
 * 1 <= pairs.length <= 105
 * pairs[i].length == 2
 * 0 <= starti, endi <= 109
 * starti != endi
 * No two pairs are exactly the same.
 * There exists a valid arrangement of pairs.
 */
public class ValidArrangementofPairs {

    public int[][] validArrangement(int[][] pairs) {
        // Adjacency list to store the graph
        Map<Integer, Deque<Integer>> adj = new HashMap<>();

        // Maps to track in-degrees and out-degrees of nodes
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        // Prepare adjacency list and track in-degrees and out-degrees
        for (int[] pair : pairs) {
            int u = pair[0], v = pair[1];
            // Add edge to adjacency list
            adj.computeIfAbsent(u, k -> new ArrayDeque<>()).add(v);
            // Update out-degree for the source node
            outDegree.put(u, outDegree.getOrDefault(u, 0) + 1);
            // Update in-degree for the destination node
            inDegree.put(v, inDegree.getOrDefault(v, 0) + 1);
        }

        // List to store the Eulerian path
        List<Integer> result = new ArrayList<>();

        // Find the starting node for the Eulerian path
        int start = -1;
        for (int node : outDegree.keySet()) {
            // If a node has out-degree greater than in-degree by 1, it must be the starting node
            if (outDegree.get(node) == inDegree.getOrDefault(node, 0) + 1) {
                start = node;
                break;
            }
        }
        // If no special start node is found, use the first node from the input pairs
        if (start == -1) {
            start = pairs[0][0];
        }

        // Perform a Depth-First Search (DFS) to find the Eulerian path
        dfs(start, adj, result);

        // Construct the result pairs from the Eulerian path
        Collections.reverse(result); // Reverse the result to get the correct order
        int[][] ans = new int[result.size() - 1][2];
        for (int i = 1; i < result.size(); i++) {
            ans[i - 1] = new int[] { result.get(i - 1), result.get(i) };
        }

        return ans; // Return the constructed pairs representing the valid arrangement
    }

    // Helper method to perform DFS and build the Eulerian path
    private void dfs(int u, Map<Integer, Deque<Integer>> adj, List<Integer> res) {
        // Get the neighbors of the current node
        Deque<Integer> nei = adj.get(u);
        // Visit all neighbors in the adjacency list
        while (nei != null && !nei.isEmpty()) {
            int v = nei.pollFirst(); // Remove the first neighbor ( removing edge from adj )
            dfs(v, adj, res);        // Recur for the next node
        }
        // Add the current node to the result after visiting all its neighbors
        res.add(u);
    }


}
