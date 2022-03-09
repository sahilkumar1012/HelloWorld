package com.example.helloworld.graph.dfs;

/**
 * leetcode 1905. Count Sub Islands
 *
 * You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.
 *
 * An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.
 *
 * Return the number of islands in grid2 that are considered sub-islands.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
 * Output: 3
 * Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
 * The 1s colored red in grid2 are those considered to be part of a sub-island. There are three sub-islands.
 * Example 2:
 *
 *
 * Input: grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
 * Output: 2
 * Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
 * The 1s colored red in grid2 are those considered to be part of a sub-island. There are two sub-islands.
 *
 *
 * Constraints:
 *
 * m == grid1.length == grid2.length
 * n == grid1[i].length == grid2[i].length
 * 1 <= m, n <= 500
 * grid1[i][j] and grid2[i][j] are either 0 or 1.
 */
public class CountSubIslands {
    int m,n;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid2.length; n = grid2[0].length;

        int ans = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid2[i][j] == 1){
                    if(dfs(grid1, grid2, i, j)) ans++;
                }
            }
        }

        return ans;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j){
        if(i<0 || j<0 || i>=m || j>=n || grid2[i][j] == 0)
            return true;

        boolean valid = true;

        grid2[i][j] = 0;

        if(grid1[i][j] == 0){       // dependency on grid1
            valid &= false;     // can't just directly return, we also need to invalidate cells( making 1 to 0 in current island)
        }

        int[] row = {1,0,-1,0};     // go in all 4 directions
        int[] col = {0,1,0,-1};
        for(int ii=0; ii<4; ii++)
            valid &= dfs(grid1, grid2, i+row[ii], j+col[ii]);

        return valid;
    }
}