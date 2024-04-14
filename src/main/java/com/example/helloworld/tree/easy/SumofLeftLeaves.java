package com.example.helloworld.tree.easy;

import com.example.helloworld.tree.model.TreeNode;

/**
 * leetcode 404. Sum of Left Leaves
 * Code Harmony reference video : https://youtu.be/0MA1h525Yqs
 *
 * Given the root of a binary tree, return the sum of all left leaves.
 *
 * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 24
 * Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
 * Example 2:
 *
 * Input: root = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -1000 <= Node.val <= 1000
 *
 */
public class SumofLeftLeaves {

    // Variable to store the sum of left leaves
    int sum;

    /**
     * Computes the sum of all left leaves in a binary tree.
     *
     * @param root The root of the binary tree.
     * @return The sum of all left leaves.
     */
    public int sumOfLeftLeaves(TreeNode root) {
        // Initialize sum to 0
        sum = 0;
        // Start depth-first search
        dfs(root, false);

        // Return the sum of left leaves
        return sum;
    }

    /**
     * Depth-first search to traverse the binary tree.
     *
     * @param root The current node in the traversal.
     * @param left Flag indicating whether the current node is a left child of its parent.
     */
    private void dfs(TreeNode root, boolean left){
        // Base case: if the node is null, return
        if(root == null) return ;

        // If the current node is a leaf node, and it's a left child, add its value to the sum
        if(root.left == null && root.right == null && left == true){
            sum += root.val;
        }

        // Recursive call on the left child with 'left' flag set to true
        dfs(root.left , true);
        // Recursive call on the right child with 'left' flag set to false
        dfs(root.right, false);
    }

}
