package com.example.helloworld.tree.easy;

import com.example.helloworld.tree.model.TreeNode;

/**
 * leetcode 104. Maximum Depth of Binary Tree
 *
 *
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 * Example 3:
 *
 * Input: root = []
 * Output: 0
 * Example 4:
 *
 * Input: root = [0]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
public class MaximumDepthOfBinaryTree {

    /**
     * I learned that depth and height are properties of a node:
     *
     * The depth of a node is the number of edges from the node to the tree's root node.
     * A root node will have a depth of 0.
     *
     * The height of a node is the number of edges on the longest path from the node to a leaf.
     * A leaf node will have a height of 0.
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

//        return root==null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
