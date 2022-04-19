package com.example.helloworld.tree;

import com.example.helloworld.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversalMorris {

    /**
     * Morris inorder traversal
     *
     * @param root
     * @return
     * @see <a href=
     *      "https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/">Inorder
     *      Tree Traversal without recursion and without stack</a>
     * @see <a href="https://en.wikipedia.org/wiki/Threaded_binary_tree">Threaded
     *      binary tree</a>
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        if (root == null)
            return r;

        // Start from root
        TreeNode cur = root;

        // Define a cursor that will be used to find predecessor, link and unlink nodes
        TreeNode traverseCursor = null;
        while (cur != null) {
            /*
             * Check current node's left child, if the left child node exist, then traverse
             * through left child's right branch to the bottom, the rightmost leaf node will
             * be the predecessor of current node, once we find it, we 'link' the
             * predecessor to current node, i.e., we make current node the right child of
             * the predecessor
             */
            if (cur.left != null) {
                traverseCursor = cur.left;
                while (traverseCursor.right != null && traverseCursor.right != cur) {
                    traverseCursor = traverseCursor.right;
                }

                if (traverseCursor.right == null) {
                    // We found the leaf node, now create the link
                    traverseCursor.right = cur;
                    // Now move the cursor of current node to its left child
                    cur = cur.left;
                }

                if (traverseCursor.right == cur) {
                    // This case is indicating we have already visited current node's predecessor by
                    // linking, we need to unlink the nodes to restore the original tree
                    traverseCursor.right = null;
                    // This case is also indicating we are visiting the successor of the predecessor
                    // i.e., the root
                    r.add(cur.val);
                    // Now visit the right branch
                    cur = cur.right;
                }
            } else {
                // We reached the node we want to visit
                r.add(cur.val);
                // Now we move the cursor to its 'right' child, which was linked to its
                // successor
                // by traverseCursor
                cur = cur.right;
            }
        }

        return r;
    }
}