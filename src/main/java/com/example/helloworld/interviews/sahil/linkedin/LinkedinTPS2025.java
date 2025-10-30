package com.example.helloworld.interviews.sahil.linkedin;

import java.util.List;

public class LinkedinTPS2025 {
}


/* Implement a function which, given a number, will return "true" if that number
 * has an integer square root and "false" otherwise
 * 49 -> "true", since sqrt(49) = 7 is an integer
 * 50 -> "false", since sqrt(50) = 7.071... is not an integer
 */
class Solution{
    public boolean hasIntegerSquareRoot(long n) {
        // implementation here
        // for(int i=1; i*i <= n; i++){
        //   if(i*i == n) return true;
        // }
        // return false;

        long l = 1, r = n;
        while(l <= r){
            long m = (l+r)/2;

            if(m * m == n){
                return true;
            }else if(m * m < n){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return false;
    }
}

// 1 .... n
// mid*mid == n
// log(N) better than sqrt(N)




/**
 * /**
 * Given a nested list of integers, returns the sum of all integers in the list weighted by their reversed level #.
 * For example, given the list {{1,1},2,{1,1}} the deepest level is 2. Thus the function should return 8 (four 1's with weight 1, one 2 with weight 2)
 * Given the list {1,{4,{6,2}}} the function should return 19 (1 with weight 3, 4 with weight 2, 6 with weight 1, 2 with weight 1)
 *      / 2 \
 * {1,1}       {1,1}
 *
 *
 * It is the "reverse depth" of the item in the list: eg for the above item { 1, {4, { 6, 2 }, 3 }, {0, {5, {14}}} }
 *
 *  1 (reverse-depth 3) . = 1 * 3 = 3 4
 *   \
 *   { 4 } (reverse-depth 2) = 4 * 2 = 8 {3}.   {0} 3
 *      \
 *      { 6, 2 } (reverse-depth 1) = 6 * 1 + 2 * 1 = 8 {5} 2

 *                                  = 3 + 8 + 8 = 19.   {14} 1
 */


// depth = d
// d-level

class Solution2{
    private int depth = 0;
    private int ans = 0;

    private void depth(List<NestedInteger> input, int cdepth){

        for(NestedInteger ni : input){
            if(ni.isInteger()){
                depth = Math.max(cdepth, depth);

            } else
                depth(ni,cdepth+1);
        }

    }

    private void sol(List<NestedInteger> input, int lvl){
        for(NestedInteger ni : input){
            if(ni.isInteger()){
                int val = ni.getInteger();
                ans += val * (depth - lvl) ;
            } else
                sol(ni,lvl+1);
        }
    }

    public int reverseDepthSum (List<NestedInteger> input)
    {
        // implementation here
        // 1. calculate nested depth     O(N)       - depth capture.
        // 2. recursively move and calculate the sum
        // 3. sum. -> level integers * (depth- level number)
        depth(input, 0);
        sol(input,0);
        return ans;
    }

}
// t - O(N)
// s - O(1)


// 3x + 2y + z = 4(x + y + z) - (x + 2y + 3z)

//
//one pass to cal - sum of every level. O(H) in space
//
//depth.
//
//O(N) time O(H) space.

/**
 * This is the interface that represents nested lists.
 * You should not implement it, or speculate about its implementation.
 */
// public
interface NestedInteger
{
    /** @return true if this NestedInteger holds a single integer, rather than a nested list */
    boolean isInteger();

    /** @return the single integer that this NestedInteger holds, if it holds a single integer
     * Return null if this NestedInteger holds a nested list */
    Integer getInteger();

    /** @return the nested list that this NestedInteger holds, if it holds a nested list
     * Return null if this NestedInteger holds a single integer */
    List<NestedInteger> getList();
}
