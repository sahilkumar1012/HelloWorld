package com.example.helloworld.bitmanipulation;

import java.util.Arrays;

/**
 * leetcode 201. Bitwise AND of Numbers Range
 *
 * Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.
 *
 *
 *
 * Example 1:
 *
 * Input: left = 5, right = 7
 * Output: 4
 * Example 2:
 *
 * Input: left = 0, right = 0
 * Output: 0
 * Example 3:
 *
 * Input: left = 1, right = 2147483647
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= left <= right <= 231 - 1
 */
public class BitwiseAndOfNumberRange{

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5
                ,7));;
        //700000000
        //2147483641
    }

    public static int rangeBitwiseAnd(int left, int right) {
        if(left==right)
            return left;

        int n = right-left;
        int po2=0;
        while(n!=0){
            n>>=1;
            po2++;
        }

        // Dhoor paindi algo by Kaka
        left >>= po2;
        left <<= po2;
        right >>= po2;
        right <<= po2;

        return (left & right);
    }


}

/*
c++ code

class Solution {
    public:
    int rangeBitwiseAnd(int m, int n) {

        int count=0;

        while(m!=n)
        {
            m=m>>1;
            n=n>>1;
            count++;
        }
        return m<<count;
    }
};


 */