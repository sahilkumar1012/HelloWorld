package com.example.helloworld.graph.dfs;

/**
 * leetcode 695. Max Area of Island
 *
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 *
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1
 */
public class MaxAreaOfIsland {
    int m;
    int n;
    int res;
    int[][] grid;

    public int maxAreaOfIsland(int[][] matrix) {
        grid = matrix;
        res = 0;
        m = grid.length;
        n = grid[0].length;

        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if( grid[i][j] == 1 ){
                    res = Math.max(res, sol(i, j) );
                }
            }
        }

        return res; //maximum area of island
    }

    private int sol(int i, int j){
        if(i>=m || j>=n || i<0 || j<0 || grid[i][j]==0)     // negative case.
            return 0;

        int a = 1;  // area of specific island
        grid[i][j] = 0;   // sink it

        a += sol(i+1,j);
        a += sol(i-1,j);
        a += sol(i,j+1);
        a += sol(i,j-1);

        return a;
    }
}
