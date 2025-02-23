package com.example.helloworld.backtracking.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 1980. Find Unique Binary String
 * https://leetcode.com/problems/find-unique-binary-string/
 *
 * code harmony video explanation : https://youtu.be/k67gf1rN4TI
 *
 * my leetcode solution : https://leetcode.com/problems/find-unique-binary-string/solutions/6445997/easy-to-understand-beginner-friendly-bac-u4uk
 *
 *
 * Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length
 * n that does not appear in nums. If there are multiple answers, you may return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = ["01","10"]
 * Output: "11"
 * Explanation: "11" does not appear in nums. "00" would also be correct.
 * Example 2:
 *
 * Input: nums = ["00","01"]
 * Output: "11"
 * Explanation: "11" does not appear in nums. "10" would also be correct.
 * Example 3:
 *
 * Input: nums = ["111","011","001"]
 * Output: "101"
 * Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 16
 * nums[i].length == n
 * nums[i] is either '0' or '1'.
 * All the strings of nums are unique.
 */
public class FindUniqueBinaryString {
    Set<String> set; // Use a Set for efficient checking of existing strings
    String ans;      // Stores the resulting different binary string

    public String findDifferentBinaryString(String[] nums) {
        set = new HashSet<>(); // Initialize the Set
        ans = "";             // Initialize the answer string

        // Add all the input binary strings to the Set for quick lookup
        for (String s : nums) {
            set.add(s);
        }

        int n = nums.length; // Store the length of the input array (also the length of the binary strings)

        // Start the recursive search for a different binary string
        sol(0, n, "");
        return ans;
    }

    /**
     * Recursive helper function to generate and check binary strings.
     *
     * @param idx  The current index (bit position) being considered.
     * @param n    The total length of the binary strings.
     * @param temp The current binary string being built.
     * @return True if a different binary string is found, false otherwise.
     */
    private boolean sol(int idx, int n, String temp) {
        // Base case: If we've reached the end of the string
        if (idx == n) {
            // Check if the generated string is NOT present in the Set
            if (!set.contains(temp)) {
                ans = temp; // Found a different string, store it
                return true;  // Signal that we've found the answer
            }
            return false; // The generated string is already in the Set, so continue searching
        }

        // Recursive calls: Explore both possibilities for the current bit (0 or 1)

        // Try appending '0' to the current string and explore further
        if (sol(idx + 1, n, temp + "0")) {
            return true; // If the recursive call found a solution, return true
        }

        // Try appending '1' to the current string and explore further
        if (sol(idx + 1, n, temp + "1")) {
            return true; // If the recursive call found a solution, return true
        }

        // If neither appending '0' nor '1' led to a solution, return false
        return false;
    }
}