package com.example.helloworld.graph;

import java.util.ArrayList;

/**
 * reference video for help : https://youtu.be/TL9oORCqHe8
 * # Detect cycle in a directed graph
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
        // code here
        boolean[] visited = new boolean[V];
        boolean[] currVisited = new boolean[V];

        for(int i=0; i<V; i++){
            if(!visited[i] && cycle(i, visited, currVisited, adj))
                return true;
        }
        return false;
    }
    private boolean cycle(int s, boolean[] visited, boolean[] currVisited, ArrayList<ArrayList<Integer>> adj){
        visited[s] = true;
        currVisited[s] = true;

        for(int i : adj.get(s)){

            if(!visited[i] && cycle(i, visited, currVisited, adj)){
                return true;
            }else if(visited[i] && currVisited[i] ){
                return true;
            }
        }
        return currVisited[s] = false;
    }

}