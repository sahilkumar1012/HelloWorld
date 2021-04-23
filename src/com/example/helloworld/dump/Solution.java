package com.example.helloworld.dump;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().solve();
        "".toCharArray();
    }
    private void solve() {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        while(n-- > 0){
            String word = in.nextLine();

            if(word.length() > 10){
                System.out.println( word.charAt(0) + "" + (word.length()-2) + "" + word.charAt(word.length()-1) );
                continue;
            }
            System.out.println(word);
        }

    }
}


/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */