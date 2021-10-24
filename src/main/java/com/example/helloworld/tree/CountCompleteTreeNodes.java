package com.example.helloworld.tree;

import com.example.helloworld.tree.model.TreeNode;

/**
 * leetcode 222. Count Complete Tree Nodes
 *
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 *
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Design an algorithm that runs in less than O(n) time complexity.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5,6]
 * Output: 6
 * Example 2:
 *
 * Input: root = []
 * Output: 0
 * Example 3:
 *
 * Input: root = [1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5 * 104].
 * 0 <= Node.val <= 5 * 104
 * The tree is guaranteed to be complete.
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        // check for extreme left and right leaf
        int height=1;
        TreeNode left = root.left, right = root.right;
        while(left!=null && right!=null){
            height++;
            left = left.left;
            right = right.right;
        }

        // if both are null, last level for this root is completely filled. otherwise split
        return (left ==null && right ==null) ? (int)Math.pow(2,height) -1
                : 1 + countNodes(root.left) + countNodes(root.right);
    }
}
