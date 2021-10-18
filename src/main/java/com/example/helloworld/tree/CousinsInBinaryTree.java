package com.example.helloworld.tree;

import com.example.helloworld.tree.model.TreeNode;

/**
 * leetcode : 993. Cousins in Binary Tree
 *
 * Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
 *
 * Two nodes of a binary tree are cousins if they have the same depth with different parents.
 *
 * Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * Example 2:
 *
 *
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * Example 3:
 *
 *
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 100].
 * 1 <= Node.val <= 100
 * Each node has a unique value.
 * x != y
 * x and y are exist in the tree.
 */
public class CousinsInBinaryTree {

    int xp, yp;     // parent of nodes.
    int xd,yd;      // depth of nodes.
    int x,y; // the given two nodes.

    // they'll be cousins will on same depth but different parent.
    // do recursion and check for parent and depth of given two nodes.
    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;

        helper(root, 0, -1);
        return xp != yp && xd == yd;
    }

    private void helper(TreeNode root, int depth, int parent){
        if(root==null)
            return;

        if(root.val == x){
            xd = depth;
            xp = parent;
        }
        else if(root.val == y){
            yd = depth;
            yp = parent;
        }

        helper(root.left, depth+1, root.val);
        helper(root.right, depth+1, root.val);
    }
}
