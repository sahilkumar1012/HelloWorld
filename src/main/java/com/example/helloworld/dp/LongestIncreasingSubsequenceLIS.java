package com.example.helloworld.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * leetcode 300. Longest Increasing Subsequence
 *
 * Code Harmony solution video : https://youtu.be/E17tsQZJUTg
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up:
 *
 * Could you come up with the O(n2) solution?
 * Could you improve it to O(n log(n)) time complexity?
 */
public class LongestIncreasingSubsequenceLIS {

    /**
     * Using Array!!
     * Patience Sort Approach:
     * The length of the Longest Increasing Subsequence (LIS) is equal to the number of piles created in the patience sort.
     *
     * @param nums Input array of integers
     * @return Length of the longest increasing subsequence
     */
    // O(nlog(n)) time complexity with linear space.
    public int lengthOfLISd(int[] nums) {
        int n = nums.length;
        int numPiles = 0;  // Tracks the number of piles created.
        int piles[] = new int[n];  // Array to store the top element of each pile.

        for (int num : nums) {
            int destPile = Arrays.binarySearch(piles, 0, numPiles, num); // Using binary search to find the pile where the current number should be placed.
            if (destPile < 0) {
                destPile = -(destPile + 1);  // Adjusting the index as binary search returns a negative value when the element is not found.
            }
            piles[destPile] = num;  // Place the number in its correct pile.
            if (destPile == numPiles) {  // If a new pile was created.
                numPiles++;
            }
        }
        return numPiles;  // Return the number of piles, which is the length of the LIS.
    }

    /**
     * patience sort using ArrayList !!
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        List<Integer> piles = new ArrayList<>();

        for (int num : nums) {
            int ip = Collections.binarySearch(piles, num);

            if (ip < 0) {
                ip = -(ip + 1);

                if (ip == piles.size()) {
                    piles.add(num);
                } else {
                    piles.set(ip, num);
                }

            }
        }

        return piles.size();
    }


    /**
     * Dynamic Programming Approach:
     * Using Dynamic Programming to solve the Longest Increasing Subsequence problem.
     *
     * @param nums Input array of integers
     * @return Length of the longest increasing subsequence
     */
    // O(n^2) time complexity with linear space.
    public int lengthOfLISdp(int[] nums) {
        final int n = nums.length;
        int dp[] = new int[n];  // Array to store the length of LIS ending at each index.
        int omax = 0;  // Overall maximum length of LIS.

        for (int i = 0; i < n; i++) {
            int max = 0;  // Initialize the maximum length so far for the current index.
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {  // If the previous element is smaller than the current element.
                    if (max < dp[j]) {
                        max = dp[j];  // Update the maximum length ending at index i.
                    }
                }
            }
            dp[i] = max + 1;  // Length of LIS ending at index i is max + 1.
            if (omax < dp[i]) {
                omax = dp[i];  // Update the overall maximum length of LIS.
            }
        }
        return omax;  // Return the overall maximum length of LIS.
    }
}


