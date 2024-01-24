package com.example.helloworld.tree.easy;

import com.example.helloworld.tree.model.TreeNode;

/**
 * leetCode 1457. Pseudo-Palindromic Paths in a Binary Tree
 *
 * code harmony solution video : https://youtu.be/StKx91fo1cw
 *
 * Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.
 *
 * Return the number of pseudo-palindromic paths going from the root node to leaf nodes.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [2,3,1,3,1,null,1]
 * Output: 2
 * Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1]. Among these paths only red path and green path are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in [3,2,3] (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).
 * Example 2:
 *
 *
 *
 * Input: root = [2,1,1,1,3,null,null,null,null,null,1]
 * Output: 1
 * Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the green path [2,1,1], the path [2,1,3,1], and the path [2,1]. Among these paths only the green path is pseudo-palindromic since [2,1,1] can be rearranged in [1,2,1] (palindrome).
 * Example 3:
 *
 * Input: root = [9]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 105].
 * 1 <= Node.val <= 9
 */
public class PseudoPalindromicPathsinaBinaryTree {
    int ans; // Variable to store the result

    /**
     * Main method to calculate the number of pseudo-palindromic paths in the binary tree.
     *
     * @param root The root of the binary tree.
     * @return The number of pseudo-palindromic paths.
     */
    public int pseudoPalindromicPaths(TreeNode root) {
        ans = 0; // Initialize result

        int[] hash = new int[10]; // Array to keep track of the count of each digit in the current path
        hash[root.val]++; // Initialize with the root value

        sol(root, hash); // Recursive function to explore the tree

        return ans; // Return the final result
    }

    /**
     * Recursive helper method to explore the binary tree and count pseudo-palindromic paths.
     *
     * @param root The current node in the traversal.
     * @param hash Array to keep track of the count of each digit in the current path.
     */
    private void sol(TreeNode root, int[] hash) {
        if (root == null) return; // Base case: If the node is null, return

        if (root.left == null && root.right == null) {
            // If the current node is a leaf, check if the path is pseudo-palindromic
            if (isPseudoPalindrome(hash)) {
                ans++; // Increment the result if the path is pseudo-palindromic
            }
        }

        if (root.left != null) {
            hash[root.left.val]++; // Add the left child's value to the hash
            sol(root.left, hash); // Recur for the left child
            hash[root.left.val]--; // Remove the left child's value after recursion
        }

        if (root.right != null) {
            hash[root.right.val]++; // Add the right child's value to the hash
            sol(root.right, hash); // Recur for the right child
            hash[root.right.val]--; // Remove the right child's value after recursion
        }
    }

    /**
     * Check if the given array represents a valid permutation for a pseudo-palindromic path.
     *
     * @param hash Array representing the count of each digit in the current path.
     * @return True if the path is pseudo-palindromic, false otherwise.
     */
    private boolean isPseudoPalindrome(int[] hash) {
        int oddCount = 0; // Variable to track the count of digits with odd occurrences

        for (int i = 1; i < 10; i++) {
            if (hash[i] % 2 == 1)
                oddCount++; // Increment oddCount for digits with odd occurrences

            if (oddCount > 1)
                return false; // If more than one digit has odd occurrences, the path cannot be pseudo-palindromic
        }

        return true; // If at most one digit has odd occurrences, the path is pseudo-palindromic
    }

}
