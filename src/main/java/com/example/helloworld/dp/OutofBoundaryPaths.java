package com.example.helloworld.dp;

/**
 * leetcode 576. Out of Boundary Paths
 *
 * code harmony solution video : https://youtu.be/QRss6fJjPjA
 *
 * There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.
 *
 * Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * Output: 6
 * Example 2:
 *
 *
 * Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * Output: 12
 *
 *
 * Constraints:
 *
 * 1 <= m, n <= 50
 * 0 <= maxMove <= 50
 * 0 <= startRow < m
 * 0 <= startColumn < n
 */
public class OutofBoundaryPaths {
    // Directions array for moving up, down, left, and right
    int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

    // Memoization array to store already computed results
    Integer[][][] dp = new Integer[51][51][51];

    // Modulo value to avoid overflow
    int mod = 1000_000_007;

    /**
     * Main function to find the number of paths to move the ball out of the grid boundary.
     * @param m Number of rows in the grid
     * @param n Number of columns in the grid
     * @param maxMove Maximum number of moves allowed
     * @param startRow Starting row of the ball
     * @param startColumn Starting column of the ball
     * @return Number of paths to move the ball out of the grid boundary modulo 10^9 + 7
     */
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return sol(m, n, maxMove, startRow, startColumn);
    }

    /**
     * Recursive helper function to compute the number of paths using dynamic programming and memoization.
     * @param m Number of rows in the grid
     * @param n Number of columns in the grid
     * @param M Remaining number of moves
     * @param i Current row position
     * @param j Current column position
     * @return Number of paths to move the ball out of the grid boundary modulo 10^9 + 7
     */
    private int sol(int m, int n, int M, int i, int j){
        // Base case: if the ball is out of the grid, return 1 (a path is found)
        if(i<0 || j<0 || i==m || j==n) return 1;

        // Base case: if no moves left, return 0 (no valid path)
        if(M == 0) return 0;

        // If the result for the current state is already computed, return it
        if( dp[i][j][M] != null ) return dp[i][j][M];

        int ans = 0;

        // Iterate over all possible directions and recursively calculate the number of paths
        for(int[] d : dir){
            ans += sol(m, n, M-1, i+d[0], j+d[1]);
            ans %= mod;
        }

        // Memoize the result and return
        return dp[i][j][M] = ans;
    }
}
