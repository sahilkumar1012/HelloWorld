package com.example.helloworld.backtracking.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 1980. Find Unique Binary String
 * https://leetcode.com/problems/find-unique-binary-string/
 *
 * Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length
 * n that does not appear in nums. If there are multiple answers, you may return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = ["01","10"]
 * Output: "11"
 * Explanation: "11" does not appear in nums. "00" would also be correct.
 * Example 2:
 *
 * Input: nums = ["00","01"]
 * Output: "11"
 * Explanation: "11" does not appear in nums. "10" would also be correct.
 * Example 3:
 *
 * Input: nums = ["111","011","001"]
 * Output: "101"
 * Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 16
 * nums[i].length == n
 * nums[i] is either '0' or '1'.
 * All the strings of nums are unique.
 */
public class FindUniqueBinaryString {
    Set<String> set;
    int n ;

    public String findDifferentBinaryString(String[] nums) {
        n = nums.length;
        set = new HashSet<>();
        for(String s : nums)
            set.add(s);

        return sol(0,"");
    }

    private String sol(int idx, String temp){
        if(temp.length() == n){
            if(set.contains(temp) == false)
                return temp;
        }

        if(idx < n){
            String left = sol(idx+1, temp + '0');
            if( left != null) return left;

            String right = sol(idx+1, temp + '1');
            if(right != null) return right;
        }

        return null;
    }
}
