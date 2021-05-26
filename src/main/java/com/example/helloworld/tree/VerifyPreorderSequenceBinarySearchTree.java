package com.example.helloworld.tree;

/**

 * leetcode 255. Verify Preorder Sequence in Binary Search Tree
 *
 * Given an array of unique integers preorder, return true if it is the correct preorder traversal sequence of a binary search tree.
 *
 * Example 1:
 * Input: preorder = [5,2,1,3,6]
 * Output: true
 * Example 2:
 * Input: preorder = [5,2,6,1,3]
 * Output: false
 *
 * Constraints:
 * 1 <= preorder.length <= 104
 * 1 <= preorder[i] <= 104
 * All the elements of preorder are unique.
 *
 * Follow up: Could you do it using only constant space complexity?
 */
public class VerifyPreorderSequenceBinarySearchTree {

    public boolean verifyPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, preorder.length - 1);
    }

    private boolean helper(int[] preorder, int max, int min, int start, int end) {
        // add breaking condition
        if (start > end)
            return true;

        int root = preorder[start];
        if (root < min || root > max)
            return false;

        int i = start + 1;
        while (i <= end && preorder[i] < root) {
            i++;
        }

        return helper(preorder, root, min, start + 1, i - 1) && helper(preorder, max, root, i, end);

    }
}
