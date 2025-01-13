package com.example.helloworld.interviews.sahil.pluang;

//First quesiton is trapping rain water .


//second questions is :

/*

Given an array of non-negative integers arr, you are initially positioned at a given starting index start in the array. When you are at index i, you can jump to either i + arr[i] or i - arr[i], provided these destinations are within the bounds of the array.
Your task is to determine if you can reach any index with a value of 0.
Return True if you can reach any index with value 0; otherwise, return False.

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation:
All possible ways to reach at index 3 with value 0 are:
index 5 -> index 4 -> index 1 -> index 3
index 5 -> index 6 -> index 4 -> [ index 1 -> index 3  ]

P

SP1 SP2

recursion.

[4,2,3,0,1,1,2]

idx 4 -> idx 5 -> idx 4

arr;

cache<integer, boolean> cache;

boolean sol(start, Set of integers){
		// coming to already visited value
    	return false;
		// if visited 0
    	return true;

    if(cache.containsKey(start)){
    	return cache.get(start);
    }
    // starting processing

    boolean res = false;

    int idx = start + arr[start];
    if(idx < n){
    	set.add(idx);
    	res |= sol(idx, set);
      set.remove(idx);
    }

    idx = start - arr[start];
    if(idx >= 0){
    	set.add(idx);
    	res |= sol(idx, set);
      set.remove(idx);
    }

    // saving state
    cache.put(start, res);
    return res;
}

 */


public class SDERound1 {

}
