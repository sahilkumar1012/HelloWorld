package com.example.helloworld.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 547. Number of Provinces
 *
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * Example 2:
 *
 *
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */

/**
 * As we just need the number not the sets, no need to maintain the result list.
 */
public class NumberOfProvinces {
    private boolean[] visited;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; int ans = 0;
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(visited[i] == false){
                dfs(isConnected, i, visited);
                ans++;
            }
        }

        return ans;
    }

    private void dfs(int[][] graph, int src, boolean[] visited){
        visited[src] = true;

        for(int i=0; i<graph.length; i++){
            if(graph[src][i]!=0 && !visited[i]){
                dfs(graph, i, visited);
            }
        }
    }
}

// // finding result components too in below, which was not required for this specific question
//public class NumberOfProvinces {
//
//    private boolean[] visited;
//
//    public int findCircleNum(int[][] isConnected) {
//        int n = isConnected.length; int ans = 0;
//        visited = new boolean[n];
//
//        List<List<Integer>> res = new ArrayList<>();
//
//        for(int i=0; i<n; i++){
//            if(visited[i] == false){
//                List<Integer> temp = new ArrayList<>();
//                dfs(isConnected, i, temp, visited);
//                res.add(temp);
//            }
//        }
//
//        return res.size();
//    }
//
//    private void dfs(int[][] graph, int src, List<Integer> temp, boolean[] visited){
//        visited[src] = true;
//        temp.add(src);
//
//        for(int i=0; i<graph.length; i++){
//            if(graph[src][i]!=0 && !visited[i]){
//                dfs(graph, i, temp, visited);
//            }
//        }
//    }
//}

