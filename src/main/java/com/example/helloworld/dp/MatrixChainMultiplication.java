package com.example.helloworld.dp;

import java.util.Scanner;

/**
 * Matrix Chain Multiplication
 * pepcoding : https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/matrix-chain-multiplication-official/ojquestion
 * video : https://youtu.be/pEYwLmGJcvs?list=TLGGU3WiV3bXWiswODExMjAyMQ
 *
 * 1. You are given an array(arr) of positive integers of length N which represents the dimensions of N-1 matrices such that the ith matrix is of dimension arr[i-1] x arr[i].
 * 2. You have to find the minimum number of multiplications needed to multiply the given chain of matrices.
 * Input Format
 * A number N
 * arr1
 * arr2.. N integers
 * Output Format
 * Check the sample output and question video.
 * Question Video
 *
 *   COMMENTConstraints
 * 2 <= N <= 1000
 * 1 <= arr[i] <= 500
 * Sample Input
 * 3
 * 1
 * 2
 * 3
 * Sample Output
 * 6
 */
public class MatrixChainMultiplication {

    /**
     * Matrix chain multiplication, will return the minimum number of multiplications needed to multiply the given chain of matrices.
     * @param arr
     * @return
     */
    public static int matrixChainMultiplication(int[] arr){
        //write your code here
        int n = arr.length;
        int[][] dp = new int[n-1][n-1];

        // gap strategy, g is size of window
        for (int g = 0; g < dp.length; ++g) {
            for(int i=0,j=g; j < dp.length; i++,j++){
                if(g == 0){
                   dp[i][j] = 0;
                }else if(g == 1){
                    dp[i][j] = arr[i] * arr[i+1] * arr[i+2];
                }else{
                    int min = Integer.MAX_VALUE;
                    for(int k = i; k < j; ++k){
                        // i, k is left half and k+1, j is right half
                        // arr[i,k+1] order of left matrix , arr[k+1, j+1 ] order of right matrix
                        int lc = dp[i][k];
                        int rc = dp[k+1][j];
                        int mc = arr[i] * arr[k+1] * arr[j+1];
                        int tc = lc + rc + mc;
                        if(tc < min)
                            min = tc;
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][dp.length-1];
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(matrixChainMultiplication(arr));
    }

}
