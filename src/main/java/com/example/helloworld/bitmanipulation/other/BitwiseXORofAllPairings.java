package com.example.helloworld.bitmanipulation.other;

/**
 * leetcode 2425. Bitwise XOR of All Pairings , Xor properties
 *
 * Code Harmony Video Explanation : https://youtu.be/EhsM7HKn7sc
 *
 * My LeetCode Solution : https://leetcode.com/problems/bitwise-xor-of-all-pairings/solutions/6288031/mastering-xor-operations-bit-manipulatio-fp2n
 *
 *
 * You are given two 0-indexed arrays, nums1 and nums2, consisting of non-negative integers. There exists another array, nums3, which contains the bitwise XOR of all pairings of integers between nums1 and nums2 (every integer in nums1 is paired with every integer in nums2 exactly once).
 *
 * Return the bitwise XOR of all integers in nums3.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [2,1,3], nums2 = [10,2,5,0]
 * Output: 13
 * Explanation:
 * A possible nums3 array is [8,0,7,2,11,3,4,1,9,1,6,3].
 * The bitwise XOR of all these numbers is 13, so we return 13.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 0
 * Explanation:
 * All possible pairs of bitwise XORs are nums1[0] ^ nums2[0], nums1[0] ^ nums2[1], nums1[1] ^ nums2[0],
 * and nums1[1] ^ nums2[1].
 * Thus, one possible nums3 array is [2,5,1,6].
 * 2 ^ 5 ^ 1 ^ 6 = 0, so we return 0.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 105
 * 0 <= nums1[i], nums2[j] <= 109
 */
public class BitwiseXORofAllPairings {

    public int xorAllNums(int[] nums1, int[] nums2) {
        // Get the lengths of both arrays
        int m = nums1.length;
        int n = nums2.length;

        // Variable to store the XOR result
        int result = 0;

        // If the length of nums2 is odd, every element in nums1
        // will contribute to the final XOR. This is because each
        // element in nums1 pairs with all elements of nums2.
        if (n % 2 == 1) {
            for (int num : nums1) {
                result ^= num;
            }
        }

        // Similarly, if the length of nums1 is odd, every element in nums2
        // will contribute to the final XOR. This is because each element
        // in nums2 pairs with all elements of nums1.
        if (m % 2 == 1) {
            for (int num : nums2) {
                result ^= num;
            }
        }

        // Return the computed XOR of all pairings
        return result;
    }
}
