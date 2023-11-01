package com.example.helloworld.tree.easy;

import com.example.helloworld.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 501. Find Mode in Binary Search Tree
 *
 * Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
 *
 * If the tree has more than one mode, return them in any order.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: root = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 *
 *
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class FindModeinBinarySearchTree {
    List<Integer> ans;
    int prev = Integer.MIN_VALUE;
    int mf = 1;
    int temp = 1;

    public int[] findMode(TreeNode root) {
        ans = new ArrayList<>();
        inOrder(root);

        int[] res = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }

    private void inOrder(TreeNode root){
        if(root == null) return;

        inOrder(root.left);

        if( root.val == prev ){
            temp ++;
        }else{
            temp = 1;
            prev = root.val;
        }

        if( temp > mf ){
            ans.clear();
            ans.add(root.val);
            mf = temp;
        }else if ( temp == mf ){
            ans.add(root.val);
        }

        inOrder(root.right);
    }
}
