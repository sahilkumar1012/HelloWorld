package com.example.helloworld.tree;

import com.example.helloworld.tree.model.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 106. Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 *
 *
 * Constraints:
 *
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {

    private int last;
    private Map<Integer, Integer> inorderHash; // to avoid iterations to search for root at every step.

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        last = n;

        inorderHash = new HashMap<>();
        for(int i=0; i<n; ++i){
            inorderHash.put(inorder[i], i);
        }

        return sol(inorder, postorder, 0, n-1);
    }

    private TreeNode sol(int[] inorder, int[] postorder, int start, int end){
        if(start > end)
            return null;

        last--;
        TreeNode root = new TreeNode(postorder[last]);

        int rootidx = inorderHash.get(postorder[last]);

        root.right = sol(inorder, postorder, rootidx+1, end);
        root.left = sol(inorder, postorder, start, rootidx-1);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        new ConstructBinaryTreefromInorderandPostorderTraversal().buildTree(inorder, postorder);
    }
}