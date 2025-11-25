package com.example.helloworld.backtracking.hard;

import java.util.*;

/**
 * leetcode 679. 24 Game    , Hard, Uber, Google
 *
 * Code Harmony Video explanation: https://youtu.be/Wdq4841zx_0
 *
 * You are given an integer array cards of length 4. You have four cards, each containing a number in the range [1, 9]. You should arrange the numbers on these cards in a mathematical expression using the operators ['+', '-', '*', '/'] and the parentheses '(' and ')' to get the value 24.
 *
 * You are restricted with the following rules:
 *
 * The division operator '/' represents real division, not integer division.
 * For example, 4 / (1 - 2 / 3) = 4 / (1 / 3) = 12.
 * Every operation done is between two numbers. In particular, we cannot use '-' as a unary operator.
 * For example, if cards = [1, 1, 1, 1], the expression "-1 - 1 - 1 - 1" is not allowed.
 * You cannot concatenate numbers together
 * For example, if cards = [1, 2, 1, 2], the expression "12 + 12" is not valid.
 * Return true if you can get such expression that evaluates to 24, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: cards = [4,1,8,7]
 * Output: true
 * Explanation: (8-4) * (7-1) = 24
 * Example 2:
 *
 * Input: cards = [1,2,1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * cards.length == 4
 * 1 <= cards[i] <= 9
 */
public class LeetCode24Game {
    private static final double EPS = 0.000001;

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for(int x : cards) list.add( (double) x );
        return sol(list);
    }

    private boolean sol(List<Double> list){
        int n = list.size();
        if(n==1){
            // check for answer and return bool
            if (Math.abs(list.get(0) - 24) < EPS)   return true;
            return false;
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                double a = list.get(i);
                double b = list.get(j);

                List<Double> newList = new ArrayList<>();
                for(int k = 0; k<n; k++){
                    if(k==i || k==j) continue;
                    newList.add(list.get(k));
                }

                for(double x : candidates(a,b)){
                    newList.add(x);
                    if( sol(newList) )
                        return true;
                    newList.remove(newList.size()-1);
                }
            }
        }

        return false;
    }

    // Generate all possible results from combining a and b with + - * /
    private List<Double> candidates(double a, double b) {
        List<Double> res = new ArrayList<>(6);
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        if (Math.abs(b) > EPS) res.add(a / b);
        if (Math.abs(a) > EPS) res.add(b / a);
        return res;
    }
}