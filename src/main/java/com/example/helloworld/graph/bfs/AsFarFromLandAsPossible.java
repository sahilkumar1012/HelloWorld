package com.example.helloworld.graph.bfs;


import java.util.LinkedList;
import java.util.Queue;


/**
 * leetcode 1162. As Far from Land as Possible
 * Hint : use bfs starting wth all the 1s.
 *
 * Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.
 *
 * The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
 * Output: 2
 * Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
 * Example 2:
 *
 *
 * Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
 * Output: 4
 * Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.
 *
 *
 * Constraints:
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] is 0 or 1
 */
public class AsFarFromLandAsPossible {
    int n;

    public int maxDistance(int[][] grid) {
        n = grid.length;
        Queue<Index> q = new LinkedList<>();
        int ans = 0, water = 0, land = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                if(grid[i][j] == 1){
                    q.offer(new Index(i,j)); land++;
                }else
                    water ++ ;
            }
        }

        if(land == 0 || water == 0) return -1;

        // bfs on 1s
        while(!q.isEmpty()){
            int len = q.size();
            while(len -- > 0){
                Index temp = q.poll();

                int[] row = {1,0,-1,0};     // go in all 4 directions
                int[] col = {0,1,0,-1};
                for(int idx=0; idx<4; idx++){
                    int nr = temp.i + row[idx];
                    int nc = temp.j + col[idx];

                    if( nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 0){
                        grid[nr][nc] = 1;
                        q.offer(new Index(nr,nc));
                    }
                }
            }
            ans++;      // done with this level
        }

        return ans-1;
    }

}

class Index{
    public int i;
    public int j;
    public Index(int i, int j){
        this.i = i;
        this.j = j;
    }
}