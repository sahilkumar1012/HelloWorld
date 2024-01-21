package com.example.helloworld.graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a weighted, undirected and connected graph of V vertices and an adjacency list adj where adj[i] is a list of lists containing two integers where the first integer of each list j denotes there is edge between i and j , second integers corresponds to the weight of that  edge . You are given the source vertex S and You to Find the shortest distance of all the vertex's from the source vertex S. You have to return a list of integers denoting shortest distance between each node and Source vertex S.
 *
 *
 * Note: The Graph doesn't contain any negative weight cycle.
 */
public class ImplementingDijkstraAlgorithm {
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int source)
    {
        // Write your code here
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        // Queue<int[]> pq = new LinkedList<>();

        int[] cost = new int[V];
        Arrays.fill(cost, Integer.MAX_VALUE);

        cost[source] = 0;
        pq.offer(new int[]{0,source});

        while(!pq.isEmpty()){
            int[] rem = pq.poll();

            int currcost = rem[0];
            int currnode = rem[1];

            for(ArrayList<Integer> neighbor : adj.get(currnode)){
                int neighborcost = neighbor.get(1);
                int neighbornode = neighbor.get(0);
                int newcost = neighborcost + currcost;

                if(newcost < cost[neighbornode]){
                    cost[neighbornode] = newcost;
                    pq.offer(new int[]{newcost, neighbornode});
                }

            }
        }
        return cost;
    }

}

