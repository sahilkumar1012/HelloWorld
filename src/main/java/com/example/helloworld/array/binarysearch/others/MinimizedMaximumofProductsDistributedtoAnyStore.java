package com.example.helloworld.array.binarysearch.others;

/**
 * Leetcode 2064. Minimized Maximum of Products Distributed to Any Store
 * Code Harmony Video Explanation : https://youtu.be/ftdM2w-JqoE
 *
 * Problem:
 * You are given an integer `n` representing the number of retail stores and an array `quantities` where each element
 * represents the number of products of a particular type. You need to distribute all products across the retail stores
 * while minimizing the maximum number of products assigned to any store.
 *
 * Constraints:
 * - A store can only receive products of one type.
 * - Each store may receive any amount of that product type, but you want to minimize the maximum number of products assigned to any store.
 *
 * Goal:
 * Return the minimum possible maximum number of products any store could have.
 *
 * Approach:
 * - Use binary search to find the minimal maximum number (`x`) that satisfies the distribution condition.
 * - For each mid-point in the binary search, check if it's feasible to distribute all products such that no store has
 *   more than `mid` products.
 *
 * Example:
 * Input: n = 7, quantities = [15,10,10]
 * Output: 5
 *
 * Explanation:
 * Distribute 15 products of type 0 to three stores with 5 each, 10 products of type 1 to two stores with 5 each, and
 * 10 products of type 2 to two stores with 5 each.
 */
public class MinimizedMaximumofProductsDistributedtoAnyStore {

    int[] q; // Array representing quantities of each product type

    /**
     * Method to calculate the minimized maximum number of products distributed to any store.
     *
     * @param n          Number of stores
     * @param quantities Array of product quantities
     * @return Minimum possible value of the maximum number of products in any store after distribution
     */
    public int minimizedMaximum(int n, int[] quantities) {
        q = quantities;
        int ans = 0;

        // Define binary search bounds: left (smallest possible value for maximum) and right (largest possible value for maximum)
        int left = 1, right = 100000;

        // Perform binary search to find the minimized maximum number of products per store
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate mid-point to check

            // Check if it's valid to distribute products such that no store has more than `mid` products
            if (valid(mid, n)) {
                ans = mid; // Update answer if this mid is valid
                right = mid - 1; // Try to minimize further by moving the upper bound left
            } else {
                left = mid + 1; // Increase the lower bound if `mid` is too small to be feasible
            }
        }
        return ans;
    }

    /**
     * Helper function to check if it's possible to distribute products with a maximum of `x` per store.
     *
     * @param x Maximum allowed number of products per store
     * @param n Total number of stores
     * @return True if distribution is feasible with `x` products per store; otherwise, False
     */
    private boolean valid(int x, int n) {
        int requiredStores = 0; // Counter for the total number of stores required

        // Iterate over each product type in quantities array
        for (int quantity : q) {
            // Calculate the number of stores needed for the current product type if each store can hold up to `x` products
            requiredStores += (quantity + x - 1) / x; // Equivalent to Math.ceil(quantity / x)

            // Early exit if the required stores exceed available stores `n`
            if (requiredStores > n) {
                return false;
            }
        }

        // Return true if the total required stores fit within the available stores `n`
        return requiredStores <= n;
    }
}
