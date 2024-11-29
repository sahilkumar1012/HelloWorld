package com.example.helloworld.graph.dijkstra;

import java.util.PriorityQueue;

/**
 * leetcode 2577. Minimum Time to Visit a Cell In a Grid , Graph , Hard , Atlassian , Google
 *
 * Code Harmony Video Explanation : https://youtu.be/u72HaTxPg0Q
 * My Solution : https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/solutions/6093322/dijkstra-s-algorithm-easy-to-understand-detailed-video-explanation
 *
 * You are given a m x n matrix grid consisting of non-negative integers where grid[row][col] represents the minimum time required to be able to visit the cell (row, col), which means you can visit the cell (row, col) only when the time you visit it is greater than or equal to grid[row][col].
 *
 * You are standing in the top-left cell of the matrix in the 0th second, and you must move to any adjacent cell in the four directions: up, down, left, and right. Each move you make takes 1 second.
 *
 * Return the minimum time required in which you can visit the bottom-right cell of the matrix. If you cannot visit the bottom-right cell, then return -1.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: grid = [[0,1,3,2],[5,1,2,5],[4,3,8,6]]
 * Output: 7
 * Explanation: One of the paths that we can take is the following:
 * - at t = 0, we are on the cell (0,0).
 * - at t = 1, we move to the cell (0,1). It is possible because grid[0][1] <= 1.
 * - at t = 2, we move to the cell (1,1). It is possible because grid[1][1] <= 2.
 * - at t = 3, we move to the cell (1,2). It is possible because grid[1][2] <= 3.
 * - at t = 4, we move to the cell (1,1). It is possible because grid[1][1] <= 4.
 * - at t = 5, we move to the cell (1,2). It is possible because grid[1][2] <= 5.
 * - at t = 6, we move to the cell (1,3). It is possible because grid[1][3] <= 6.
 * - at t = 7, we move to the cell (2,3). It is possible because grid[2][3] <= 7.
 * The final time is 7. It can be shown that it is the minimum time possible.
 * Example 2:
 *
 *
 *
 * Input: grid = [[0,2,4],[3,2,1],[1,0,4]]
 * Output: -1
 * Explanation: There is no path from the top left to the bottom-right cell.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 1000
 * 4 <= m * n <= 105
 * 0 <= grid[i][j] <= 105
 * grid[0][0] == 0
 */
public class MinimumTimetoVisitaCellInaGrid {
    int[][] dir = { {0,1}, {0,-1}, {1,0}, {-1,0}};
    int m,n;
    boolean[][] visited;

    public int minimumTime(int[][] grid) {
        // dijkstra'a algo
        if(grid[0][1] > 1 && grid[1][0] > 1){
            return -1;
        }

        m = grid.length;
        n = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[2]-b[2]);
        visited = new boolean[m][n];
        pq.offer(new int[]{0,0,0});


        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int row = curr[0], col = curr[1], time = curr[2];

            if(row == m-1 && col == n-1) return time;
            if(visited[row][col]) continue;
            visited[row][col] = true;

            for(int[] d : dir){
                int r = row+d[0], c = col+d[1];

                // valid?
                if(!valid(r,c)) continue;

                // offer []
                int f = (grid[r][c]-time)%2==0? 1 : 0;
                int t = Math.max(time+1, grid[r][c]+f);
                pq.offer(new int[]{r,c,t});
            }
        }
        return -1;
    }

    private boolean valid(int i, int j){
        return i>=0 && j>=0 && i<m && j<n && !visited[i][j];
    }

}
