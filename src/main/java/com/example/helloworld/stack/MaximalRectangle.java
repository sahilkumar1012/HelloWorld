package com.example.helloworld.stack;

import java.util.Stack;

/**
 * leetcode 85. Maximal Rectangle
 *
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 * Example 2:
 *
 * Input: matrix = []
 * Output: 0
 * Example 3:
 *
 * Input: matrix = [["0"]]
 * Output: 0
 * Example 4:
 *
 * Input: matrix = [["1"]]
 * Output: 1
 * Example 5:
 *
 * Input: matrix = [["0","0"]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * rows == matrix.length
 * cols == matrix[i].length
 * 0 <= row, cols <= 200
 * matrix[i][j] is '0' or '1'.
 */
public class MaximalRectangle {

/*
I took reference from tushar roy's video to find largest area in a histogram.

https://youtu.be/ZmnqCZp9bBs

first i made every row independent, checking usse upr kitne 1 hai jo consider ho sakte hai. then on every row i checked largestRectangleHistogram to get the desired result.
*/

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if(n==0)
            return 0;
        int m = matrix[0].length;

        // firstly i created integer matrix from character matrix.
        int[][] mat = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m; ++j){
                mat[i][j] = matrix[i][j]=='0' ? 0 : 1;
            }
        }

        // make ever row independent.
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    mat[i][j] = 1 + mat[i-1][j];
                }
            }
        }

        // calling largest histogram area for every row.
        int ans = 0;
        for(int i=0; i<n; ++i){
            ans = Math.max( ans, largestRectangleArea(mat[i]) );
        }
        return ans;
    }

    // largest rectange area in historgram wala logic.
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int maxArea = 0, area=0,i;

        for(i=0;i<heights.length;){
            if(s.isEmpty() || heights[s.peek()]<=heights[i] ){
                s.push(i++);
            }else{

                int top = s.pop();
                if(s.isEmpty()){
                    area = heights[top] * i;
                }else{
                    area = heights[top] * (i-s.peek()-1);
                }

                if(area>maxArea)
                    maxArea = area;

            }
        }

        while(!s.isEmpty()){

            int top = s.pop();
            if(s.isEmpty()){
                area = heights[top] * i;
            }else{
                area = heights[top] * (i-s.peek()-1);
            }

            if(area>maxArea)
                maxArea = area;
        }

        return maxArea;
    }

}
