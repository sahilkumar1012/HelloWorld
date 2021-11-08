package com.example.helloworld.dp.catalannumber;

import java.util.Scanner;

/**
 * pepcoding: Circle And Chords
 * [ https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/circle-and-chords-official/ojquestion ]
 *
 * 1. You are given a number N.
 * 2. There are 2*N points on a circle. You have to draw N non-intersecting chords on a circle.
 * 3. You have to find the number of ways in which these chords can be drawn.
 * Input Format
 * A number N
 * Output Format
 * Check the sample output and question video.
 * Question Video
 *
 *   COMMENTConstraints
 * 1 <= N <= 1000
 * 1 <= arr[i] <= 100
 * Sample Input
 * 3
 * Sample Output
 * 5
 */
public class CircleAndChords {
    public static long numberOfChords(int n){
        return CatalanNumber.findNthCatalanNumberLongAns(n);
        /*
        long[] dp = new long[n+1];
        dp[0] = 1l;
        dp[1] = 1l;

        // dp[i] means ith catalan number
        for(int i=2; i<=n; ++i){
            int l = 0;
            int r = i-1;

            while(l <= i-1){
                dp[i] += dp[l] * dp[r];
                l++;
                r--;
            }
        }

        return dp[n];
         */
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(numberOfChords(n));
    }

}
