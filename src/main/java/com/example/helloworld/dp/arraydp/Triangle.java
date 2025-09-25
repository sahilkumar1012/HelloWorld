package com.example.helloworld.dp.arraydp;

import java.util.List;

/**
 * leetcode 120. Triangle , DP, topdown -> bottom up for space optimization
 *
 * code harmony video explanation : https://youtu.be/HYTOKlsqb6M
 *
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 *
 *
 *
 * Example 1:
 *
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 * Example 2:
 *
 * Input: triangle = [[-10]]
 * Output: -10
 *
 *
 * Constraints:
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 *
 *
 * Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
 */
public class Triangle {
    // Top-down recursive + memoization
    List<List<Integer>> triangle;
    int m;
    Integer[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        m = triangle.size();
        dp = new Integer[m][m];
        return sol(0, 0);
    }

    private int sol(int r, int c) {
        if (r == m) return 0;
        if (dp[r][c] != null) return dp[r][c];

        return dp[r][c] = triangle.get(r).get(c)
                + Math.min(
                sol(r + 1, c),
                sol(r + 1, c + 1)
        );
    }

    // Bottom-up with O(n) space
    public int minimumTotalBottomUp(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1]; // extra element for dp[c+1] safety

        // Start from last row
        for (int r = n - 1; r >= 0; r--) {
            for (int c = 0; c < triangle.get(r).size(); c++) {
                dp[c] = triangle.get(r).get(c) + Math.min(dp[c], dp[c + 1]);
            }
        }

        return dp[0];
    }
}
