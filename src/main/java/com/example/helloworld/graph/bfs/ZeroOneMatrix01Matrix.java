package com.example.helloworld.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 542. 01 Matrix
 * reference video link : https://youtu.be/BJbaUH9dN24 ( for algo only ) , we'll use something like reverse bfs in this case, bfs from 1s will be very complex
 *
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * Example 2:
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 *
 */
public class ZeroOneMatrix01Matrix {
    int[][] dir  = { {1,0}, {0,1}, {-1,0}, {0,-1} };    // all 4 directions

    // reverse bfs
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0)
                    q.offer(new int[]{i,j});
                else
                    mat[i][j] = -1;     // considering -1 as non visited index
            }
        }

        // matrix with 0 and -1 is ready. with all 0s offered in the queue
        while(!q.isEmpty()){
            int len = q.size();
            while(len -- > 0){
                int[] point = q.poll();
                for(int[] d: dir){
                    int r = point[0] + d[0];
                    int c = point[1] + d[1];

                    if(r>=0 && c>=0 && r<m && c<n && mat[r][c] == -1){
                        q.offer(new int[]{r,c});
                        mat[r][c] = 1 + mat[point[0]][point[1]];
                    }
                }
            }
        }

        return mat;
    }
}