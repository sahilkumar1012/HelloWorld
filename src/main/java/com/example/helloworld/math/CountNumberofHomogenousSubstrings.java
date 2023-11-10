package com.example.helloworld.math;

/**
 * leetcode 1759. Count Number of Homogenous Substrings
 * reference video link : https://youtu.be/392JZwTeqEA
 *
 * Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 109 + 7.
 *
 * A string is homogenous if all the characters of the string are the same.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abbcccaa"
 * Output: 13
 * Explanation: The homogenous substrings are listed as below:
 * "a"   appears 3 times.
 * "aa"  appears 1 time.
 * "b"   appears 2 times.
 * "bb"  appears 1 time.
 * "c"   appears 3 times.
 * "cc"  appears 2 times.
 * "ccc" appears 1 time.
 * 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.
 * Example 2:
 *
 * Input: s = "xy"
 * Output: 2
 * Explanation: The homogenous substrings are "x" and "y".
 * Example 3:
 *
 * Input: s = "zzzzz"
 * Output: 15
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase letters.
 */
public class CountNumberofHomogenousSubstrings {
    public int countHomogenous(String s) {

        int len = 1;
        char ch = s.charAt(0);
        int ans = 1;
        int m = (int) 1e9 + 7;

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == ch){
                len ++;
            }else{
                ch = s.charAt(i);
                len = 1;
            }

            ans = (ans+len)%m;
        }

        return ans%m;
    }

    // write main method to test above function
    public static void main(String[] args) {
        CountNumberofHomogenousSubstrings cnhs = new CountNumberofHomogenousSubstrings();
        System.out.println(cnhs.countHomogenous("abbcccaa"));
        System.out.println(cnhs.countHomogenous("xy"));
        System.out.println(cnhs.countHomogenous("zzzzz"));
        System.out.println(cnhs.countHomogenous("aabaa"));
        System.out.println(cnhs.countHomogenous("aabaaa"));
        System.out.println(cnhs.countHomogenous("aabaaabaaa"));
        System.out.println(cnhs.countHomogenous("aabaaabaaabaaa"));
        System.out.println(cnhs.countHomogenous("aabaaabaaabaaabaaa"));
        System.out.println(cnhs.countHomogenous("aabaaabaaabaaabaaabaaa"));
        System.out.println(cnhs.countHomogenous("aabaaabaaabaaabaaabaaabaaa"));
    }
}
