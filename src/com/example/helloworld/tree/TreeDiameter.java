package com.example.helloworld.tree;

import com.example.helloworld.tree.model.TreeNode;

class Height{
    int h;
}

class TreeDiameterTest{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(new TreeDiameter().diameterOfBinaryTree(root));

    }
}

/**
 * leetcode problem 543. Diameter of Binary Tree

 Given the root of a binary tree, return the length of the diameter of the tree.

 The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

 The length of a path between two nodes is represented by the number of edges between them.


 */
public class TreeDiameter {
    /**
    set height in the call when trying to fetch the diameter, to avoid multiple calls.
     */
    private int dia(TreeNode root, Height h){
        if(root==null){
            h.h = 0;
            return 0; // diameter;
        }
        Height hl= new Height(), hr = new Height();
        int dl = dia(root.left,hl); // left diameter
        int dr = dia(root.right,hr);

        h.h = Math.max(hl.h,hr.h)+1;
        return ( Math.max ( Math.max(dl,dr), hl.h+hr.h+1) );
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return dia(root, new Height())-1;
        /* Not optimized.
        if(root==null)
            return 0;

        return Math.max (

            height(root.left)+height(root.right) + 2,
            Math.max( diameterOfBinaryTree(root.left) , diameterOfBinaryTree(root.right) )

            ) ;
        */
    }
    private int height(TreeNode root){
        if(root==null)
            return -1;
        return 1+ Math.max( height(root.left) , height(root.right) );
    }
}