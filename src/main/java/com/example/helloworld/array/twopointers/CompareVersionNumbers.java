package com.example.helloworld.array.twopointers;

/**
 * leetcode 165. Compare Version Numbers
 *
 * code harmony video explanation : https://youtu.be/VPq-Wu-K6EY
 *
 *
 * Given two version strings, version1 and version2, compare them. A version string consists of revisions separated by dots '.'. The value of the revision is its integer conversion ignoring leading zeros.
 *
 * To compare version strings, compare their revision values in left-to-right order. If one of the version strings has fewer revisions, treat the missing revision values as 0.
 *
 * Return the following:
 *
 * If version1 < version2, return -1.
 * If version1 > version2, return 1.
 * Otherwise, return 0.
 *
 *
 * Example 1:
 *
 * Input: version1 = "1.2", version2 = "1.10"
 *
 * Output: -1
 *
 * Explanation:
 *
 * version1's second revision is "2" and version2's second revision is "10": 2 < 10, so version1 < version2.
 *
 * Example 2:
 *
 * Input: version1 = "1.01", version2 = "1.001"
 *
 * Output: 0
 *
 * Explanation:
 *
 * Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
 *
 * Example 3:
 *
 * Input: version1 = "1.0", version2 = "1.0.0.0"
 *
 * Output: 0
 *
 * Explanation:
 *
 * version1 has less revisions, which means every missing revision are treated as "0".
 *
 *
 *
 * Constraints:
 *
 * 1 <= version1.length, version2.length <= 500
 * version1 and version2 only contain digits and '.'.
 * version1 and version2 are valid version numbers.
 * All the given revisions in version1 and version2 can be stored in a 32-bit integer.
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int n = version1.length(), m = version2.length();

        while (i < n || j < m) {
            int a = 0, b = 0;

            // Parse next integer from version1
            while (i < n && version1.charAt(i) != '.') {
                a = a * 10 + (version1.charAt(i) - '0');
                i++;
            }

            // Parse next integer from version2
            while (j < m && version2.charAt(j) != '.') {
                b = b * 10 + (version2.charAt(j) - '0');
                j++;
            }

            if (a < b) return -1;
            if (a > b) return 1;

            // skip the '.' separator
            i++;
            j++;
        }

        return 0;
    }
}