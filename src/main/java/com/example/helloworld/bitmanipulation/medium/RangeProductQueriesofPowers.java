package com.example.helloworld.bitmanipulation.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 2438. Range Product Queries of Powers
 *
 * code harmony video explanation : https://youtu.be/K5HXoPIZ-ac
 *
 * Given a positive integer n, there exists a 0-indexed array called powers, composed of the minimum number of powers of 2 that sum to n. The array is sorted in non-decreasing order, and there is only one way to form the array.
 *
 * You are also given a 0-indexed 2D integer array queries, where queries[i] = [lefti, righti]. Each queries[i] represents a query where you have to find the product of all powers[j] with lefti <= j <= righti.
 *
 * Return an array answers, equal in length to queries, where answers[i] is the answer to the ith query. Since the answer to the ith query may be too large, each answers[i] should be returned modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 15, queries = [[0,1],[2,2],[0,3]]
 * Output: [2,4,64]
 * Explanation:
 * For n = 15, powers = [1,2,4,8]. It can be shown that powers cannot be a smaller size.
 * Answer to 1st query: powers[0] * powers[1] = 1 * 2 = 2.
 * Answer to 2nd query: powers[2] = 4.
 * Answer to 3rd query: powers[0] * powers[1] * powers[2] * powers[3] = 1 * 2 * 4 * 8 = 64.
 * Each answer modulo 109 + 7 yields the same answer, so [2,4,64] is returned.
 * Example 2:
 *
 * Input: n = 2, queries = [[0,0]]
 * Output: [2]
 * Explanation:
 * For n = 2, powers = [2].
 * The answer to the only query is powers[0] = 2. The answer modulo 109 + 7 is the same, so [2] is returned.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 109
 * 1 <= queries.length <= 105
 * 0 <= starti <= endi < powers.length
 */
public class RangeProductQueriesofPowers {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> list = new ArrayList<>(); // Stores the powers of 2 that sum to n
        int M = 1_000_000_007; // Modulo value (10^9 + 7)

        int p = 1; // Tracks the current power of 2 (starting with 2^0 = 1)

        // Step 1: Extract powers of 2 from n (binary representation)
        while (n > 0) {
            if (n % 2 == 1) {
                // If the current bit is set, include the corresponding power of 2
                list.add(p);
            }
            n /= 2;   // Move to the next bit
            p *= 2;   // Update to the next power of 2
        }

        int m = list.size();
        int[][] res = new int[m][m]; // Precomputed product results for all ranges

        // Step 2: Precompute products for all subranges in list
        for (int i = 0; i < m; i++) {
            long curr = 1;
            for (int j = i; j < m; j++) {
                curr = (curr * list.get(j)) % M; // Multiply and take modulo
                res[i][j] = (int) curr;          // Store the product for range [i, j]
            }
        }

        // Step 3: Answer queries using the precomputed table
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = res[queries[i][0]][queries[i][1]];
        }

        return ans;
    }
}