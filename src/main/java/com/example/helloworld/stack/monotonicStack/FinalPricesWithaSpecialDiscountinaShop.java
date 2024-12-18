package com.example.helloworld.stack.monotonicStack;

/**
 * leetCode 1475. Final Prices With a Special Discount in a Shop
 *
 * code harmony video explanation : https://youtu.be/oIPZLxC-fWk
 *
 * my leetcode solution : https://leetcode.com/problems/construct-string-with-repeat-limit/solutions/6156615/easy-to-understand-hashtable-step-by-ste-z2ka
 *
 *
 * You are given an integer array prices where prices[i] is the price of the ith item in a shop.
 *
 * There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. Otherwise, you will not receive any discount at all.
 *
 * Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [8,4,6,2,3]
 * Output: [4,2,4,2,3]
 * Explanation:
 * For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4.
 * For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2.
 * For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4.
 * For items 3 and 4 you will not receive any discount at all.
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: [1,2,3,4,5]
 * Explanation: In this case, for all items, you will not receive any discount at all.
 * Example 3:
 *
 * Input: prices = [10,1,1,6]
 * Output: [9,0,1,6]
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 500
 * 1 <= prices[i] <= 1000
 */
public class FinalPricesWithaSpecialDiscountinaShop {
    public String repeatLimitedString(String s, int repeatLimit) {
        // Create a frequency array to count occurrences of each character in the string
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // StringBuilder to construct the resulting string
        StringBuilder sb = new StringBuilder();
        // Start from the largest character ('z') and move towards the smallest ('a')
        int curr = 25;
        while (curr >= 0) {
            // Skip characters that are not present in the string
            if (freq[curr] == 0) {
                curr--;
                continue;
            }

            // Append the current character up to the repeat limit
            int limit = repeatLimit;
            while (freq[curr] > 0 && limit > 0) {
                sb.append((char) ('a' + curr));
                freq[curr]--;
                limit--;
            }

            // If the current character still has remaining frequency
            if (freq[curr] > 0) {
                // Find the next smaller character with a non-zero frequency
                int smaller = curr - 1;
                while (smaller >= 0 && freq[smaller] == 0) {
                    smaller--;
                }

                // If no smaller character is found, break the loop
                if (smaller < 0) {
                    break;
                }

                // Append the smaller character to avoid exceeding the repeat limit
                sb.append((char) ('a' + smaller));
                freq[smaller]--;
            }
        }

        // Return the constructed string
        return sb.toString();
    }
}
