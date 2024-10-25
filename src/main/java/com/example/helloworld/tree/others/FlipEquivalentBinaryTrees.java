package com.example.helloworld.tree.others;

import com.example.helloworld.tree.model.TreeNode;

/**
 * Leetcode 951. Flip Equivalent Binary Trees
 *
 * For a binary tree T, we can define a "flip" operation as follows: choose any node,
 * and swap the left and right child subtrees.
 *
 * A binary tree X is considered flip equivalent to a binary tree Y if and only if we
 * can make X equal to Y after some number of flip operations.
 *
 * Given the roots of two binary trees root1 and root2, this program returns true if
 * the two trees are flip equivalent, or false otherwise.
 *
 * Examples:
 *
 * Example 1:
 * Input: root1 = [1,2,3,4,5,6,null,null,null,7,8],
 *        root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
 * Output: true
 * Explanation: Trees are made equivalent by flipping at nodes with values 1, 3, and 5.
 *
 * Example 2:
 * Input: root1 = [], root2 = []
 * Output: true
 *
 * Example 3:
 * Input: root1 = [], root2 = [1]
 * Output: false
 *
 * Constraints:
 * - The number of nodes in each tree is in the range [0, 100].
 * - Each tree has unique node values in the range [0, 99].
 */
public class FlipEquivalentBinaryTrees {

    /**
     * Determines if two binary trees are flip equivalent.
     *
     * @param root1 the root of the first binary tree
     * @param root2 the root of the second binary tree
     * @return true if the two trees are flip equivalent, false otherwise
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        // Case 1: Both trees are empty (null), so they are trivially equivalent
        if (root1 == null && root2 == null) {
            return true;
        }

        // Case 2: Only one of the trees is empty, so they cannot be equivalent
        if (root1 == null || root2 == null) {
            return false;
        }

        // Case 3: Both nodes are non-null but have different values, so they cannot be equivalent
        if (root1.val != root2.val) {
            return false;
        }

        // Recursively check if the subtrees are equivalent without flipping
        // `noSwap` holds the result of comparing the left subtree of root1 with the left subtree of root2,
        // and the right subtree of root1 with the right subtree of root2.
        boolean noSwap = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);

        // Recursively check if the subtrees are equivalent with flipping
        // `swap` holds the result of comparing the left subtree of root1 with the right subtree of root2,
        // and the right subtree of root1 with the left subtree of root2.
        boolean swap = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);

        // Return true if either `noSwap` or `swap` is true, meaning the trees are flip equivalent
        return noSwap || swap;
    }

}
