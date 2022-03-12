package com.example.helloworld.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 934. Shortest Bridge
 *  hint : apply bfs with queue initially having all the first island cells in it
 *
 * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
 *
 * An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
 *
 * You may change 0's to 1's to connect the two islands to form one island.
 *
 * Return the smallest number of 0's you must flip to connect the two islands.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 *
 * Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == grid.length == grid[i].length
 * 2 <= n <= 100
 * grid[i][j] is either 0 or 1.
 * There are exactly two islands in grid.
 */
public class ShortestBridge {
    int m, n;
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};    // all 4 directions

    public int shortestBridge(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // capture first island in the queue
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!found && grid[i][j] == 1) {
                    capture(grid, i, j, q);
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }

        // bfs from island 1 till we encounter second island
        while (!q.isEmpty()) {
            int len = q.size();
            while (len-- > 0) {
                int[] point = q.poll();
                int r = point[0];
                int c = point[1];

                for (int[] d : dir) {
                    int newRow = r + d[0];
                    int newCol = c + d[1];

                    if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && grid[newRow][newCol] != -1) {
                        if (grid[newRow][newCol] == 1)
                            return point[2];
                        else
                            grid[newRow][newCol] = -1;      // mark visited

                        q.offer(new int[]{newRow, newCol, point[2] + 1});
                    }
                }
            }
        }

        return -1;
    }

    // dfs, out utility function to fill queue with first island, from where we'll use bfs till second island.
    private void capture(int[][] grid, int r, int c, Queue<int[]> q) {
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] <= 0)
            return;

        grid[r][c] = -1;    // visiting first island
        q.offer(new int[]{r, c, 0});

        for (int[] d : dir)
            capture(grid, r + d[0], c + d[1], q);
    }
}
