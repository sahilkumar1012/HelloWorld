package com.example.helloworld.graph.cycle;

import java.util.ArrayList;

/**
 * @author sahil
 *
 * Detect cycle in a directed graph
 *
 * geeksforgeeks https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1#
 *
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
 *
 * Expected Time Complexity: O(V + E)
 * Expected Auxiliary Space: O(V)
 *
 *
 * Constraints:
 * 1 ≤ V, E ≤ 105
 */
public class DetectCycleInDirectedGraph {

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // Create an array to track nodes that have been visited during traversal.
        boolean[] visited = new boolean[V];

        // Create an array to track nodes that have been visited in the current traversal path.
        boolean[] currVisited = new boolean[V];

        // Traverse each vertex in the graph.
        for (int i = 0; i < V; i++) {
            // If the vertex hasn't been visited yet and there's a cycle starting from it, return true.
            if (!visited[i] && cycle(i, visited, currVisited, adj))
                return true;
        }
        // If no cycle is detected after traversing all vertices, return false.
        return false;
    }

    // Helper function to detect cycle using Depth First Search (DFS).
    private boolean cycle(int s, boolean[] visited, boolean[] currVisited, ArrayList<ArrayList<Integer>> adj) {
        // Mark the current node as visited in both arrays.
        visited[s] = true;      // taking this to improve the complexity, and avoid making access cheques.
        currVisited[s] = true;

        // Explore all adjacent vertices of the current node.
        for (int i : adj.get(s)) {
            // If an adjacent vertex is not visited yet and it leads to a cycle, return true.
            if (!visited[i] && cycle(i, visited, currVisited, adj)) {
                return true;
            }
            // If the adjacent vertex has been visited in the current traversal, a cycle is detected.
            else if (visited[i] && currVisited[i]) {
                return true;
            }
        }
        // Backtrack: Mark the current node as unvisited in the current traversal path and return false.
        return currVisited[s] = false;
    }

    // write a main method to test

}