package com.example.helloworld.tree;

import com.example.helloworld.tree.model.TreeNode;

/**
 * leetcode 623. Add One Row to Tree
 * https://leetcode.com/problems/add-one-row-to-tree/description/
 *
 * code harmony reference video : https://youtu.be/yWrOO8-w8_k
 *
 *
 * Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.
 *
 * Note that the root node is at depth 1.
 *
 * The adding rule is:
 *
 * Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
 * cur's original left subtree should be the left subtree of the new left subtree root.
 * cur's original right subtree should be the right subtree of the new right subtree root.
 * If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,6,3,1,5], val = 1, depth = 2
 * Output: [4,1,1,2,null,null,6,3,1,5]
 * Example 2:
 *
 *
 * Input: root = [4,2,null,3,1], val = 1, depth = 3
 * Output: [4,2,null,1,1,3,null,null,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * The depth of the tree is in the range [1, 104].
 * -100 <= Node.val <= 100
 * -105 <= val <= 105
 * 1 <= depth <= the depth of tree + 1
 */
public class AddOneRowtoTree {

    /**
     * Adds a row to the binary tree.
     *
     * @param root The root of the binary tree.
     * @param val The value of the nodes to be added.
     * @param d The depth at which the row should be added.
     * @return The root of the modified binary tree.
     */
    public TreeNode addOneRow(TreeNode root, int val, int d) {
        if(d == 1){
            // If depth is 1, add a new root node and link the current tree as its left subtree.
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        // Otherwise, recursively insert nodes at the specified depth.
        insert(root, val, d, 1);
        return root;
    }

    /**
     * Recursively inserts nodes at the specified depth in the binary tree.
     *
     * @param root The current root of the binary tree.
     * @param val The value of the nodes to be inserted.
     * @param d The target depth.
     * @param cd The current depth.
     */
    private void insert(TreeNode root, int val, int d, int cd){
        if(root == null) return;
        if(cd == d - 1){
            // If the current depth is one less than the target depth, insert nodes.
            TreeNode temp = root.left;
            root.left = new TreeNode(val);
            root.left.left = temp;

            temp = root.right;
            root.right = new TreeNode(val);
            root.right.right = temp;
        } else {
            // Otherwise, continue traversing the tree recursively.
            insert(root.left, val, d, cd + 1);
            insert(root.right, val, d, cd + 1);
        }
    }
}