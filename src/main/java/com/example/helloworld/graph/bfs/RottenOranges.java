package com.example.helloworld.graph.bfs;

import com.example.helloworld.common.model.Index;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * leetcode 994. Rotting Oranges
 *
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 *
 */
public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int time = 0;
        Queue<Index> q= new LinkedList<>();

        // scan all rotten oranges and put in queue
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2)
                    q.offer(new Index(i,j));
            }
        }

        // bfs
        while(!q.isEmpty()){
            time++;
            int len = q.size();

            while(len-- > 0){
                Index temp= q.poll();
                int x = temp.x;
                int y = temp.y;

                if(y+1<n && grid[x][y+1]==1){
                    q.offer(new Index(x,y+1));
                    grid[x][y+1]=2;
                }
                if(y-1 >= 0 && grid[x][y-1]==1){
                    q.offer(new Index(x,y-1));
                    grid[x][y-1]=2;
                }
                if(x+1<m && grid[x+1][y]==1){
                    q.offer(new Index(x+1,y));
                    grid[x+1][y]=2;
                }
                if(x-1 >= 0 && grid[x-1][y]==1){
                    q.offer(new Index(x-1,y));
                    grid[x-1][y]=2;
                }
            }

        }

        // impossible for oranges to get rotten, so return -1.
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1)
                    return -1;
            }
        }

        return time>0 ? time-1 : 0; // first batch to sada hua hi mila tha na aapa ko.
    }

}
