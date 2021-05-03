package com.example.helloworld.tree;

import com.example.helloworld.tree.model.TreeNode;

/**
 * 124. Binary Tree Maximum Path Sum
 * (post order approach , use solution for reference ).
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * reference video in case you don't get it : https://youtu.be/TO5zsKtc1Ic
 *
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any path.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * Example 2:
 *
 *
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 3 * 104].
 * -1000 <= Node.val <= 1000
 */
public class BinaryTreeMaximumPathSum {

    Integer result ;

    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return result;
    }
    public int maxPathSumHelper(TreeNode root) {
        if(root == null)
            return 0;

        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);

        // non contribution from -ve values.
        if(left<0) left = 0;
        if(right<0) right = 0;

        int sum = left + right + root.val; // max sum we can form using this root.

        result = Math.max(result, sum);
        return Math.max(root.val, root.val + Math.max(left,right)); // case as path can be one directional, aage carry forward hoga na path
    }
}
