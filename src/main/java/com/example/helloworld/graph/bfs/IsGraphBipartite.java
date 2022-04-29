package com.example.helloworld.graph.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 785. Is Graph Bipartite?
 *
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
 *
 * There are no self-edges (graph[u] does not contain u).
 * There are no parallel edges (graph[u] does not contain duplicate values).
 * If v is in graph[u], then u is in graph[v] (the graph is undirected).
 * The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
 *
 * Return true if and only if it is bipartite.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
 * Output: false
 * Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
 * Example 2:
 *
 *
 * Input: graph = [[1,3],[0,2],[1,3],[0,2]]
 * Output: true
 * Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
 *
 *
 * Constraints:
 *
 * graph.length == n
 * 1 <= n <= 100
 * 0 <= graph[u].length < n
 * 0 <= graph[u][i] <= n - 1
 * graph[u] does not contain u.
 * All the values of graph[u] are unique.
 * If graph[u] contains v, then graph[v] contains u.
 */
public class IsGraphBipartite {

    // video for reference : https://youtu.be/ZBhZ1DXGrhA
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];     // we'll store level in visited array
        Arrays.fill(visited, -1);

        for(int i=0; i<n; i++){
            if(visited[i] == -1 && !isBipartite(graph, i, visited)){
                return false;
            }
        }

        return true;
    }
    // bfs approach
    private boolean isBipartite(int[][] graph, int src, int[] visited){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});        // src, dest, level

        while(! q.isEmpty() ){
            int[] rem = q.poll();
            int source = rem[0];        // current source
            int level = rem[1];         // level of source

            if(visited[source] != -1){      //already visited
                if(visited[source] != level){  // if visited of some different level, not bipartite
                    return false;
                }
            }else{
                visited[source] = level;
            }

            for(int dest : graph[source]){
                if(visited[dest] == -1){
                    q.offer( new int[]{dest, level + 1} ) ;
                }
            }
        }

        return true;
    }
}