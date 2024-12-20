package com.example.helloworld.greedy;

/**
 * leetcode 769. Max Chunks To Make Sorted  , monotonic stack, greedy, Asked in Google , Microsoft
 *
 * code harmony video explanation : https://youtu.be/kbkBpk1le4g
 *
 * my leetcode solution : https://leetcode.com/problems/max-chunks-to-make-sorted/solutions/6162388/100-faster-easy-to-understand-java-c-pyt-jmhy
 *
 * You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].
 *
 * We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.
 *
 * Return the largest number of chunks we can make to sort the array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [4,3,2,1,0]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
 * Example 2:
 *
 * Input: arr = [1,0,2,3,4]
 * Output: 4
 * Explanation:
 * We can split into two chunks, such as [1, 0], [2, 3, 4].
 * However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
 *
 *
 * Constraints:
 *
 * n == arr.length
 * 1 <= n <= 10
 * 0 <= arr[i] < n
 * All the elements of arr are unique.
 */
public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        // Initialize 'msf' (maximum so far) to track the maximum value encountered in the array so far
        // Initialize 'chunks' to count the number of chunks that can be formed
        int msf = -1;
        int chunks = 0;

        // Iterate through the array
        for(int i = 0; i < arr.length; i++) {
            // Update 'msf' to the maximum of the current element and the previous maximum
            msf = Math.max(msf, arr[i]);

            // If 'msf' equals the current index, it means we can form a chunk
            if(msf == i) {
                chunks++; // Increment the chunk count
            }
        }

        // Return the total number of chunks
        return chunks;
    }
}

