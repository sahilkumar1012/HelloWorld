package com.example.helloworld.tree.easy;

import com.example.helloworld.tree.model.TreeNode;

/**
 * leetcode 270. Closest Binary Search Tree Value
 *
 * Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,5,1,3], target = 3.714286
 * Output: 4
 * Example 2:
 *
 * Input: root = [1], target = 4.428571
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 0 <= Node.val <= 109
 * -109 <= target <= 109
 */
public class ClosestBinarySearchTreeValue {

    // best candidate
    double min = Double.MAX_VALUE;
    int ans;

    public int closestValue(TreeNode root, double target) {
        sol(root, target);
        return ans;
    }

    // given a binary search tree and a target value
    private void sol(TreeNode root, double target){
        if(root == null) return;

        // process current value
        double tmin = Math.abs(target - root.val);
        if(tmin < min){
            min = tmin; ans = root.val;
        }

        if(target - root.val > 0.0)
            sol(root.right, target);
        else
            sol(root.left, target);

    }

}
