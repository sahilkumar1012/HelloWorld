package com.example.helloworld.tree.others;

import com.example.helloworld.tree.model.TreeNode;

/**
 * LeetCode 129. Sum Root to Leaf Numbers
 *
 * code harmony reference video : https://youtu.be/2PMnlnqJ4bU
 *
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A leaf node is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 *
 *
 * Input: root = [4,9,0,5,1]
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 9
 * The depth of the tree will not exceed 10.
 *
 */
public class SumRoottoLeafNumbers {
    int sum;

    /**
     * Calculates the sum of all root-to-leaf numbers in the binary tree.
     *
     * @param root The root of the binary tree.
     * @return The total sum of all root-to-leaf numbers.
     */
    public int sumNumbers(TreeNode root) {
        sum = 0;
        sumPathNumbers(root, 0);

        return sum;
    }

    /**
     * Recursive method to traverse the binary tree and accumulate the sum of root-to-leaf numbers.
     *
     * @param root The current node being processed.
     * @param currentSum The sum of numbers along the current path.
     */
    private void sumPathNumbers(TreeNode root, int currentSum){
        if(root == null) return;

        // Calculate the number formed till the current node.
        currentSum = currentSum * 10 + root.val;

        // If it's a leaf node, add the current number to the total sum.
        if(root.left == null && root.right == null) {
            sum += currentSum;
        }

        // Recursively calculate the sum for left and right subtrees.
        sumPathNumbers(root.left, currentSum);
        sumPathNumbers(root.right, currentSum);
    }
}