package com.example.helloworld.tree;

import com.example.helloworld.tree.model.TreeNode;

/**
 * leetcode 1026. Maximum Difference Between Node and Ancestor
 *
 * code harmony solution video : https://youtu.be/hazHSedcoTE
 *
 * Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
 *
 * A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 * Explanation: We have various ancestor-node differences, some of which are given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 * Example 2:
 *
 *
 * Input: root = [1,null,2,null,0,3]
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 5000].
 * 0 <= Node.val <= 105
 *
 */
public class MaximumDifferenceBetweenNodeandAncestor {

    // Variable to store the maximum difference found so far
    int ans = 0;

    /**
     * Main method to find the maximum difference.
     *
     * @param root The root of the binary tree
     * @return The maximum difference between a node and its ancestor
     */
    public int maxAncestorDiff(TreeNode root) {
        sol(root, root.val, root.val); // Start with the root, using its value as both min and max ancestor
        return ans;
    }

    /**
     * Recursive helper method to traverse the tree and update the maximum difference.
     *
     * @param root The current node
     * @param min  The minimum value encountered in the path from the root to the current node
     * @param max  The maximum value encountered in the path from the root to the current node
     */
    private void sol(TreeNode root, int min, int max) {
        if (root == null) {
            // Base case: Reached a null node, return
            return;
        }

        // Process the current node:
        // - Update the maximum difference if needed
        // - Update min and max values for the subtrees
        ans = Math.max(ans, Math.max(Math.abs(root.val - min), Math.abs(root.val - max)));
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);

        // Recursively explore the left and right subtrees:
        sol(root.left, min, max);
        sol(root.right, min, max);
    }
}

