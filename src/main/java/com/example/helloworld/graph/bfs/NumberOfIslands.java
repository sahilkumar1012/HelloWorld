package com.example.helloworld.graph.bfs;


/**
 * leetcode 200. Number of Islands
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 *
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){      // base case
            return 0;
        }

        int numIsland = 0;                    // heart.
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    numIsland += dfs(grid,i,j);
                }
            }
        }
        return numIsland;
    }

    private int dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 ||
                i >= grid.length || j >= grid[0].length ||
                grid[i][j] == '0') {    // terminating case
            return 0;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);     // go in all the required direction.
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        return 1;     // return 1 after sunking all the connected 1's
    }
}
