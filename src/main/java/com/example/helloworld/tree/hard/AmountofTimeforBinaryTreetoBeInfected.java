package com.example.helloworld.tree.hard;

import com.example.helloworld.tree.model.TreeNode;

import java.util.*;

/**
 * leetcode 2385. Amount of Time for Binary Tree to Be Infected
 *
 * code harmony reference video : https://youtu.be/yZgvTi_nwI4
 *
 * You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.
 *
 * Each minute, a node becomes infected if:
 *
 * The node is currently uninfected.
 * The node is adjacent to an infected node.
 * Return the number of minutes needed for the entire tree to be infected.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,5,3,null,4,10,6,9,2], start = 3
 * Output: 4
 * Explanation: The following nodes are infected during:
 * - Minute 0: Node 3
 * - Minute 1: Nodes 1, 10 and 6
 * - Minute 2: Node 5
 * - Minute 3: Node 4
 * - Minute 4: Nodes 9 and 2
 * It takes 4 minutes for the whole tree to be infected so we return 4.
 * Example 2:
 *
 *
 * Input: root = [1], start = 1
 * Output: 0
 * Explanation: At minute 0, the only node in the tree is infected so we return 0.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 105].
 * 1 <= Node.val <= 105
 * Each node has a unique value.
 * A node with a value of start exists in the tree.
 */
public class AmountofTimeforBinaryTreetoBeInfected {

    /**
     * Approach using BFS:
     * 1. Convert the given binary tree into an adjacency list.
     * 2. Start BFS from the infected node and keep track of minutes.
     * @param root - The root of the binary tree.
     * @param start - The value of the node where the infection starts.
     * @return The number of minutes needed for the entire tree to be infected.
     */
    public int amountOfTimeBFS(TreeNode root, int start) {
        // Step 1: Convert the binary tree to an adjacency list.
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        convert(root, 0, adj);

        // Step 2: BFS to find the time taken for infection to spread throughout the tree.
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);
        int minute = 0;

        while(!q.isEmpty()){
            int len = q.size();
            while(len-- > 0){
                int remove = q.poll();
                for(int v: adj.get(remove)){
                    if(!visited.contains(v)){
                        q.offer(v);
                        visited.add(v);
                    }
                }
            }
            minute++;
        }

        return minute - 1;  // Return the minutes minus 1 as the infection starts from minute 0.
    }

    /**
     * Convert the binary tree to an adjacency list.
     * @param root - Current node in the tree.
     * @param parent - Parent node value.
     * @param map - Map to store adjacency relationships.
     */
    private void convert(TreeNode root, int parent, Map<Integer, Set<Integer>> map){
        if(root == null) return;

        if(!map.containsKey(root.val)){
            map.put(root.val, new HashSet<>());
        }

        Set<Integer> set = map.get(root.val);
        if(parent != 0){
            set.add(parent);
        }
        if(root.left != null){
            set.add(root.left.val);
        }
        if(root.right != null){
            set.add(root.right.val);
        }

        convert(root.left, root.val, map);
        convert(root.right, root.val, map);
    }

    /**
     * Approach using DFS:
     * 1. Use DFS to traverse through the binary tree.
     * 2. Keep track of the maximum distance (time) required for infection to spread.
     * @param root - The root of the binary tree.
     * @param start - The value of the node where the infection starts.
     * @return The maximum time needed for the entire tree to be infected.
     */
    private int maxDistance = 0;  // To store the maximum distance.

    public int amountOfTime(TreeNode root, int start) {
        sol(root, start);  // Call the recursive function to solve the problem.
        return maxDistance;
    }

    /**
     * Recursive function to determine the time needed for infection to spread.
     * @param root - Current node in the tree.
     * @param start - The value of the node where the infection starts.
     * @return Depth of the node if the node is not infected, otherwise return -1.
     */
    public int sol(TreeNode root, int start){
        int depth = 0;
        if(root == null) return depth;

        int leftDepth = sol(root.left, start);
        int rightDepth = sol(root.right, start);

        if(root.val == start){
            maxDistance = Math.max(leftDepth, rightDepth);
            depth = -1;  // Marking the infected node with depth -1.
        } else if(leftDepth >= 0 && rightDepth >= 0){
            depth = Math.max(leftDepth, rightDepth) + 1;
        } else {
            // Calculate the distance from the infected node.
            int dis = Math.abs(leftDepth) + Math.abs(rightDepth);
            maxDistance = Math.max(maxDistance, dis);
            depth = Math.min(leftDepth, rightDepth) - 1;
        }
        return depth;
    }
}
