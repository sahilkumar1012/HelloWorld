package com.example.helloworld.array.binarysearch;

/**
 * leetcode 2040. Kth Smallest Product of Two Sorted Arrays, Google interview question
 *
 * code harmony video explanation: https://youtu.be/lC0ObrlzrAI
 *
 * Given two sorted 0-indexed integer arrays nums1 and nums2 as well as an integer k, return the kth (1-based) smallest product of nums1[i] * nums2[j] where 0 <= i < nums1.length and 0 <= j < nums2.length.
 *
 *
 * Example 1:
 *
 * Input: nums1 = [2,5], nums2 = [3,4], k = 2
 * Output: 8
 * Explanation: The 2 smallest products are:
 * - nums1[0] * nums2[0] = 2 * 3 = 6
 * - nums1[0] * nums2[1] = 2 * 4 = 8
 * The 2nd smallest product is 8.
 * Example 2:
 *
 * Input: nums1 = [-4,-2,0,3], nums2 = [2,4], k = 6
 * Output: 0
 * Explanation: The 6 smallest products are:
 * - nums1[0] * nums2[1] = (-4) * 4 = -16
 * - nums1[0] * nums2[0] = (-4) * 2 = -8
 * - nums1[1] * nums2[1] = (-2) * 4 = -8
 * - nums1[1] * nums2[0] = (-2) * 2 = -4
 * - nums1[2] * nums2[0] = 0 * 2 = 0
 * - nums1[2] * nums2[1] = 0 * 4 = 0
 * The 6th smallest product is 0.
 * Example 3:
 *
 * Input: nums1 = [-2,-1,0,1,2], nums2 = [-3,-1,2,4,5], k = 3
 * Output: -6
 * Explanation: The 3 smallest products are:
 * - nums1[0] * nums2[4] = (-2) * 5 = -10
 * - nums1[0] * nums2[3] = (-2) * 4 = -8
 * - nums1[4] * nums2[0] = 2 * (-3) = -6
 * The 3rd smallest product is -6.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 5 * 104
 * -105 <= nums1[i], nums2[j] <= 105
 * 1 <= k <= nums1.length * nums2.length
 * nums1 and nums2 are sorted.
 *
 *
 */
public class KthSmallestProductofTwoSortedArrays {


    /**
     * Helper function that counts how many elements in nums2
     * when multiplied with a given x1 from nums1, result in a product <= v.
     *
     * The logic is binary search based on the sign of x1:
     * - If x1 is positive: we search for the largest nums2[j] such that x1 * nums2[j] <= v
     * - If x1 is negative: the product x1 * nums2[j] is decreasing as nums2[j] increases,
     *   so we search for the smallest nums2[j] such that x1 * nums2[j] <= v
     */
    int countForX1(int[] nums2, long x1, long v) {
        int n2 = nums2.length;
        int left = 0, right = n2 - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long prod = (long) nums2[mid] * x1;

            // For positive x1, we need prod <= v
            // For negative x1, since nums2 is sorted in ascending order, prod decreases,
            // so we need to reverse the comparison.
            if ((x1 >= 0 && prod <= v) || (x1 < 0 && prod > v)) {
                left = mid + 1; // Try to include more elements
            } else {
                right = mid - 1; // Reduce range
            }
        }

        // For positive x1: 'left' is the number of valid pairs (prod <= v)
        // For negative x1: we count from the end (n2 - left) because prod decreases
        return x1 >= 0 ? left : n2 - left;
    }

    /**
     * This function returns total number of valid pairs (i, j)
     * such that nums1[i] * nums2[j] <= v.
     *
     * It loops through all elements in nums1 and for each element,
     * counts the number of valid partners in nums2 using countForX1().
     */
    long countPairs(long v, int[] nums1, int[] nums2) {
        long count = 0;
        for (int x1 : nums1) {
            count += countForX1(nums2, x1, v);
        }
        return count;
    }

    /**
     * Main function to find the k-th smallest product formed by pairs
     * (i, j) such that i in nums1, j in nums2.
     *
     * Uses binary search on the product space (from -1e10 to 1e10) to find the
     * smallest product such that at least k pairs exist with product <= that value.
     */
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10_000_000_000L, right = 10_000_000_000L;
        long ans = -1;

        // Binary search for the smallest product such that at least k pairs have product <= that
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long cp = countPairs(mid, nums1, nums2);

            if (cp >= k) {
                ans = mid;          // Possible answer found
                right = mid - 1;    // Search left to find smaller possible answer
            } else {
                left = mid + 1;     // Too few pairs, need to increase mid
            }
        }

        return ans; // Final answer
    }
}
