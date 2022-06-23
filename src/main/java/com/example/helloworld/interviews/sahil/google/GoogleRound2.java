package com.example.helloworld.interviews.sahil.google;

import java.util.LinkedList;
import java.util.Queue;

public class GoogleRound2 {
}
/*
    Given a n x m matrix (a garden) with flowers located in specific locations in the matrix, given a specific location in the matrix, return the most
        fragrant flower from that location. Smells can only travel horizontally and vertically.


        |               10 |          15      |       10       |                  |                  |                  |
        |             15   |   "Rose" 20      |      15        |                  |                  |                  |
        |                  |          15      |      10   10   |                  |                  |                  |
        |                  |          10      |      5 20  :)  |  "Lotus"  0  30  |                  |                  |


        getStartingFragrance("Rose") -> 20 30
        getFragranceDecrease("Rose") -> 5  10


// queue data structure to perform bfs from flower cell.

// Rose 1,1  > 20

// [0,1], [1,2], [2,1], [1,0] > 15

// location i,j > capture the fragrance value + flower.
*/
class Solution{

    String ans;
    int maxFragranceValue;
    int n,m;

    public Solution(){
        ans = "";
        maxFragranceValue = 0;
    }

    public String mostFragrantFlower(String[][] matrix, int row, int col){


        if(matrix == null || matrix.length == 0)
            return "";

        n = matrix.length;
        m = matrix[0].length;

        // iterate through matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j].equals(""))     // not a flower
                    continue;

                int startingFragrance = getStartingFragrance(matrix[i][j]);
                int fragranceDecrease = getFragranceDecrease(matrix[i][j]);
                bfs(matrix, new boolean[n][m], i, j, row, col, startingFragrance, fragranceDecrease, matrix[i][j]);
            }
        }

        return ans;
    }

    private int getFragranceDecrease(String matrix) {
        return 0;
    }

    private int getStartingFragrance(String matrix) {
        return 0;
    }

    public void bfs(String[][] matrix, boolean[][] visited, int i, int j, int row, int col, int fregrance, int fragranceDecrease, String flower){
        // [i,j,fregrancevalue]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j,fregrance});


        while(!queue.isEmpty()){
            boolean reachedLocation = false;
            int len = queue.size();
            while(len -- > 0){
                int[] top = queue.poll();

                if(top[0]==row && top[1]==col){      // update the ans
                    if(maxFragranceValue < fregrance ){
                        maxFragranceValue = fregrance;
                        ans = flower;
                    }
                    reachedLocation = true;
                    break;
                }

                int[][] dir = { {1,0}, {-1,0}, {0,1}, {0,-1} };
                for(int[] d: dir){
                    int nrow = top[0] + d[0];
                    int ncol = top[1] + d[1];
                    if(! ( nrow < 0 || nrow >= n || ncol <0 || ncol >=m || visited[nrow][ncol] || fregrance-fragranceDecrease < 0 )){
                        visited[nrow][ncol] = true;
                        queue.offer(new int[]{nrow, ncol,fregrance-fragranceDecrease} );
                    }
                }
            }
            if(reachedLocation){
                break;
            }
        }


    }

}