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
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr = root, temp = null;
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        while(curr != null){
            if(curr.left != null){
                temp = curr.left;
                while(temp.right != null && temp.right != curr){
                    temp = temp.right;
                }
                if(temp.right == null){
                    temp.right = curr;
                    curr = curr.left;
                }else{
                    temp.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }else{
                res.add(curr.val);
                curr = curr.right;
            }
        }

        return res;
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
