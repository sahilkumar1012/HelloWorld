package com.example.helloworld.tree.easy;

import com.example.helloworld.tree.model.TreeNode;

/**
 * leetcode 110. Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 * Example 3:
 *
 * Input: root = []
 * Output: true
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -104 <= Node.val <= 104
 */

class Height{
    int height=0;
}
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root,Height height){
        if(root==null){
            height.height = 0;
            return true;
        }
        Height lh = new Height(),rh = new Height();
        boolean l = isBalanced(root.left, lh);
        boolean r = isBalanced(root.right,rh);

        height.height = Math.max(lh.height,rh.height) + 1;

        if(Math.abs(lh.height-rh.height) > 1)
            return false;
        else
            return l && r;
    }

    // Balance binary tree
    // O(n) time, O(h) space solution, return height at every stage.
    public boolean isBalanced(TreeNode root){
        // if(root==null) return true;
        // return helper(root)!=-1;

        return isBalanced(root,new Height());
    }
    private int helper(TreeNode root){
        if(root==null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if(left==-1 || right==-1 || Math.abs(left-right)>1) return -1;
        return Math.max(left,right)+1; // return height.
    }

    // redundency of computation
    public boolean isBalanced1(TreeNode root) {
        if(root==null) return true;
        if( isBalanced(root.left)
                && isBalanced(root.right)
                && Math.abs(height(root.left)-height(root.right))<=1
        ) return true;
        return false;
    }
    private int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left) , height(root.right)) + 1;
    }
}