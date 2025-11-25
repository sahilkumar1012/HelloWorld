package com.example.helloworld.stack.monotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode 1504. Count Submatrices With All Ones , Histogram, Google
 *
 * Code Harmony Video Explanation : https://youtu.be/yaL_ZqTWDU8
 *
 * Given an m x n binary matrix mat, return the number of submatrices that have all ones.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[1,0,1],[1,1,0],[1,1,0]]
 * Output: 13
 * Explanation:
 * There are 6 rectangles of side 1x1.
 * There are 2 rectangles of side 1x2.
 * There are 3 rectangles of side 2x1.
 * There is 1 rectangle of side 2x2.
 * There is 1 rectangle of side 3x1.
 * Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.
 * Example 2:
 *
 *
 * Input: mat = [[0,1,1,0],[0,1,1,1],[1,1,1,0]]
 * Output: 24
 * Explanation:
 * There are 8 rectangles of side 1x1.
 * There are 5 rectangles of side 1x2.
 * There are 2 rectangles of side 1x3.
 * There are 4 rectangles of side 2x1.
 * There are 2 rectangles of side 2x2.
 * There are 2 rectangles of side 3x1.
 * There is 1 rectangle of side 3x2.
 * Total number of rectangles = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24.
 *
 *
 * Constraints:
 *
 * 1 <= m, n <= 150
 * mat[i][j] is either 0 or 1.
 */
public class CountSubmatricesWithAllOnes {

    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] height = new int[n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            // build histogram heights for row i
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) height[j] = 0;
                else height[j]++;
            }

            // brute force count with current row as base
            ans += countRectangles(height);
        }
        return ans;
    }
    // 0,2,1,0 -> no of rectangles in this histogram.?

    // O(N) - monotonic stack?, this is brute force in quadratic time.
//    private int countRectangles(int[] h) {
//        int n = h.length;
//        int res = 0;
//
//        for (int j = 0; j < n; j++) {
//            int minHeight = h[j];
//            for (int k = j; k >= 0 && minHeight > 0; k--) {
//                minHeight = Math.min(minHeight, h[k]);
//                res += minHeight;
//            }
//        }
//        return res;
//    }

    private int countRectangles(int[] h) {
        int n = h.length;
        int[] sum = new int[n]; // sum[j] = number of submatrices ending at j
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;

        for (int j = 0; j < n; j++) {
            // monotonic
            while (!stack.isEmpty() && h[stack.peek()] >= h[j]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                int prev = stack.peek();
                sum[j] = sum[prev] + h[j] * (j - prev);
            } else {
                sum[j] = h[j] * (j + 1);
            }

            stack.push(j);
            res += sum[j];
        }
        return res;
    }

}
