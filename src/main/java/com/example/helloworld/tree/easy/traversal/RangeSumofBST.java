package com.example.helloworld.tree.easy.traversal;

import com.example.helloworld.tree.model.TreeNode;

/**
 * leetcode 938. Range Sum of BST
 *
 * code harmony solution video : https://youtu.be/ekMZms_ihOY
 *
 * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 * Example 2:
 *
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 * Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 2 * 104].
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * All Node.val are unique.
 */
public class RangeSumofBST {

    private int sum; // To store the sum of node values within the given range.

    /**
     * Calculates the sum of values of all nodes in the given binary search tree
     * that fall within the inclusive range [low, high].
     *
     * @param root The root node of the binary search tree.
     * @param low  The lower bound of the range.
     * @param high The upper bound of the range.
     * @return The sum of values of all nodes within the range [low, high].
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0; // Initialize sum to 0 before performing the traversal.
        inOrder(root, low, high); // Perform in-order traversal to calculate the sum.
        return sum;
    }

    /**
     * Performs in-order traversal of the binary search tree and calculates the sum
     * of node values that fall within the inclusive range [low, high].
     *
     * @param root The current root node.
     * @param low  The lower bound of the range.
     * @param high The upper bound of the range.
     */
    private void inOrder(TreeNode root, int low, int high) {
        // Base case: If the root is null, return without performing any operation.
        if (root == null) {
            return;
        }

        // Traverse left subtree.
        inOrder(root.left, low, high);

        // Check if the current node's value falls within the range [low, high].
        if (root.val >= low && root.val <= high) {
            sum += root.val; // If yes, add the current node's value to the sum.
        }

        // Traverse right subtree.
        inOrder(root.right, low, high);
    }
}
