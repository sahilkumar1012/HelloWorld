package com.example.helloworld.array.binarysearch;

import java.util.Arrays;

/**
 * LeetCode 2070. Most Beautiful Item for Each Query
 *
 * You are given a 2D integer array items where items[i] = [pricei, beautyi] denotes the price and beauty of an item respectively.
 *
 * You are also given a 0-indexed integer array queries. For each queries[j], you want to determine the maximum beauty of an item
 * whose price is less than or equal to queries[j]. If no such item exists, then the answer to this query is 0.
 *
 * Return an array answer of the same length as queries where answer[j] is the answer to the jth query.
 *
 */
public class MostBeautifulItemforEachQuery {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Step 1: Sort items by price in ascending order
        Arrays.sort(items, (a, b) -> {
            return a[0] - b[0];
        });

        // Step 2: Preprocess items array to store the maximum beauty up to each item's price.
        // This way, for each item, items[i][1] will hold the highest beauty value up to price items[i][0].
        for (int i = 1; i < items.length; i++) {
            // Set the beauty value of each item to the maximum beauty encountered so far in the sorted array.
            items[i][1] = Math.max(items[i - 1][1], items[i][1]);
        }

        // Step 3: Initialize variables to process each query.
        int n = queries.length; // Number of queries
        int[] result = new int[n]; // Result array to store the maximum beauty for each query
        int i = 0; // Index to store the result for each query

        // Step 4: Process each query independently.
        for (int q : queries) {
            int ans = 0; // Initialize answer for this query as 0 (default if no item satisfies the price condition)
            int left = 0; // Left bound for binary search
            int right = items.length - 1; // Right bound for binary search

            // Binary search to find the maximum beauty item with a price less than or equal to the current query value
            while (left <= right) {
                int mid = left + (right - left) / 2; // Calculate the midpoint to avoid overflow

                if (items[mid][0] > q) {
                    // If the price of the item at mid is greater than the query, search the left half
                    right = mid - 1;
                } else {
                    // If the price of the item at mid is within the query range, it’s a candidate for the answer.
                    // Update answer with the beauty of this item, and move to the right half to find a potentially higher beauty
                    ans = items[mid][1];
                    left = mid + 1;
                }
            }
            // Store the maximum beauty found for this query in the result array
            result[i++] = ans;
        }

        // Return the result array containing the maximum beauty for each query
        return result;
    }
}
