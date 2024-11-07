package com.example.helloworld.bitmanipulation;

/**
 * leetcode 2275. Largest Combination With Bitwise AND Greater Than Zero
 *
 * Code Harmony Video : https://youtu.be/9baH9F8Jobw
 *
 * The bitwise AND of an array nums is the bitwise AND of all integers in nums.
 *
 * For example, for nums = [1, 5, 3], the bitwise AND is equal to 1 & 5 & 3 = 1.
 * Also, for nums = [7], the bitwise AND is 7.
 * You are given an array of positive integers candidates. Evaluate the bitwise AND of every combination of numbers of candidates. Each number in candidates may only be used once in each combination.
 *
 * Return the size of the largest combination of candidates with a bitwise AND greater than 0.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [16,17,71,62,12,24,14]
 * Output: 4
 * Explanation: The combination [16,17,62,24] has a bitwise AND of 16 & 17 & 62 & 24 = 16 > 0.
 * The size of the combination is 4.
 * It can be shown that no combination with a size greater than 4 has a bitwise AND greater than 0.
 * Note that more than one combination may have the largest size.
 * For example, the combination [62,12,24,14] has a bitwise AND of 62 & 12 & 24 & 14 = 8 > 0.
 * Example 2:
 *
 * Input: candidates = [8,8]
 * Output: 2
 * Explanation: The largest combination [8,8] has a bitwise AND of 8 & 8 = 8 > 0.
 * The size of the combination is 2, so we return 2.
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 105
 * 1 <= candidates[i] <= 107
 */
public class LargestCombinationWithBitwiseANDGreaterThanZero {
    public int largestCombination(int[] candidates) {

        // Array to count how many numbers have each bit set (1).
        // Since integers are up to 32-bits, we need an array of size 32.
        int[] arr = new int[32];

        // Iterate through each candidate number in the input array
        for(int n : candidates){
            int i = 0; // Bit position index, starting from the least significant bit (LSB)

            // Check each bit of the number by shifting it right until all bits are processed
            while(n > 0){
                // If the least significant bit (LSB) of n is 1, increment the count at position i
                if( (n & 1) == 1 ){
                    arr[i] += 1;
                }
                n >>= 1; // Right shift n by 1 to check the next bit
                i++; // Move to the next bit position
            }
        }

        // Initialize the variable to store the maximum count of 1s in any bit position
        int ans = 0;

        // Find the highest value in the arr array, which represents the maximum subset size
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > ans) ans = arr[i];
        }

        // Return the maximum subset size found
        return ans;
    }
}
