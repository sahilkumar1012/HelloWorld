package com.example.helloworld.graph.dfs;

/**
 * leetcode 1254. Number of Closed Islands
 *
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 *
 * Return the number of closed islands.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation:
 * Islands in gray are closed because they are completely surrounded by water (group of 1s).
 * Example 2:
 *
 *
 *
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * Output: 1
 * Example 3:
 *
 * Input: grid = [[1,1,1,1,1,1,1],
 *                [1,0,0,0,0,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,1,0,1,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,0,0,0,0,1],
 *                [1,1,1,1,1,1,1]]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 */
public class NumberofClosedIslands {
    int ans = 0, m , n;

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0)
                    if(dfs(grid, i, j)) ans++;
            }
        }
        return ans;
    }

    private boolean dfs(int[][] grid, int r, int c){
        if(r<0 || c<0 || r>=m || c>=n)
            return false;
        if(grid[r][c] == 1 ) return true;

        grid[r][c] = 1;
        boolean res = true;

        int[] row = {1,0,-1,0};     // go in all 4 directions
        int[] col = {0,1,0,-1};
        for(int i=0; i<4; i++)
            res &= dfs(grid, r + row[i], c + col[i]);
        return res;
    }
}
