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

    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;

        Stack<Integer> stack = new Stack<>();
        long sumOfMinimums = 0;

        // building monotonically increasing stack
        for (int i = 0; i <= arr.length; i++) {

            // when i reaches the array length, it is an indication that
            // all the elements have been processed, and the remaining
            // elements in the stack should now be popped out.

            while (!stack.empty() && (i == arr.length || arr[stack.peek()] >= arr[i])) {

                // Notice the sign ">=", This ensures that no contribution
                // is counted twice. rightBoundary takes equal or smaller 
                // elements into account while leftBoundary takes only the
                // strictly smaller elements into account

                int mid = stack.pop();
                int leftBoundary = stack.empty() ? -1 : stack.peek();
                int rightBoundary = i;

                // count of subarrays where mid is the minimum element
                long count = (mid - leftBoundary) * (rightBoundary - mid) % MOD;

                sumOfMinimums += (count * arr[mid]) % MOD;
                sumOfMinimums %= MOD;
            }
            stack.push(i);
        }

        return (int) (sumOfMinimums);
    }


    // write main to test this above function


}
