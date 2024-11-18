package com.example.helloworld.array.slidingwindow.others;

/**
 * leetcode 1652. Defuse the Bomb
 * Code Harmony video explanation : https://youtu.be/jgABtiwPyjg
 *
 * You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code of length of n and a key k.
 *
 * To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.
 *
 * If k > 0, replace the ith number with the sum of the next k numbers.
 * If k < 0, replace the ith number with the sum of the previous k numbers.
 * If k == 0, replace the ith number with 0.
 * As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].
 *
 * Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!
 *
 *
 *
 * Example 1:
 *
 * Input: code = [5,7,1,4], k = 3
 * Output: [12,10,16,13]
 * Explanation: Each number is replaced by the sum of the next 3 numbers. The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.
 * Example 2:
 *
 * Input: code = [1,2,3,4], k = 0
 * Output: [0,0,0,0]
 * Explanation: When k is zero, the numbers are replaced by 0.
 * Example 3:
 *
 * Input: code = [2,4,9,3], k = -2
 * Output: [12,5,6,13]
 * Explanation: The decrypted code is [3+9, 2+3, 4+2, 9+4]. Notice that the numbers wrap around again. If k is negative, the sum is of the previous numbers.
 *
 *
 * Constraints:
 *
 * n == code.length
 * 1 <= n <= 100
 * 1 <= code[i] <= 100
 * -(n - 1) <= k <= n - 1
 */
public class DefusetheBomb {

    /**
     * Optimized method to decrypt the circular array using a sliding window.
     *
     * Time Complexity: O(n), as we use a sliding window approach and process the array in one pass.
     * Space Complexity: O(n), for the result array.
     *
     * @param code The input circular array.
     * @param k    The decryption key indicating the range of sums.
     * @return The decrypted array.
     */
    public int[] decrypt(int[] code, int k) {
        int n = code.length; // Length of the input array.
        int[] res = new int[n]; // Result array to store decrypted values.

        // If k is 0, replace every element with 0 and return.
        if (k == 0) return res;

        // Determine the initial range of the sliding window.
        int start = 1, end = k, sum = 0;
        if (k < 0) {
            // For negative k, calculate the range of previous `|k|` elements.
            start = n - Math.abs(k); // Start index of the window.
            end = n - 1;            // End index of the window.
        }

        // Calculate the initial sum of the first window.
        for (int i = start; i <= end; i++) {
            sum += code[i % n];
        }

        // Slide the window across the array.
        for (int i = 0; i < n; i++) {
            res[i] = sum; // Assign the current sum to the result array.

            // Adjust the sliding window:
            // Subtract the element that is sliding out of the window.
            sum -= code[start % n];
            // Add the element that is sliding into the window.
            sum += code[(end + 1) % n];

            // Move the start and end pointers of the window.
            start++;
            end++;
        }

        return res;
    }

    /**
     * Brute force approach to decrypt the circular array.
     *
     * Time Complexity: O(n * |k|), as we loop through the array and compute sums explicitly for each index.
     * Space Complexity: O(n), for the result array.
     *
     * @param code The input circular array.
     * @param k    The decryption key indicating the range of sums.
     * @return The decrypted array.
     */
    public int[] decryptBruteForce(int[] code, int k) {
        int n = code.length; // Length of the input array.
        int[] res = new int[n]; // Result array to store decrypted values.

        // If k is 0, replace every element with 0 and return.
        if (k == 0) return res;

        // Loop through each element in the array.
        for (int i = 0; i < n; i++) {
            if (k > 0) {
                // For positive k, sum the next k elements (circularly).
                for (int j = i + 1; j < i + 1 + k; j++) {
                    res[i] += code[j % n]; // Use modulo to handle circular indexing.
                }
            } else {
                // For negative k, sum the previous |k| elements (circularly).
                for (int j = i - Math.abs(k); j < i; j++) {
                    res[i] += code[(j + n) % n]; // Use modulo to handle negative indices.
                }
            }
        }

        return res;
    }
}
