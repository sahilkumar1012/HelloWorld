package com.example.helloworld.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 1091. Shortest Path in Binary Matrix
 * reference video : https://youtu.be/CABaqOkWbgQ
 *
 *
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
 *
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 *
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 2
 * Example 2:
 *
 *
 * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 * Example 3:
 *
 * Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
 * Output: -1
 *
 *
 * Constraints:
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] is 0 or 1
 */
public class ShortestPathInBinaryMatrix {
    int n;
    int[][] dir = { {1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {-1,-1}, {1, -1}, {-1,1} };    // all 8 directions in grid

    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1]==1) return -1;

        // bfs
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});  // row, col, level
        grid[0][0] = 1;

        while(!q.isEmpty()){
            int len = q.size();

            while(len-- > 0){
                int[] point = q.poll();
                if(point[0] == n-1 && point[1] == n-1) return point[2];      // terminating case

                for(int[] d : dir){
                    int r = point[0] + d[0];
                    int c = point[1] + d[1];

                    if( r >= 0 && c >=0 && r< n && c < n && grid[r][c] == 0){
                        q.offer(new int[]{r, c, point[2]+1} );
                        grid[r][c] = 1;
                    }
                }
            }
        }
        return -1;
    }
}