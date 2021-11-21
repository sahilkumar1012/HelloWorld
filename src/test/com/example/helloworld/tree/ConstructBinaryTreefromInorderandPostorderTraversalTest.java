package com.example.helloworld.tree;

import com.example.helloworld.tree.model.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructBinaryTreefromInorderandPostorderTraversalTest {

    @Test
    void buildTree() {
        ConstructBinaryTreefromInorderandPostorderTraversal obj = new ConstructBinaryTreefromInorderandPostorderTraversal();
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode actual = obj.buildTree(inorder, postorder);

        assertEquals(actual.right.val, 20);
        assertEquals(actual.right.right.val, 7);
    }
}