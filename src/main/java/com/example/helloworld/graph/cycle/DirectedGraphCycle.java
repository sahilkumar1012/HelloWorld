package com.example.helloworld.graph.cycle;

import java.util.ArrayList;

/**
 * @author sahil
 *
 * gfg : https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
 *
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
 * The graph is represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge from verticex u to v.
 *
 * Examples:
 *
 * Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 0], [2, 3]]
 *
 * Output: true
 * Explanation: The diagram clearly shows a cycle 0 → 2 → 0
 * Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]
 *
 * Output: false
 * Explanation: no cycle in the graph
 * Constraints:
 * 1 ≤ V, E ≤ 105
 * u ≠ v
 */
public class DirectedGraphCycle {
    public boolean isCyclic(int V, int[][] edges) {
        // prepare adj
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        return isCyclic(V, adj);
    }

    // Function to detect cycle in a directed graph. ( DAG hai ki nahi )
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] currVisited = new boolean[V];

        for (int u = 0; u < V; u++) {
            if(!visited[u])
                if (cycle(u, visited, currVisited, adj))
                    return true;
        }
        return false;
    }

    // Detect cycle in graph
    private boolean cycle(int u, boolean[] visited, boolean[] currVisited, ArrayList<ArrayList<Integer>> adj) {
        if(currVisited[u]) return true;     // isi DFS mai fir se isi node pe agya mai.
        if(visited[u]) return false;        // kara hoga kisi ne visit phle. idk

        visited[u] = true;
        currVisited[u] = true;

        for (int v : adj.get(u)) {
            if (cycle(v, visited, currVisited, adj)) {
                return true;
            }
        }
        return currVisited[u] = false;      // backtracking.
    }

}