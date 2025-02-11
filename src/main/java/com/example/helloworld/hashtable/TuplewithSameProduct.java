package com.example.helloworld.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1726. Tuple with Same Product , Google interview question
 *
 * code harmony reference video : https://youtu.be/teiylpQhR_M
 *
 * my leetcode soluion : https://leetcode.com/problems/tuple-with-same-product/solutions/6383244/easy-to-understand-array-hash-table-deta-dgxi
 *
 * Given an array nums of distinct positive integers, return the number of tuples (a, b, c, d) such that a * b = c * d where a, b, c, and d are elements of nums, and a != b != c != d.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,4,6]
 * Output: 8
 * Explanation: There are 8 valid tuples:
 * (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
 * (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
 * Example 2:
 *
 * Input: nums = [1,2,4,5,10]
 * Output: 16
 * Explanation: There are 16 valid tuples:
 * (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
 * (2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
 * (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,5,4)
 * (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 104
 * All elements in nums are distinct.
 */
public class TuplewithSameProduct {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        // Create a map to count how many pairs yield the same product
        Map<Integer, Integer> map = new HashMap<>();

        // Loop through all unique pairs (i, j) with i < j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int key = nums[i] * nums[j]; // Compute product of the pair
                // Increase the count of this product in the map
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        int ans = 0;
        // For each distinct product, count the number of tuples that can be formed.
        // If there are 'val' pairs with the same product, then we can choose any two pairs
        // (order doesn't matter) to form a valid tuple. The number of ways to choose 2 pairs
        // is given by the combination formula: val * (val - 1) / 2.
        // Each pair of pairs produces 8 valid tuples (due to different orderings).
        for (int key : map.keySet()) {
            int val = map.get(key);
            // Calculate number of ways to choose 2 pairs with this product
            int pairCount = val * (val - 1) / 2;
            // Multiply by 8 because each pair of pairs can form 8 valid tuples
            ans += pairCount * 8;
        }
        return ans;
    }
}
