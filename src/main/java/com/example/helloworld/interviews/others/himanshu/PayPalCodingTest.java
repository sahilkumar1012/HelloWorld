package com.example.helloworld.interviews.others.himanshu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class PayPalCodingTest {
    public static long[] tot = new long[1000005];

    public static boolean check(int u){
        int cnt = 60;
        while(cnt -- > 0){
            int ans = 0;
            while(u > 0){
                ans += (u%10) * (u%10);
                u /= 10;
            }
            u = ans;
            if(u == 1 ) return true;
        }
        return false;
    }
    public static void pre(){
        for(int i=1; i<=1000000; i++){
            if(check(i)){
                tot[i] = i;
            }
        }
        for(int i=1; i<= 1000000; i++){
            tot[i] += tot[i-1];
        }
    }

    public static void main(String[] args) throws IOException {
        pre();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            String[] str = br.readLine().split(" ");
            int l = Integer.parseInt(str[0]);
            int r = Integer.parseInt(str[1]);

            long out_ = solve(l, r);
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }
    static long solve(int l, int r){
        // Your code goes here
        return tot[r] - tot[l-1];
    }
}