package com.example.helloworld.array;

/**
 * leetcode 59. Spiral Matrix II
 *
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 */
public class SpiralMatrixII {
        public int[][] generateMatrix(int n) {
            int l = 0, r = n-1, t = 0, b = n-1;

            int[][] ans = new int[n][n];

            for(int i=1; i<= ( n*n );){

                // first row
                for(int k=l; k<=r; k++){
                    ans[t][k] = i++;
                }
                t++;

                // last col
                for(int k=t; k<=b; k++){
                    ans[k][r] = i++;
                }
                r--;

                // last row
                for(int k=r; k>=l; k--){
                    ans[b][k] = i++;
                }
                b--;

                // first col
                for(int k=b; k>=t; k--){
                    ans[k][l] = i++;
                }
                l++;
            }

            return ans;
        }
    }
