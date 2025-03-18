package com.example.helloworld.dp.easy;

import com.example.helloworld.tree.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 337. House Robber III , Google , Meta , Amazon
 *
 * code harmony video explanation : https://youtu.be/xZYVvph1I-I
 *
 * my leetcode solution : https://leetcode.com/problems/house-robber-iii/solutions/6538757/easy-to-understand-recursion-with-memori-i33e
 *
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 *
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *
 *
 * Input: root = [3,4,5,1,3,null,1]
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 0 <= Node.val <= 104
 *
 */
public class HouseRobberIII {
    // HashMap to store computed results for each TreeNode to avoid recomputation (memoization)
    Map<TreeNode, Integer[]> dp;

    public int rob(TreeNode root) {
        dp = new HashMap(); // Initialize the memoization map
        return sol(root, false);  // Start the recursive function with root and 'false' (not robbed)
    }

    // Recursive function to determine the maximum money that can be robbed
    private int sol(TreeNode root, boolean probbed){
        if(root == null) // Base case: if the node is null, return 0
            return 0;

        // Store computed values for both states (robbed or not) to optimize recursion
        dp.putIfAbsent(root, new Integer[2]);
        if(dp.get(root)[probbed ? 1 : 0] != null) // If already computed, return cached result
            return dp.get(root)[probbed ? 1 : 0];

        int one = 0;
        // Case 1: If the current node is NOT robbed in the previous step, we can rob it
        if(!probbed){
            one = root.val + sol(root.left, true) + sol(root.right, true);
        }

        // Case 2: Skip robbing the current node and explore the next level of children
        int two = sol(root.left, false) + sol(root.right, false);

        // Store the maximum value from both choices in the memoization map and return it
        return dp.get(root)[probbed ? 1 : 0] = Math.max(one, two);
    }

}
