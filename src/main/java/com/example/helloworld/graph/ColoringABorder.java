package com.example.helloworld.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 1034. Coloring A Border
 *
 * You are given an m x n integer matrix grid, and three integers row, col, and color. Each value in the grid represents the color of the grid square at that location.
 *
 * Two squares are called adjacent if they are next to each other in any of the 4 directions.
 *
 * Two squares belong to the same connected component if they have the same color and they are adjacent.
 *
 * The border of a connected component is all the squares in the connected component that are either adjacent to (at least) a square not in the component, or on the boundary of the grid (the first or last row or column).
 *
 * You should color the border of the connected component that contains the square grid[row][col] with color.
 *
 * Return the final grid.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 * Output: [[3,3],[3,2]]
 * Example 2:
 *
 * Input: grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 * Output: [[1,3,3],[2,3,3]]
 * Example 3:
 *
 * Input: grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
 * Output: [[2,2,2],[2,1,2],[2,2,2]]
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j], color <= 1000
 * 0 <= row < m
 * 0 <= col < n
 */
public class ColoringABorder {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        Set<Integer> visited = new HashSet<>();
        dfs(grid, row, col, grid[row][col], color, visited);
        return grid;
    }

    public int dfs(int[][] grid, int row, int col, int targetColor, int newColor, Set<Integer> visited) {
        if (visited.contains(row * 50 + col))
            return 1;
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != targetColor)
            return 0;

        int flag = 1;
        visited.add(row * 50 + col);
        flag *= dfs(grid, row - 1, col, targetColor, newColor, visited);
        flag *= dfs(grid, row + 1, col, targetColor, newColor, visited);
        flag *= dfs(grid, row, col - 1, targetColor, newColor, visited);
        flag *= dfs(grid, row, col + 1, targetColor, newColor, visited);

        if (flag == 0)
            grid[row][col] = newColor;

        return 1;
    }
}
