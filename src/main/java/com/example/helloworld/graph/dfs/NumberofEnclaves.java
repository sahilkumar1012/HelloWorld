package com.example.helloworld.graph.dfs;

/**
 * leetcode 1020. Number of Enclaves
 *
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 *
 * A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
 *
 * Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
 * Example 2:
 *
 *
 * Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * Output: 0
 * Explanation: All 1s are either on the boundary or can reach the boundary.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid[i][j] is either 0 or 1.
 */
public class NumberofEnclaves {
    int ans = 0, m , n;

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                if(grid[i][j] == 1){
                    Int count = new Int(0);
                    if(dfs(grid, i, j, count))        // if it's an enclave
                        ans += count.val;
                }
            }
        }
        return ans;
    }

    private boolean dfs(int[][] grid, int r, int c, Int count){
        // edge cases
        if(r<0 || c<0 || r>=m || c>=n)
            return false;
        if(grid[r][c] == 0) return true;

        // process current land cell
        grid[r][c] = 0;
        count.val++;
        boolean res = true;

        int[] row = {1,0,-1,0};     // go in all 4 directions
        int[] col = {0,1,0,-1};
        for(int i=0; i<4; i++)
            res &= dfs(grid, r + row[i], c + col[i], count);

        return res;
    }
}

/**
 * as we need to pass reference, we need its value to be updated in the called function.
 *
 * primitives types are passed by value.
 */
class Int{
    int val;
    public Int(int val){
        this.val = val;
    }
}