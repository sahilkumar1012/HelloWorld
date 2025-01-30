package com.example.helloworld.interviews.sahil.amex;

import java.util.HashMap;
import java.util.Map;

public class AMEXRound2 {
    // p1 - find first occurrence , vanilla binary search
    // p2 - largest zero-one-distance array , Hash Table

}



/**
 * Problem 1
 *
 Given a sorted array of only 0s and 1s, you need to find the occurrence of the first 1 in the array.

 Eg.
 A = [,]
 Return: 2
 A = [0,0,0,0]
 Return: -1
 */

/**
 problem 2 :

 Given an array A, return the length of the longest zero-one-distance array created using the elements of A. Zero-one-distance array is an array where, the difference between (i+1)th & ith element is either 0 or 1.
 Eg:
 A = [2,2,8,4,5,3,9,12,11]
 a1 = [2,3,4,5]
 a2 = [8,9]
 a3 = [11,12]
 Ans: 4

 frequency map :  [2]-2, [8]-1, [4]-1, [5]-1, [3]-1, [9]-1, [12]-1, [11]-1
 //      boolean visited :  [2,8,4,5,3,9,12,11] ( can be skipped)

 gs = [2+1+1+1], 5
 gs = [1+1] , 2
 gs = [1+1] , 2

 max = 5
 return max group size. 4

 1. capture frequencies - O(N)
 2. visited(make freq 0), assign groups. O(N)
 3. return max size group - O(N)

 Time - O(N) , Space - O(N)
 // representative - min of that set.

 Constraint: |A| <= 10^5; -10^9 < elements < 10^9


 [2,8,4,5,3,9,12,11]
 max = 4
 ans = 2
 [2,3,4,5,8,9,11,12]

 1. sorting. (N Log N)
 2. iteration O(N)  , ans , [max]
 */
class Solution{

    // T - O(logN) , S - O(1)
    public int firsto(int[] arr){
        int ans = -1;

        int l = 0;
        int r = arr.length-1;

        while(l <= r){
            int mid = l + (r-l)/2;

            if(arr[mid] == 1){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return ans;
    }

    // T- O(N) , S- O(N)
    public int zeroonearray(int[] arr){
        // 1. capture freq.
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr)
            map.put(i, map.getOrDefault(i,0)+1);

        int max = 0;
        for(int i : arr){
            if(map.get(i) == 0) // already processed , skip it
                continue;

            // assign group, capture group size
            int size = map.get(i);      // current group
            map.put(i,0);       // visited

            int val = i-1;
            while(map.containsKey(val) && map.get(val)>0){
                size += map.get(val);
                map.put(val,0);
                val--;
            }
            val = i+1;
            while(map.containsKey(val) && map.get(val)>0){
                size += map.get(val);
                map.put(val,0);
                val++;
            }

            max = Math.max(max, size);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution o = new Solution();

//        int[] arr = {0,0,1,1,1,1}; // 2
//        System.out.println(o.firsto(arr));
//
//        int[] arr2 = {0,0,0,0,0,1}; // -1 , 5
//        System.out.println(o.firsto(arr2));
//
//        int[] arr3 = {1,1,1,1,1}; // 0
//        System.out.println(o.firsto(arr3));

        int[] arr4 = {2,2,8,4,5,3,9,12,11};
        System.out.println(o.zeroonearray(arr4));

        int[] arr5 = {2,8,4,5,3,9,12,11};
        System.out.println(o.zeroonearray(arr5));

        int[] arr6 = {6,2,8,4,5,3,9,12,11};
        System.out.println(o.zeroonearray(arr6));
    }
}

