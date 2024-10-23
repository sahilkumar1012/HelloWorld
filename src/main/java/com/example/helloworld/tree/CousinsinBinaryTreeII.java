package com.example.helloworld.tree;

import com.example.helloworld.tree.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 2641. Cousins in Binary Tree II
 *
 * Problem:
 * Given the root of a binary tree, replace the value of each node with the sum of all its cousins' values.
 * Two nodes of a binary tree are cousins if they have the same depth but different parents.
 *
 * Constraints:
 * 1. The depth of a node is the number of edges from the root to the node.
 * 2. The number of nodes in the tree is in the range [1, 10^5].
 * 3. Each node's value lies between 1 and 10^4.
 *
 * Approach:
 * 1. Traverse the tree twice:
 *    - First DFS: Calculate the sum of node values for each level of the tree.
 *    - Second DFS: For each node, update its value based on the sum of cousin nodes at the same level.
 * 2. Maintain a map where the key is the level and the value is the sum of all node values at that level.
 * 3. While updating the node values, subtract the sum of the node and its siblings (sagasum) from the level sum.
 *
 * Example 1:
 * Input: root = [5, 4, 9, 1, 10, null, 7]
 * Output: [0, 0, 0, 7, 7, null, 11]
 *
 * Example 2:
 * Input: root = [3, 1, 2]
 * Output: [0, 0, 0]
 */
public class CousinsinBinaryTreeII {

    // A map to store the sum of values for each level (depth) in the tree.
    Map<Integer, Integer> map;  // level -> sum of values at that level

    // Main method to replace each node's value with the sum of its cousins' values.
    public TreeNode replaceValueInTree(TreeNode root) {
        map = new HashMap<>();  // Initialize the map.

        // First DFS: Calculate the sum of node values at each level.
        dfs(root, null, 0);

        // Second DFS: Replace each node's value with the sum of its cousins.
        sol(root, root.val, 0);

        return root;  // Return the modified tree.
    }

    /**
     * Second DFS to update each node's value.
     *
     * @param root   Current node.
     * @param sagasum Sum of the current node and its sibling(s) (if any).
     * @param level  Current depth level.
     */
    private void sol(TreeNode root, int sagasum, int level) {
        if (root == null) return;  // Base case: if node is null, return.

        // Calculate the sum of the current node's children (siblings).
        int x = 0;
        if (root.left != null) {
            x += root.left.val;  // Add left child value to x if it exists.
        }
        if (root.right != null) {
            x += root.right.val;  // Add right child value to x if it exists.
        }

        // Update the current node's value: (sum of values at this level) - (current node + sibling).
        root.val = map.get(level) - sagasum;

        // Recur for left and right subtrees, passing the sum of current node's children.
        sol(root.left, x, level + 1);
        sol(root.right, x, level + 1);
    }

    /**
     * First DFS to calculate the sum of all node values at each level.
     *
     * @param root   Current node.
     * @param parent Parent node (not used in this implementation but could be useful for modifications).
     * @param level  Current depth level.
     */
    private void dfs(TreeNode root, TreeNode parent, int level) {
        if (root == null) return;  // Base case: if node is null, return.

        // Add current node's value to the cumulative sum of the current level.
        map.put(level, map.getOrDefault(level, 0) + root.val);

        // Recur for left and right subtrees, moving to the next level.
        dfs(root.left, root, level + 1);
        dfs(root.right, root, level + 1);
    }
}
