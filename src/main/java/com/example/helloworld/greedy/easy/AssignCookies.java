package com.example.helloworld.greedy.easy;

import java.util.Arrays;

/**
 * leetcode 455. Assign Cookies
 * Code Harmony video solution : https://youtu.be/XoklTtyGoEk
 *
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
 *
 * Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
 *
 *
 *
 * Example 1:
 *
 * Input: g = [1,2,3], s = [1,1]
 * Output: 1
 * Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
 * And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
 * You need to output 1.
 * Example 2:
 *
 * Input: g = [1,2], s = [1,2,3]
 * Output: 2
 * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
 * You have 3 cookies and their sizes are big enough to gratify all of the children,
 * You need to output 2.
 *
 *
 * Constraints:
 *
 * 1 <= g.length <= 3 * 104
 * 0 <= s.length <= 3 * 104
 * 1 <= g[i], s[j] <= 231 - 1
 *
 */
public class AssignCookies {
    /**
     * Method to find the maximum number of content children.
     * @param g Array representing the greed factor of children.
     * @param s Array representing the sizes of cookies.
     * @return Maximum number of content children.
     */
    public int findContentChildren(int[] g, int[] s) {
        // Sort the arrays in ascending order to match the smallest greed factor with the smallest cookie size.
        Arrays.sort(g);
        Arrays.sort(s);

        int ans = 0; // Counter for content children.
        int i = 0, j = 0; // Pointers for iterating through the greed and cookie arrays respectively.

        // Iterate through both arrays until any one of them is exhausted.
        while (i < g.length && j < s.length) {
            // If the current cookie size is sufficient for the current child's greed factor, assign the cookie to the child and move both pointers.
            if (g[i] <= s[j]) {
                ans++; // Increment the counter for content children.
                i++;   // Move to the next child.
                j++;   // Move to the next cookie.
            } else {
                // If the cookie size is not sufficient for the current child's greed factor, try the next bigger cookie.
                j++;   // Move to the next cookie.
            }
        }

        return ans; // Return the number of content children.
    }
}
