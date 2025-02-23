package com.example.helloworld.backtracking;

/**
 * leetcode 1718. Construct the Lexicographically Largest Valid Sequence
 * https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/
 *
 * code harmony video explanation : https://youtu.be/UcKuSSrE33k
 *
 * my leetcode solution :
 *
 */
public class ConstructtheLexicographicallyLargestValidSequence {

    public int[] constructDistancedSequence(int n) {
        // Create an array to store the final sequence, size is 2*n-1
        int[] result = new int[2*n-1];
        // Boolean array to track whether a number is used
        boolean[] used = new boolean[n+1];
        // Start backtracking from index 0
        sol(0, result, used, n);
        return result;
    }

    private boolean sol(int idx, int[] result, boolean[] used, int n){
        // Base case: if we reach the end of the array, return true
        if(idx == result.length) return true;

        // If the current index is already filled, move to the next index
        if(result[idx] != 0) return sol(idx+1, result, used, n);

        // Try placing numbers from n down to 1
        for(int num = n; num >=1; num--){
            // Skip if the number is already used
            if(used[num]) continue;

            // Mark the number as used and place it at the current index
            used[num] = true;
            result[idx] = num;

            if(num == 1){ // If the number is 1, it only occupies one position
                if(sol(idx+1, result, used, n))
                    return true;
            } else if(idx+num < result.length && result[idx+num] == 0){
                // If the number is greater than 1, place it at (idx+num) as well
                result[idx+num] = num;

                // Recursively try to fill the next index
                if(sol(idx+1, result, used, n)){
                    return true;
                }

                // Backtrack: Reset the second occurrence of num
                result[idx+num] = 0;
            }

            // Backtrack: Reset the current index and mark the number as unused
            result[idx] = 0;
            used[num] = false;
        }

        // If no valid placement is found, return false
        return false;
    }
}
