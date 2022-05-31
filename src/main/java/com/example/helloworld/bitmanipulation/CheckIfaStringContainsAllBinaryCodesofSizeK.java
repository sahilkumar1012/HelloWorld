package com.example.helloworld.bitmanipulation;

// slow solution , brute force.
// class Solution {
//     public boolean hasAllCodes(String s, int k) {
//         Set<String> set = new HashSet<>();
//         for(int i=0; i<=s.length()-k; i++){
//             String str = s.substring(i,i+k);
//             set.add(str);
//         }

//         return set.size() == Math.pow(2,k);
//     }
// }

/**
 * leetcode 1461. Check If a String Contains All Binary Codes of Size K
 *
 * Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "00110110", k = 2
 * Output: true
 * Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indices 0, 1, 3 and 2 respectively.
 * Example 2:
 *
 * Input: s = "0110", k = 1
 * Output: true
 * Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring.
 * Example 3:
 *
 * Input: s = "0110", k = 2
 * Output: false
 * Explanation: The binary code "00" is of length 2 and does not exist in the array.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 105
 * s[i] is either '0' or '1'.
 * 1 <= k <= 20
 */
public class CheckIfaStringContainsAllBinaryCodesofSizeK {
    public static boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        boolean[] got = new boolean[need];
        int allOne = need - 1;
        int hashVal = 0;

        for (int i = 0; i < s.length(); i++) {
            // calculate hash for s.substr(i-k+1,i+1)
            hashVal = ((hashVal << 1) & allOne) | (s.charAt(i) - '0');          // all one used to keep track of the window
            // hash only available when i-k+1 > 0
            if (i >= k - 1 && !got[hashVal]) {
                got[hashVal] = true;
                need--;
                if (need == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}