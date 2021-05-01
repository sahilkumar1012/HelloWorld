package com.example.helloworld.Tests.microsoft.agam;

/**
 * questions asked in agam's microsoft test.
 */
public class Microsoft1 {

    public static void main(String[] args) {
        System.out.println(solution("<<^<V>>"));
    }

    /**
     * asked in microsoft, agam's test.
     *
     * valid moves players can perfom upr niche dae bae.
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
