package com.example.helloworld.dp.google;

public class DPInterview1 {
    int[] arr;
    int[] dp;
    int n;

    public int maxPoints(int[] arr){
        this.arr = arr;
        n = arr.length;
        this.dp = new int[n];

        return sol(0);
    }

    private int sol(int idx) {
        if(idx >= n) return 0;

        if(dp[idx] != 0) return dp[idx];

        int include = arr[idx] + sol(idx + arr[idx]);
        int exclude = sol(idx+1);

        return dp[idx] = Math.max(include, exclude);
    }

    public static void main(String[] args) {
        DPInterview1 obj = new DPInterview1();
        int ans = obj.maxPoints(new int[]{25,1,2,99,4});
        System.out.println(ans);
    }
}
