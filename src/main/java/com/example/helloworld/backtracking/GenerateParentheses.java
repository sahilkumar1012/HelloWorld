package com.example.helloworld.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * leetcode 22. Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 */
public class GenerateParentheses {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();

        sol(n,0,0,"");
        return res;
    }

    private void sol(int n,int open, int close, String s ){
        if(s.length() == 2*n)
            res.add(s);

        if(open<n)
            sol( n, open+1, close, s+"(" );
        if(open>close)
            sol( n, open, close+1, s+")" );
    }
}