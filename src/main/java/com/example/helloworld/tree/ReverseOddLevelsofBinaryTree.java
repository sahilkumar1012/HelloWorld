package com.example.helloworld.tree;

import com.example.helloworld.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * leetcode 2415. Reverse Odd Levels of Binary Tree
 *
 * code harmony video explanation : https://youtu.be/mT-HQdra6iE
 *
 * Link to My Solution: https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/solutions/6167116/easy-to-understand-level-order-traversal-kh8f
 *
 * Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.
 *
 * For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
 * Return the root of the reversed tree.
 *
 * A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.
 *
 * The level of a node is the number of edges along the path between it and the root node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,3,5,8,13,21,34]
 * Output: [2,5,3,8,13,21,34]
 * Explanation:
 * The tree has only one odd level.
 * The nodes at level 1 are 3, 5 respectively, which are reversed and become 5, 3.
 * Example 2:
 *
 *
 * Input: root = [7,13,11]
 * Output: [7,11,13]
 * Explanation:
 * The nodes at level 1 are 13, 11, which are reversed and become 11, 13.
 * Example 3:
 *
 * Input: root = [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
 * Output: [0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
 * Explanation:
 * The odd levels have non-zero values.
 * The nodes at level 1 were 1, 2, and are 2, 1 after the reversal.
 * The nodes at level 3 were 1, 1, 1, 1, 2, 2, 2, 2, and are 2, 2, 2, 2, 1, 1, 1, 1 after the reversal.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 214].
 * 0 <= Node.val <= 105
 * root is a perfect binary tree.
 */
public class ReverseOddLevelsofBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        // If the root is null, return it as there is nothing to process.
        if(root == null) return root;

        // Queue to facilitate level-order traversal (BFS).
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root); // Start with the root node.
        int levelNo = 0; // Keeps track of the current level number.

        // Continue traversal until the queue is empty.
        while(!q.isEmpty()){
            int len = q.size(); // Number of nodes in the current level.
            List<TreeNode> temp = new ArrayList<>(); // To store nodes of the current level.

            // Process all nodes in the current level.
            while(len-- > 0){
                TreeNode node = q.poll(); // Retrieve the front node from the queue.
                temp.add(node); // Add the node to the temporary list.

                // Add child nodes to the queue for the next level.
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }

            // If the level is odd, reverse the values of nodes in this level.
            if(levelNo % 2 == 1){
                int n = temp.size(); // Number of nodes in the current level.
                for(int i = 0; i < n / 2; i++){
                    // Swap the values of nodes symmetrically from both ends.
                    int v = temp.get(i).val;
                    temp.get(i).val = temp.get(n - 1 - i).val;
                    temp.get(n - 1 - i).val = v;
                }
            }

            // Increment the level number to process the next level.
            levelNo++;
        }

        // Return the modified root after processing.
        return root;
    }
}

