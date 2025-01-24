package com.example.helloworld.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 1765. Map of Highest Peak , Google Interview Question
 *
 * Code harmony video explanation : https://youtu.be/qiUhyPCqIcU
 *
 * My leetcode solution : https://leetcode.com/problems/map-of-highest-peak/solutions/6314171/easy-to-understand-breadth-first-search-trvv5
 *
 * You are given an integer matrix isWater of size m x n that represents a map of land and water cells.
 *
 * If isWater[i][j] == 0, cell (i, j) is a land cell.
 * If isWater[i][j] == 1, cell (i, j) is a water cell.
 * You must assign each cell a height in a way that follows these rules:
 *
 * The height of each cell must be non-negative.
 * If the cell is a water cell, its height must be 0.
 * Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
 * Find an assignment of heights such that the maximum height in the matrix is maximized.
 *
 * Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: isWater = [[0,1],[0,0]]
 * Output: [[1,0],[2,1]]
 * Explanation: The image shows the assigned heights of each cell.
 * The blue cell is the water cell, and the green cells are the land cells.
 * Example 2:
 *
 *
 *
 * Input: isWater = [[0,0,1],[1,0,0],[0,0,0]]
 * Output: [[1,1,0],[0,1,1],[1,2,2]]
 * Explanation: A height of 2 is the maximum possible height of any assignment.
 * Any height assignment that has a maximum height of 2 while still meeting the rules will also be accepted.
 *
 *
 * Constraints:
 *
 * m == isWater.length
 * n == isWater[i].length
 * 1 <= m, n <= 1000
 * isWater[i][j] is 0 or 1.
 * There is at least one water cell.
 */
public class MapofHighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length; // Number of rows in the grid
        int n = isWater[0].length; // Number of columns in the grid
        int height = 0; // Height to be assigned to each cell level by level

        // Directions for moving up, down, left, and right
        int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        int[][] ans = new int[m][n]; // Result grid to store the height of each cell
        boolean[][] visited = new boolean[m][n]; // To keep track of visited cells

        // Queue for BFS (breadth-first search)
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    // If the cell is water, set it as the starting point with height 0
                    q.offer(new int[] { i, j });
                    visited[i][j] = true; // Mark water cells as visited
                }
            }
        }

        // BFS to calculate heights for all cells
        while (!q.isEmpty()) {
            int len = q.size(); // Number of cells to process at the current height
            while (len-- > 0) {
                int[] curr = q.poll(); // Get the current cell
                int i = curr[0];
                int j = curr[1];
                ans[i][j] = height; // Assign the current height to the cell

                // Check all four neighboring cells
                for (int[] d : dir) {
                    int ni = i + d[0]; // Neighbor row index
                    int nj = j + d[1]; // Neighbor column index
                    // If the neighbor is within bounds and not visited
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                        q.offer(new int[] { ni, nj }); // Add neighbor to the queue
                        visited[ni][nj] = true; // Mark the neighbor as visited
                    }
                }
            }
            height++; // Increment the height for the next level of cells
        }
        return ans; // Return the result grid
    }

}
