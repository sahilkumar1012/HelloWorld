package com.example.helloworld.graph.dfs;

/**
 * leetcode 2257. Count Unguarded Cells in the Grid
 *
 * Code harmony video explanation : https://youtu.be/pYvIp_bCsmE
 *
 * You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the ith guard and jth wall respectively.
 *
 * A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.
 *
 * Return the number of unoccupied cells that are not guarded.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
 * Output: 7
 * Explanation: The guarded and unguarded cells are shown in red and green respectively in the above diagram.
 * There are a total of 7 unguarded cells, so we return 7.
 * Example 2:
 *
 *
 * Input: m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
 * Output: 4
 * Explanation: The unguarded cells are shown in green in the above diagram.
 * There are a total of 4 unguarded cells, so we return 4.
 *
 *
 * Constraints:
 *
 * 1 <= m, n <= 105
 * 2 <= m * n <= 105
 * 1 <= guards.length, walls.length <= 5 * 104
 * 2 <= guards.length + walls.length <= m * n
 * guards[i].length == walls[j].length == 2
 * 0 <= rowi, rowj < m
 * 0 <= coli, colj < n
 * All the positions in guards and walls are unique.
 */
public class CountUnguardedCellsintheGrid {
    // 2D grid representation where:
    // 0 -> unoccupied and unguarded cell
    // 1 -> guarded cell
    // 2 -> guard
    // 3 -> wall
    int[][] grid;
    int m; // Number of rows
    int n; // Number of columns

    /**
     * Main method to count the number of unguarded cells in the grid.
     *
     * @param m Number of rows in the grid
     * @param n Number of columns in the grid
     * @param guards Array of guard positions
     * @param walls Array of wall positions
     * @return Number of unoccupied and unguarded cells
     */
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // Initialize grid and class-level variables
        grid = new int[m][n];
        this.m = m;
        this.n = n;

        // Mark guard positions with value 2
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }

        // Mark wall positions with value 3
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 3;
        }

        // Use DFS to mark cells guarded by each guard
        for (int[] guard : guards) {
            int i = guard[0]; // Row of the guard
            int j = guard[1]; // Column of the guard
            dfs(i - 1, j, 'U'); // Explore upwards
            dfs(i + 1, j, 'D'); // Explore downwards
            dfs(i, j + 1, 'R'); // Explore to the right
            dfs(i, j - 1, 'L'); // Explore to the left
        }

        // Count unguarded cells (cells with value 0)
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    ans++; // Increment count for unguarded cells
                }
            }
        }
        return ans; // Return the total number of unguarded cells
    }

    /**
     * Depth First Search (DFS) to mark guarded cells in a given direction.
     *
     * @param i Current row
     * @param j Current column
     * @param dir Direction to move ('U' -> up, 'D' -> down, 'R' -> right, 'L' -> left)
     */
    private void dfs(int i, int j, int dir) {
        // Base case: Out of bounds or cell is already a guard (2), a wall (3), or already guarded (1)
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == 2 || grid[i][j] == 3) {
            return;
        }

        // Mark the current cell as guarded (value 1)
        grid[i][j] = 1;

        // Move in the same direction and continue marking cells
        if (dir == 'U') {
            dfs(i - 1, j, 'U'); // Continue upwards
        } else if (dir == 'D') {
            dfs(i + 1, j, 'D'); // Continue downwards
        } else if (dir == 'R') {
            dfs(i, j + 1, 'R'); // Continue to the right
        } else if (dir == 'L') {
            dfs(i, j - 1, 'L'); // Continue to the left
        }
    }
}
