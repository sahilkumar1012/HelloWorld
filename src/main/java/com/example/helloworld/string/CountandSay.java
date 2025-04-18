package com.example.helloworld.string;

/**
 * leetcode 38. Count and Say , Google amazon meta adobe apple etc
 *
 * code harmony video explanation : https://youtu.be/ZloO-vPUdoo
 *
 * my leetcode solution : https://leetcode.com/problems/count-and-say/solutions/6662200/easy-to-understand-detailed-time-analysi-jtkl
 *
 * 38. Count and Say

 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the run-length encoding of countAndSay(n - 1).
 * Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".
 *
 * Given a positive integer n, return the nth element of the count-and-say sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4
 *
 * Output: "1211"
 *
 * Explanation:
 *
 * countAndSay(1) = "1"
 * countAndSay(2) = RLE of "1" = "11"
 * countAndSay(3) = RLE of "11" = "21"
 * countAndSay(4) = RLE of "21" = "1211"
 * Example 2:
 *
 * Input: n = 1
 *
 * Output: "1"
 *
 * Explanation:
 *
 * This is the base case.
 *
 *
 *
 * Constraints:
 *
 * 1 <= n <= 30
 *
 *
 * Follow up: Could you solve it iteratively?
 *
 *
 */
public class CountandSay {

    // Main function to generate the nth term of the Count and Say sequence
    public String countAndSay(int n) {
        String s = "1"; // Start with the first term of the sequence
        for(int i = 1; i < n; i++) {
            s = rle(s); // Apply run-length encoding (count-and-say) n-1 times
        }
        return s; // Return the final result after n-1 transformations
    }

    // Helper function to perform one iteration of the "count and say" operation
    private String rle(String s) {
        char ch = s.charAt(0); // Current character to track
        int count = 1;         // Counter for repeated characters
        int i = 1, n = s.length();
        StringBuilder sb = new StringBuilder(); // To build the resulting string

        while(i < n) {
            if(s.charAt(i) == ch) {
                // If current char is same as previous, increment count
                count++;
            } else {
                // Append the count and character to the result
                sb.append(count).append(ch);
                // Reset count and update current character
                count = 1;
                ch = s.charAt(i);
            }
            i++;
        }

        // Append the last group (since loop ends before it gets added)
        sb.append(count).append(ch);

        return sb.toString(); // Return the transformed string
    }
}
