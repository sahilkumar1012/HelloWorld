package com.example.helloworld.graph.minimumspanningtree;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * leetcode 1584. Min Cost to Connect All Points , MST , Prim's Algorithm
 *
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 *
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 *
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 * Explanation:
 *
 * We can connect the points as shown above to get the minimum cost of 20.
 * Notice that there is a unique path between every pair of points.
 * Example 2:
 *
 * Input: points = [[3,12],[-2,5],[-4,1]]
 * Output: 18
 *
 *
 * Constraints:
 *
 * 1 <= points.length <= 1000
 * -106 <= xi, yi <= 106
 * All pairs (xi, yi) are distinct.
 */
public class MinCosttoConnectAllPoints {

    // Minimum spanning tree logic | Prim's algorithm
    public int minCostConnectPoints(int[][] points) {
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> { return a[2] - b[2]; });
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0,0,0});         // source dest travel-cost

        int cost = 0, n = points.length;
        Set<Integer> visited = new HashSet<>();

        while(!pq.isEmpty() && visited.size() < n){
            int[] curr = pq.poll();
            int currId = curr[1];
            int currCost = curr[2];

            if(visited.contains(currId)) continue;

            cost += currCost;
            visited.add(currId);

            for(int i=0; i<n; i++){             // either iterate all the points, or just create adj list in the starting using these
                if(!visited.contains(i)){
                    pq.offer(new int[]{ currId, i, distance(points, currId, i)} );
                }
            }
        }
        return cost;
    }

    // distance as per logic given in the problem statement
    private int distance(int[][] points, int a, int b){
        return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
    }
}
