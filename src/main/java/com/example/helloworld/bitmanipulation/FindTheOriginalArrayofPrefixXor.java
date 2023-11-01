package com.example.helloworld.bitmanipulation;

/**
 * leetcode 2433. Find The Original Array of Prefix Xor
 * reference solution : https://youtu.be/TDjmp768H3Q
 *
 *
 * You are given an integer array pref of size n. Find and return the array arr of size n that satisfies:
 *
 * pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
 * Note that ^ denotes the bitwise-xor operation.
 *
 * It can be proven that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: pref = [5,2,0,3,1]
 * Output: [5,7,2,3,2]
 * Explanation: From the array [5,7,2,3,2] we have the following:
 * - pref[0] = 5.
 * - pref[1] = 5 ^ 7 = 2.
 * - pref[2] = 5 ^ 7 ^ 2 = 0.
 * - pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3.
 * - pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1.
 * Example 2:
 *
 * Input: pref = [13]
 * Output: [13]
 * Explanation: We have pref[0] = arr[0] = 13.
 *
 *
 * Constraints:
 *
 * 1 <= pref.length <= 105
 * 0 <= pref[i] <= 106
 */
public class FindTheOriginalArrayofPrefixXor {

    public int[] findArray(int[] pref) {
        int[] arr = new int[pref.length];
        arr[0] = pref[0];

        for(int i=pref.length-1; i>0; i--){
            arr[i] = pref[i] ^ pref[i-1];
        }

        return arr;
    }

    public static void main(String[] args) {
        FindTheOriginalArrayofPrefixXor obj = new FindTheOriginalArrayofPrefixXor();
        int[] pref = {5,2,0,3,1};
        int[] arr = obj.findArray(pref);
        for(int i: arr)
            System.out.print(i + " ");
        System.out.println();

        pref = new int[]{13};
        arr = obj.findArray(pref);
        for(int i: arr)
            System.out.print(i + " ");
        System.out.println();

        pref = new int[]{5,2,0,3,1};
        arr = obj.findArray(pref);
        for(int i: arr)
            System.out.print(i + " ");
        System.out.println();

        pref = new int[]{5,7,2,3,2};
        arr = obj.findArray(pref);
        for(int i: arr)
            System.out.print(i + " ");
        System.out.println();
    }
}
