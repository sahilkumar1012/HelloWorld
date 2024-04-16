package com.example.helloworld.array.easy;

/**
 *
 * leetcode 1351. Count Negative Numbers in a Sorted Matrix
 *
 *
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of
 * negative numbers in grid.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 * Example 2:
 *
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 * Example 3:
 *
 * Input: grid = [[1,-1],[-1,-1]]
 * Output: 3
 * Example 4:
 *
 * Input: grid = [[-1]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 *
 *
 * Follow up: Could you find an O(n + m) solution?
 *
 */
public class CountNegativeInSortedMatrix {

    // O(m+n) time.
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        int i = 0, j=n-1;

        //from right top to the left bottom item.
        while(i<m && j>=0){
            if(grid[i][j] < 0){
                ans += m-i;
                j--;
            }else{
                i++;
            }
        }

        return ans;
    }

}