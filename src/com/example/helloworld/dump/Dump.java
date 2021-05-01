package com.example.helloworld.dump;

import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Stream;

class Dump {
    public static void main(String[] args) {
//        System.out.println(solution("<<^<V>>"));
        int arr[] = new int[]{1,21,31,41,51};
        System.out.println(Arrays.binarySearch(arr,0,1,1));
    }

    /**
     * asked in microsoft, agam's test.
     * @param s
     * @return
     */
    public static int solution (String s){
        int n = s.length();
        boolean[][] dp = new boolean[3][n+2];

        for(int i=1; i<=n; ++i){
            dp[1][i] = true;
        }
        int res = 0;
        for(int i=0; i<n; ++i){
            switch(s.charAt(i)){
                case '<':
                    if(!dp[1][i]){
                        res++;
                        dp[1][i] = true;
                        dp[1][i+1] = false;
                    }
                    break;
                case '>':
                    if(!dp[1][i+2]){
                        res++;
                        dp[1][i+2] = true;
                        dp[1][i+1] = false;
                    }
                    break;
                default:
                    res++;
                    dp[1][i+1] = false;
            }
        }
        return res;
    }

}

