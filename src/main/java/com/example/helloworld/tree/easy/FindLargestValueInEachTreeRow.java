package com.example.helloworld.tree.easy;

import com.example.helloworld.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode 515. Find Largest Value in Each Tree Row
 *
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,3,2,5,3,null,9]
 * Output: [1,3,9]
 * Example 2:
 *
 * Input: root = [1,2,3]
 * Output: [1,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree will be in the range [0, 104].
 * -2^31 <= Node.val <= 2^31 - 1
 *
 * We're doing the level order traversal of the tree! So, we'll use a queue to store the nodes at each level.
 * We'll also use a variable to store the maximum value at each level.
 */
public class FindLargestValueInEachTreeRow {

    // level order traversal
    // find the maximum value at each level
    // return the list of maximum values
    // Time complexity: O(n)
    // Space complexity: O(n)
    // n is the number of nodes in the tree

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return ans;

        q.offer(root);

        while (!q.isEmpty()) {
            int len = q.size();
            int max = Integer.MIN_VALUE;
            while (len-- > 0) {
                TreeNode t = q.poll();
                max = Math.max(max, t.val);

                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            ans.add(max);
        }

        return ans;
    }

    // write main method to test above function
    public static void main(String[] args) {
        FindLargestValueInEachTreeRow obj = new FindLargestValueInEachTreeRow();

        // create a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        //         1
        //        / \
        //       3   2
        //      / \   \
        //     5   3   9

        System.out.println(obj.largestValues(root));
    }

}
