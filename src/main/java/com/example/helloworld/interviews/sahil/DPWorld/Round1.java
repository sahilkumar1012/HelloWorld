package com.example.helloworld.interviews.sahil.DPWorld;

import java.util.ArrayList;
import java.util.List;

public class Round1 {
    // coding questions below
}

/**
 [2:04 pm] Kanwar Deep Mohil
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.Example:
 Input: n = 3
 Output: ["((()))","(()())","(())()","()(())","()()()"]Input: n = 1
 Output: ["()"]


 */
class Question1 {
    public List<String> generateParenthesis(int n){
        List<String> res = new ArrayList<>();
        helper(n, 0, 0, "", res);
        return res;
    }

    private void helper(int n, int open, int close, String s, List<String> res) {
        if(open == n && close == n){
            res.add(s); return;
        }
        if(open < n)
            helper(n, open+1, close, s+"(", res);
        if(close < open)
            helper(n, open, close + 1, s + ")" , res);
    }

    public static void main(String[] args) {
        Question1 test = new Question1();
        System.out.println(test.generateParenthesis(3));
        System.out.println(test.generateParenthesis(4));
    }
}


/**
 Given an integer array nums, return the length of the longest strictly increasing subsequence.
 A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [03,6,7],[0,1,2,7] is a subsequence of the array [0,3,1,6,2,2,7].



 Example:



 Input: nums = [10,9,2,5,3,7,101,18]
 Output: 4
 Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.




 Input: nums = [0,1,0,3,2,3]
 Output: 4



 Input: nums = [7,7,7,7,7,7,7]
 Output: 1
 */
class Question2{
    public static int lengthOfLIS(int[] arr){
        int n = arr.length;
        int dp[] = new int[n];
        int max = 0;

        for(int i=0; i<n; i++){
            int tmax = 0;
            for(int j=i-1; j>=0; j--){
                if(arr[j] < arr[i]){
                    if(tmax < dp[j]){
                        tmax = dp[j];
                    }
                }
            }
            dp[i] = 1 + tmax;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));

        arr = new int[]{0,1,0,3,2,3};
        System.out.println(lengthOfLIS(arr));

        arr = new int[]{7,7,7,7,7,7,7};
        System.out.println(lengthOfLIS(arr));
    }
}



