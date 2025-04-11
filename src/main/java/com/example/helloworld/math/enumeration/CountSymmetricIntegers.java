package com.example.helloworld.math.enumeration;

/**
 * leetcode 2843. Count Symmetric Integers , Google Amazon Apple
 *
 * code harmony video explanation : https://youtu.be/UCmQUKNX-aA
 *
 * my leetcode solution: https://leetcode.com/problems/count-symmetric-integers/solutions/6638158/beginner-friendly-enumeration-easy-to-un-kaz0
 *
 *
 * You are given two positive integers low and high.
 *
 * An integer x consisting of 2 * n digits is symmetric if the sum of the first n digits of x is equal to the sum of the last n digits of x. Numbers with an odd number of digits are never symmetric.
 *
 * Return the number of symmetric integers in the range [low, high].
 *
 *
 *
 * Example 1:
 *
 * Input: low = 1, high = 100
 * Output: 9
 * Explanation: There are 9 symmetric integers between 1 and 100: 11, 22, 33, 44, 55, 66, 77, 88, and 99.
 * Example 2:
 *
 * Input: low = 1200, high = 1230
 * Output: 4
 * Explanation: There are 4 symmetric integers between 1200 and 1230: 1203, 1212, 1221, and 1230.
 *
 *
 * Constraints:
 *
 * 1 <= low <= high <= 104
 */
public class CountSymmetricIntegers {
        public int countSymmetricIntegers(int low, int high) {
            int ans = 0;

            // Iterate through all numbers in the given range [low, high]
            for (int idx = low; idx <= high; idx++) {
                int num = idx;

                // Check for 2-digit numbers (i.e., 11 to 99)
                if (num > 10 && num <= 99) {
                    // A 2-digit number is symmetric if both digits are equal
                    // That means the number must be divisible by 11 (e.g., 11, 22, 33, ...)
                    if (num % 11 == 0) ans++;
                }
                // Check for 4-digit numbers (i.e., 1000 to 9999)
                else if (num > 1000 && num <= 9999) {
                    // Extract and sum the last two digits
                    int first = num % 10;     // last digit
                    num /= 10;
                    first += num % 10;        // second last digit
                    num /= 10;

                    // Extract and sum the first two digits
                    int second = num % 10;    // third digit from right
                    num /= 10;
                    second += num % 10;       // fourth digit (most significant)

                    // If the sum of the first two digits equals the sum of the last two digits,
                    // the number is symmetric
                    if (first == second) {
                        ans++;
                    }
                }
            }

            // Return the total count of symmetric numbers
            return ans;
        }
    }
