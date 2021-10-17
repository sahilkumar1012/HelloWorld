package com.example.helloworld.graph.dfs;

import com.example.helloworld.tree.model.TreeNode;

/**
 * leetcode : 437. Path Sum III
 *
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 *
 * Example 1:
 *
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * Example 2:
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 1000].
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int ts) {
        if(root==null) return 0;

        return  helper(root, ts)
                + pathSum(root.left, ts) + pathSum(root.right, ts);     // it's not the case ki path sirf root se hi start hoga.
                                                                        // kisi bhi node se start ho sakta hai path.
    }

    // bfs | number of paths with sum = ts starting from given node/root.
    private int helper(TreeNode root, int ts){
        if(root==null) return 0;

        int res = 0;
        ts -= root.val; // consume current value from ts.

        if(ts == 0) res++;
        res += helper(root.left, ts);
        res += helper(root.right, ts);

        return  res;
    }
}
