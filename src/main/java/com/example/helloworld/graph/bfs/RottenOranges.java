package com.example.helloworld.graph.bfs;

import com.example.helloworld.common.model.Index;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * leetcode 994. Rotting Oranges
 *
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 *
 */

public class RottenOranges {

    /**
     * Method to find the minimum number of minutes required for all oranges to rot.
     *
     * @param grid 2D grid representing the oranges.
     * @return Minimum minutes to rot all oranges, or -1 if not possible.
     */
    public int orangesRotting(int[][] grid) {
        int m = grid.length; // Rows of the grid
        int n = grid[0].length; // Columns of the grid

        int time = 0; // Time counter
        Queue<Index> q = new LinkedList<>(); // Queue to keep track of rotten oranges

        // Scan the grid to find rotten oranges and add them to the queue.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    q.offer(new Index(i, j)); // Add rotten orange index to the queue.
            }
        }

        // BFS traversal to spread the rotten oranges and calculate the time.
        while (!q.isEmpty()) {
            time++; // Increment the time for each level (minute)

            int len = q.size(); // Current size of the queue indicates oranges to be rotten in this minute.

            while (len-- > 0) {
                Index temp = q.poll(); // Dequeue the rotten orange.
                int x = temp.x;
                int y = temp.y;

                // Check 4-directional neighboring cells and make fresh oranges rotten.
                if (y + 1 < n && grid[x][y + 1] == 1) {
                    q.offer(new Index(x, y + 1)); // Add the index of the fresh orange to the queue.
                    grid[x][y + 1] = 2; // Update the grid to mark the orange as rotten.
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    q.offer(new Index(x, y - 1));
                    grid[x][y - 1] = 2;
                }
                if (x + 1 < m && grid[x + 1][y] == 1) {
                    q.offer(new Index(x + 1, y));
                    grid[x + 1][y] = 2;
                }
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    q.offer(new Index(x - 1, y));
                    grid[x - 1][y] = 2;
                }
            }
        }

        // After BFS traversal, check if any fresh orange remains.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    return -1; // If fresh orange remains, return -1 as it's impossible to rot all oranges.
            }
        }

        return time > 0 ? time - 1 : 0; // Return the time taken to rot all oranges, considering the initial condition.
    }
}
