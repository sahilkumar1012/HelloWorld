package com.example.helloworld.tree;

import com.example.helloworld.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * leetcode 272. Closest Binary Search Tree Value II
 *
 * Given the root of a binary search tree, a target value, and an integer k, return the k values in the BST that are closest to the target. You may return the answer in any order.
 *
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,5,1,3], target = 3.714286, k = 2
 * Output: [4,3]
 * Example 2:
 *
 * Input: root = [1], target = 0.000000, k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104.
 * 0 <= Node.val <= 109
 * -109 <= target <= 109
 *
 *
 * Follow up: Assume that the BST is balanced. Could you solve it in less than O(n) runtime (where n = total nodes)?
 */
public class ClosestBinarySearchTreeValueII {
    class Item {
        public int val;
        public double diff;

        public Item(int val, double diff) {
            this.val = val;
            this.diff = diff;
        }
    }

    class Solution {
        PriorityQueue<Item> pq = new PriorityQueue<Item>((a, b) -> {
            return b.diff - a.diff > 0 ? 1 : -1; // low diff are priority
        });

        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            sol(root, target, k);

            List<Integer> ans = new ArrayList<>();
            while (!pq.isEmpty()) {
                ans.add(pq.poll().val);
            }
            return ans;
        }

        private void sol(TreeNode root, double target, int k) {
            if (root == null) return;

            double tmin = Math.abs(target - root.val);
            pq.offer(new Item(root.val, Math.abs(root.val - target)));
            if (pq.size() > k)
                pq.poll();

            sol(root.left, target, k);
            sol(root.right, target, k);
        }
    }
}