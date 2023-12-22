package com.example.helloworld.string.others;

/**
 * LeetCode 1422. Maximum Score After Splitting a String
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/
 *
 * Problem Statement:
 * Given a binary string 's' (consisting of zeros and ones),
 * determine the maximum score obtained by splitting 's' into two non-empty substrings.
 * The score is defined as the sum of zeros in the left substring and ones in the right substring.
 *
 * Examples:
 * - For s = "011101", the maximum score is 5.
 * - For s = "00111", the maximum score is 5.
 * - For s = "1111", the maximum score is 3.
 *
 * Constraints:
 * - 2 <= s.length <= 500
 * - The string s consists only of '0' and '1' characters.
 */
public class MaximumScoreAfterSplittingaString {

    /**
     * Function to determine the maximum score after splitting a binary string.
     *
     * @param s Binary string to split.
     * @return Maximum score.
     */
    public int maxScore(String s) {
        int n = s.length();

        // Count the total number of '1's in the string.
        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }

        int maxScore = 0, onesSoFar = 0;

        // Iterate through the string (excluding the last character).
        for (int i = 0; i <= n - 2; i++) {
            // If the current character is '1', increment the count of ones seen so far.
            if (s.charAt(i) == '1') {
                onesSoFar++;
            }

            // Calculate the number of zeros on the left side and ones on the right side.
            int zerosOnLeft = (i + 1) - onesSoFar;
            int onesOnRight = totalOnes - onesSoFar;

            // Update the maximum score if the current score is greater.
            maxScore = Math.max(maxScore, zerosOnLeft + onesOnRight);
        }

        return maxScore;
    }

    /**
     * Main method to test the maxScore function with a sample input.
     *
     * @param args Command-line arguments (unused).
     */
    public static void main(String[] args) {
        MaximumScoreAfterSplittingaString obj = new MaximumScoreAfterSplittingaString();
        int maxScoreResult = obj.maxScore("00111");
        System.out.println("Maximum Score: " + maxScoreResult);
    }
}
