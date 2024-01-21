package com.example.helloworld.stack;

import java.util.Stack;

/**
 * leetcode 907. Sum of Subarray Minimums
 *
 *
 * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [3,1,2,4]
 * Output: 17
 * Explanation:
 * Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
 * Sum is 17.
 * Example 2:
 *
 * Input: arr = [11,81,94,43,3]
 * Output: 444
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 3 * 104
 * 1 <= arr[i] <= 3 * 104
 */
public class SumofSubarrayMinimums {

    /**
     * N^2 approach.
     * @param arr
     * @return
     */
    public int sumSubarrayMinsN2(int[] arr) {
        int n = arr.length;
        int sum = 0;

        for(int i=0; i<n; i++){     // all subarrays starting i=0;
            int min = arr[i];

            for(int j = i; j< n; j++){
                if(arr[j] < min)
                    min = arr[j];
                // min updated till i to j
                sum += min;     // add current min for this subarray
                sum %= 1000000007;
            }
        }

        return sum;
    }

    /**
     * O(N) time solution , O(N) Space using Monotonic Stack
     * @param arr
     * @return
     */
    public int sumOfMinSubarrays(int[] arr) {
        int n = arr.length;
        long result = 0;
        int MOD = 1000000007;

        // Stack to maintain the indices of elements in a monotonically increasing order.
        Stack<Integer> stack = new Stack<>();

        // Arrays to store the left and right boundaries of the minimum element for each index.
        int[] left = new int[n];
        int[] right = new int[n];

        // Calculate the left boundaries for each element.
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear the stack for reusing it to calculate the right boundaries.
        stack.clear();

        // Calculate the right boundaries for each element.
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate the contribution of each element to the final result.
        for (int i = 0; i < n; i++) {
            result = (result + (long) arr[i] * (i - left[i]) * (right[i] - i)) % MOD;
        }

        // Return the result after taking modulo.
        return (int) result;
    }


    // write main to test this above function


}
