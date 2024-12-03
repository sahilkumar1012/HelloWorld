package com.example.helloworld.string.easy;

/**
 * leetcode 2109. Adding Spaces to a String , String, Two pointers , Simulation , Amazon interview question
 *
 * Code Harmony Video Explanation : https://youtu.be/IAL3lk-AD0c
 *
 * My LeetCode Solution : https://leetcode.com/problems/adding-spaces-to-a-string/solutions/6106566/easy-intuition-two-pointers-string-buffer-detailed-code-video-explanation
 *
 *
 *You are given a 0-indexed string s and a 0-indexed integer array spaces that describes the indices in the original string where spaces will be added. Each space should be inserted before the character at the given index.
 *
 * For example, given s = "EnjoyYourCoffee" and spaces = [5, 9], we place spaces before 'Y' and 'C', which are at indices 5 and 9 respectively. Thus, we obtain "Enjoy Your Coffee".
 * Return the modified string after the spaces have been added.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "LeetcodeHelpsMeLearn", spaces = [8,13,15]
 * Output: "Leetcode Helps Me Learn"
 * Explanation:
 * The indices 8, 13, and 15 correspond to the underlined characters in "LeetcodeHelpsMeLearn".
 * We then place spaces before those characters.
 * Example 2:
 *
 * Input: s = "icodeinpython", spaces = [1,5,7,9]
 * Output: "i code in py thon"
 * Explanation:
 * The indices 1, 5, 7, and 9 correspond to the underlined characters in "icodeinpython".
 * We then place spaces before those characters.
 * Example 3:
 *
 * Input: s = "spacing", spaces = [0,1,2,3,4,5,6]
 * Output: " s p a c i n g"
 * Explanation:
 * We are also able to place spaces before the first character of the string.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consists only of lowercase and uppercase English letters.
 * 1 <= spaces.length <= 3 * 105
 * 0 <= spaces[i] <= s.length - 1
 * All the values of spaces are strictly increasing.
 */
public class AddingSpacestoaString {
    public String addSpaces(String s, int[] spaces) {
        // Create a StringBuilder to efficiently build the output string
        StringBuilder sb = new StringBuilder();

        // Initialize an index `j` to iterate over the `spaces` array
        int j = 0;

        // Iterate through the characters of the input string `s`
        for (int i = 0; i < s.length(); i++) {
            // Check if the current index `i` matches the current position in the `spaces` array
            if (j < spaces.length && i == spaces[j]) {
                // If it matches, append a space to the StringBuilder
                sb.append(' ');
                // Move to the next position in the `spaces` array
                j++;
            }
            // Append the current character from the string `s` to the StringBuilder
            sb.append(s.charAt(i));
        }

        // Convert the StringBuilder to a string and return the result
        return sb.toString();
    }

}
