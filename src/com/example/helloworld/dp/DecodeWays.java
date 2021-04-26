package com.example.helloworld.dp;

import java.util.HashMap;
import java.util.Map;
/**
 * leetcode 91. Decode Ways
 *
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 *
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 *
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 *
 * Given a string s containing only digits, return the number of ways to decode it.
 *
 * The answer is guaranteed to fit in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * Example 3:
 *
 * Input: s = "0"
 * Output: 0
 * Explanation: There is no character that is mapped to a number starting with 0.
 * The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
 * Hence, there are no valid ways to decode this since all digits need to be mapped.
 * Example 4:
 *
 * Input: s = "06"
 * Output: 0
 * Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s contains only digits and may contain leading zero(s).
 */
public class DecodeWays {
    int res;
    Map<Integer,Integer> map ;

    public int numDecodingssk(String s){
        res = 0;
        map = new HashMap<>();

        if(s.charAt(0)=='0')
            return 0;
        return sol(s,0);
        // return res;
    }

    // recurssion with memorization
    private int sol(String s, int idx){
        if(idx==s.length()){
            res++;
            return 1;
        }
        int sum = 0;
        if(map.get(idx)!=null){
            return map.get(idx);
        }

        if(s.charAt(idx) >= '1' && s.charAt(idx) <= '9'){
            sum += sol(s,idx+1);
        }
        if(idx < s.length()-1){
            int val = Integer.parseInt(s.substring(idx,idx+2));
            // System.out.println(val);
            if(val>=10 && val<=26){
                sum += sol(s,idx+2);
            }
        }

        map.put(idx,sum);
        return sum;
    }

    /*
    Nice easy dp solution.
     */
    public int numDecodings(String s) {
        int n = s.length();
        if(n==0 || s.charAt(0)=='0') return 0;  // corner case, starting mai zero ko can't decode.

        int dp[] = new int[n+1]; // initialized with 0
        dp[0] = 1; // dummy.
        dp[1] = 1;

        for(int i=2; i<=n; ++i){
            if(s.charAt(i-1)>='1' && s.charAt(i-1)<='9'){
                dp[i] += dp[i-1];
            }
            int temp = Integer.parseInt(s.substring(i-2,i));
            if(temp>=10 && temp<=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
