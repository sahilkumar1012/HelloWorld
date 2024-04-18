package com.example.helloworld.graph.dfs;

/**
 * easy leetcode 463. Island Perimeter
 *
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 * Example 2:
 *
 * Input: grid = [[1]]
 * Output: 4
 * Example 3:
 *
 * Input: grid = [[1,0]]
 * Output: 4
 *
 *
 * Constraints:
 *
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 100
 * grid[i][j] is 0 or 1.
 * There is exactly one island in grid.
 */
public class IslandPerimeter {

    // Input grid representing the map
    int[][] grid;

    // Directions for the DFS traversal (right, down, left, up)
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    // Dimensions of the grid and perimeter count
    int m, n, per;

    /**
     * Calculates the perimeter of the island in the given grid.
     *
     * @param grid The 2D array representing the map with land and water cells
     * @return The perimeter of the island
     */
    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        per = 0;
        this.grid = grid;

        // Iterate through the grid to find the starting point of the island
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // Once a land cell is found, initiate DFS from that point
                    dfs(i, j);
                    return per; // Perimeter is calculated, return the result
                }
            }
        }
        return 0; // No island found, return 0
    }

    /**
     * Performs DFS traversal to explore the island cells and calculate perimeter.
     *
     * @param i Row index of the current cell
     * @param j Column index of the current cell
     */
    private void dfs(int i, int j) {
        // If the current cell is outside the grid or is water, increase perimeter and return
        if (i == m || j == n || i < 0 || j < 0 || grid[i][j] == 0) {
            per++;
            return;
        }
        if (grid[i][j] == -1) return; // Cell already visited

        // Mark the current cell as visited
        grid[i][j] = -1;

        // Explore neighbors in all four directions
        for (int[] d : dir) {
            dfs(i + d[0], j + d[1]);
        }
    }
}