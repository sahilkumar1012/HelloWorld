package com.example.helloworld.dp.catalannumber;

/**
 * find nth catalan number
 * resource : https://youtu.be/qqcN4ROOusM
 */
public class CatalanNumber {
    public static int findNthCatalanNumber(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

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
    }

    public static long findNthCatalanNumberLongAns(int n){
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
    }
}
