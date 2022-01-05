package com.example.helloworld.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 131. Palindrome Partitioning
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 */
public class PalindromePartitioning {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        sol(s, new ArrayList<>());
        return res;
    }

    private void sol(String s, List<String> asf){
        if(s.length()==0)
            res.add(new ArrayList<>(asf));

        for(int i=0; i<s.length(); ++i){
            String prefix = s.substring(0,i+1);
            String suffix = s.substring(i+1);

            if(isPalindrome(prefix)){
                asf.add(prefix);
                sol(suffix, asf);
                asf.remove(asf.size()-1);
            }
        }
    }

    /**
     * function to check whether a given string is palindrome.
     * @param s input string to be checked.
     * @return
     */
    public boolean isPalindrome(String s){
        int l = 0, r = s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
