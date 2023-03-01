package com.example.helloworld.tree;

import com.example.helloworld.tree.model.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * leetcode 652. Find Duplicate Subtrees
 *
 * Given the root of a binary tree, return all duplicate subtrees.
 *
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 *
 * Two trees are duplicate if they have the same structure with the same node values.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,null,2,4,null,null,4]
 * Output: [[2,4],[4]]
 * Example 2:
 *
 *
 * Input: root = [2,1,1]
 * Output: [[1]]
 * Example 3:
 *
 *
 * Input: root = [2,2,2,3,null,3,null]
 * Output: [[2,3],[3]]
 *
 *
 * Constraints:
 *
 * The number of the nodes in the tree will be in the range [1, 5000]
 * -200 <= Node.val <= 200
 */
public class FindDuplicateSubtrees {
    // solution : https://leetcode.com/problems/find-duplicate-subtrees/editorial/

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        traverse(root, new HashMap<>(), res);
        return res;
    }

    public String traverse(TreeNode node, Map<String, Integer> map,
                           List<TreeNode> res) {
        if (node == null) {
            return "";
        }

        String representation = "(" + traverse(node.left, map, res) + ")" +
                node.val + "(" + traverse(node.right, map, res) +
                ")";

        map.put(representation, map.getOrDefault(representation, 0) + 1);
        if (map.get(representation) == 2) {     // this subtree occurs more than once.
            res.add(node);
        }
        return representation;
    }
}
