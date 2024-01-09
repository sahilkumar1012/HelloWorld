package com.example.helloworld.tree.easy.traversal;

import com.example.helloworld.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 872. Leaf-Similar Trees
 *
 * code harmony solution video : https://youtu.be/wQChyQcUhLU
 *
 *
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 *
 *
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * Output: true
 * Example 2:
 *
 *
 * Input: root1 = [1,2,3], root2 = [1,3,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in each tree will be in the range [1, 200].
 * Both of the given trees will have values in the range [0, 200].
 *
 */
public class LeafSimilarTrees {

    /**
     * Main function to check if two trees are leaf-similar.
     *
     * @param root1 Root node of the first tree.
     * @param root2 Root node of the second tree.
     * @return True if both trees are leaf-similar, otherwise false.
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafSequence1 = new ArrayList<>();
        List<Integer> leafSequence2 = new ArrayList<>();

        // Generate leaf sequences for both trees
        generateLeafSequence(root1, leafSequence1);
        generateLeafSequence(root2, leafSequence2);

        // Compare the leaf sequences of both trees
        return leafSequence1.equals(leafSequence2);
    }

    /**
     * Helper function to generate leaf sequence for a given tree.
     *
     * @param root Root node of the tree.
     * @param list List to store the leaf sequence.
     */
    private void generateLeafSequence(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        // Traverse left subtree
        generateLeafSequence(root.left, list);

        // Add leaf node value to the list
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }

        // Traverse right subtree
        generateLeafSequence(root.right, list);
    }
}
