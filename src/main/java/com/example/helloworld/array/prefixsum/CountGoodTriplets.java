package com.example.helloworld.array.prefixsum;

/**
 * leetcode 1534. Count Good Triplets , Amazon, Apple
 *
 * code harmony video explanation : https://youtu.be/GxDe5uA_5es
 *
 * my leetcode solution : https://leetcode.com/problems/count-good-triplets/solutions/6649423/beginner-friendly-easy-brute-force-optim-w9zk
 *
 * Given an array of integers arr, and three integers a, b and c. You need to find the number of good triplets.
 *
 * A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:
 *
 * 0 <= i < j < k < arr.length
 * |arr[i] - arr[j]| <= a
 * |arr[j] - arr[k]| <= b
 * |arr[i] - arr[k]| <= c
 * Where |x| denotes the absolute value of x.
 *
 * Return the number of good triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
 * Output: 4
 * Explanation: There are 4 good triplets: [(3,0,1), (3,0,1), (3,1,1), (0,1,1)].
 * Example 2:
 *
 * Input: arr = [1,1,2,2,3], a = 0, b = 0, c = 1
 * Output: 0
 * Explanation: No triplet satisfies all conditions.
 *
 *
 * Constraints:
 *
 * 3 <= arr.length <= 100
 * 0 <= arr[i] <= 1000
 * 0 <= a, b, c <= 1000
 */
public class CountGoodTriplets {

        // Brute force approach: O(n^3) time complexity
        public int countGoodTripletsN3(int[] arr, int a, int b, int c) {
            int n = arr.length;
            int ans = 0;

            // Try every triplet (i, j, k) such that i < j < k
            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    for(int k = j + 1; k < n; k++) {
                        // Check the given conditions for good triplets
                        if(
                                Math.abs(arr[i] - arr[j]) <= a &&
                                        Math.abs(arr[j] - arr[k]) <= b &&
                                        Math.abs(arr[i] - arr[k]) <= c
                        ) {
                            ans++; // Valid triplet found
                        }
                    }
                }
            }

            return ans;
        }

        // Optimized approach: O(n^2) time complexity using prefix sums
        public int countGoodTriplets(int[] arr, int a, int b, int c) {
            int ans = 0, n = arr.length;
            int[] sum = new int[1001]; // Prefix sum array for values in range [0, 1000]

            for (int j = 0; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    // Check if |arr[j] - arr[k]| <= b
                    if (Math.abs(arr[j] - arr[k]) <= b) {

                        // Determine the range of possible arr[i] values such that:
                        // |arr[i] - arr[j]| <= a and |arr[i] - arr[k]| <= c

                        int lj = arr[j] - a, rj = arr[j] + a;
                        int lk = arr[k] - c, rk = arr[k] + c;

                        // Find the overlapping range that satisfies both conditions
                        int l = Math.max(0, Math.max(lj, lk));       // left bound
                        int r = Math.min(1000, Math.min(rj, rk));    // right bound

                        // If a valid range exists, add the count of such arr[i] values
                        if (l <= r) {
                            if (l == 0) {
                                ans += sum[r];
                            } else {
                                ans += sum[r] - sum[l - 1]; // range query using prefix sum
                            }
                        }
                    }
                }

                // Update prefix sum array for next iteration
                // Increment the count of arr[j] in the prefix sum array
                for (int k = arr[j]; k <= 1000; ++k) {
                    ++sum[k];
                }
            }

            return ans;
        }
    }
