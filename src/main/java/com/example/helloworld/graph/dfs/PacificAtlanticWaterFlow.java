package com.example.helloworld.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 417. Pacific Atlantic Water Flow
 *  reference video for help : https://youtu.be/krL3r7MY7Dc
 *
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 *
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 *
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 *
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * Example 2:
 *
 * Input: heights = [[2,1],[1,2]]
 * Output: [[0,0],[0,1],[1,0],[1,1]]
 *
 *
 * Constraints:
 *
 * m == heights.length
 * n == heights[r].length
 * 1 <= m, n <= 200
 * 0 <= heights[r][c] <= 105
 */
public class PacificAtlanticWaterFlow {
        int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};  // for all 4 directions.
        int m,n;

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            m = heights.length; n = heights[0].length;
            List<List<Integer>> res = new ArrayList<>();

            // if true, we can reach specific ocean through that index
            boolean[][] pacific = new boolean[m][n];
            boolean[][] atlantic = new boolean[m][n];

            // dfs calls, first row and column have true for pacific, last row and col have true for atlantic
            for(int i=0; i<m; i++){
                dfs(heights, i, 0, heights[i][0], pacific);   // pacific to h hi, atlantic check kar lege in points se.
                dfs(heights, i, n-1, heights[i][n-1], atlantic); // last col
            }
            for(int i=0; i<n; i++){
                dfs(heights, 0, i, heights[0][i], pacific); // for top row
                dfs(heights, m-1, i, heights[m-1][i], atlantic);
            }

            // we've to find common of both the oceans
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(pacific[i][j] && atlantic[i][j])
                        res.add(Arrays.asList(i,j));
                }
            }
            return res;
        }

        // will fill the ocean using dfs
        private void dfs(int[][] heights, int r, int c, int prev, boolean[][] ocean){
            if( r < 0 || c < 0 || r >= m || c >= n ) return;       // nothing to do

            if(heights[r][c] < prev || ocean[r][c]) return;  // moving from ocean to inside
            ocean[r][c] = true;           // keep moving up and setting true for favorable cases

            for(int i=0; i<4; i++){
                dfs(heights, r+dir[i][0], c+dir[i][1], heights[r][c], ocean);
            }
        }
    }