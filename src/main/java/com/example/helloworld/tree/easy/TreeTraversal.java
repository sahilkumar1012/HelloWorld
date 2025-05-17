package com.example.helloworld.tree.easy;

import com.example.helloworld.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {

}

/**
 * Morris Tree Traversal
 * We'll be using threaded binary tree to keep track of inorder successor for every null right pointer to process the values in
 * inorder fashion.
 *
 * Time O(n)
 * Space O(1)
 */
class MorrisTreeTraversal{
    /**
     * Morris Inorder Traversal
     * @param root
     * @return
     */
// Function to perform Morris Inorder Traversal of a binary tree
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr = root, temp = null;
        List<Integer> res = new ArrayList<>();

        // Base case: if the tree is empty
        if(root == null) return res;

        // Traverse the tree
        while(curr != null){
            // Case 1: If current node has a left child
            if(curr.left != null){
                temp = curr.left;

                // Find the rightmost node in the left subtree (predecessor)
                // or the node that already points to current
                while(temp.right != null && temp.right != curr){
                    temp = temp.right;
                }

                // If the rightmost node's right is null, establish a temporary thread
                if(temp.right == null){
                    temp.right = curr;       // Make current the right child of its inorder predecessor
                    curr = curr.left;        // Move to left child
                }
                // If the thread already exists, it means left subtree has been visited
                else{
                    temp.right = null;       // Remove the temporary thread
                    res.add(curr.val);       // Visit the current node
                    curr = curr.right;       // Move to right subtree
                }
            }
            // Case 2: If current node has no left child
            else{
                res.add(curr.val);           // Visit the current node
                curr = curr.right;           // Move to right child
            }
        }

        return res;  // Return the inorder traversal
    }


    /**
     * Morris preorder traversal
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        TreeNode curr = root, temp;
        while(curr != null){
            if(curr.left != null){  // find predecessor of curr node
                temp = curr.left;
                while(temp.right != null && temp.right != curr){
                    temp = temp.right;
                }
                if(temp.right == null){     // go process left first.
                    res.add(curr.val);
                    temp.right = curr;      // form the pointer
                    curr = curr.left;
                }else{          // left side is done.
                    temp.right = null;      // break the pointer
                    curr = curr.right;
                }
            }else{
                res.add(curr.val);
                curr = curr.right;      // move to right subtree
            }

        }

        return res;
    }
}
