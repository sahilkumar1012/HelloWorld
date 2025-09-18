package com.example.helloworld.graph.dijkstra.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * leetcode 743. Network Delay Time ,
 *
 *
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * Example 2:
 *
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * Example 3:
 *
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
 *
 *
 */
public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        // prpeare adj
        int[][] adj = new int[n+1][n+1];
        for(int[] row : adj)
            Arrays.fill(row,-1);

        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj[u][v] = w;
        }

        int[] cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {return a[1]-b[1];});

        // use dijkstra to fill costs
        pq.offer(new int[]{k,0});
        cost[k] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int t = curr[1];

            for(int v = 1; v<=n; v++){
                if(adj[u][v] != -1){
                    int tt = t + adj[u][v];

                    if(tt < cost[v]){
                        cost[v] = tt;
                        pq.offer(new int[]{v, tt});
                    }
                }
            }
        }


        // System.out.println(Arrays.toString(cost));

        int max = 0;
        for(int i=1; i<=n; i++){
            if(cost[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, cost[i]);
        }
        return max;
    }


}
