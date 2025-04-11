package com.example.helloworld.dp.catalannumber;

/**
 * leetcode 96. Unique Binary Search Trees
 *
 *
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: 5
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 19
 */
public class UniqueBinarySearchTrees {

    public static int uniqueBinarySearchTrees(int numberOfNodes){
        return CatalanNumber.findNthCatalanNumber(numberOfNodes);
    }

    public int numTrees(int n) { //n=4
        int[] t = new int[n+1];
        t[0] = 1;
        t[1] = 1;

        // catalan number
        for(int i=2;i<=n;i++){
            int l = 0;      // left side mai nodes
            int r = i-1;    // right side mai nodes

            while(l<=i-1){
                t[i] += t[l] * t[r];
                l++;
                r--;
            }
        }
        return t[n];

    }
}
