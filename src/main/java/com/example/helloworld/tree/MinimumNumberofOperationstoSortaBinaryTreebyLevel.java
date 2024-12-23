package com.example.helloworld.tree;

import com.example.helloworld.tree.model.TreeNode;

import java.util.*;

/**
 * leetcode 2471. Minimum Number of Operations to Sort a Binary Tree by Level       , tree, Amazon
 *
 * code harmony video explanation : https://youtu.be/wVZAZ-NBqQI
 *
 * my leetcode solution : https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/solutions/6177337/easy-to-understand-bfs-java-c-python-det-1h70
 *
 * You are given the root of a binary tree with unique values.
 *
 * In one operation, you can choose any two nodes at the same level and swap their values.
 *
 * Return the minimum number of operations needed to make the values at each level sorted in a strictly increasing order.
 *
 * The level of a node is the number of edges along the path between it and the root node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,4,3,7,6,8,5,null,null,null,null,9,null,10]
 * Output: 3
 * Explanation:
 * - Swap 4 and 3. The 2nd level becomes [3,4].
 * - Swap 7 and 5. The 3rd level becomes [5,6,8,7].
 * - Swap 8 and 7. The 3rd level becomes [5,6,7,8].
 * We used 3 operations so return 3.
 * It can be proven that 3 is the minimum number of operations needed.
 * Example 2:
 *
 *
 * Input: root = [1,3,2,7,6,5,4]
 * Output: 3
 * Explanation:
 * - Swap 3 and 2. The 2nd level becomes [2,3].
 * - Swap 7 and 4. The 3rd level becomes [4,6,5,7].
 * - Swap 6 and 5. The 3rd level becomes [4,5,6,7].
 * We used 3 operations so return 3.
 * It can be proven that 3 is the minimum number of operations needed.
 * Example 3:
 *
 *
 * Input: root = [1,2,3,4,5,6]
 * Output: 0
 * Explanation: Each level is already sorted in increasing order so return 0.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 105].
 * 1 <= Node.val <= 105
 * All the values of the tree are unique.
 */
public class MinimumNumberofOperationstoSortaBinaryTreebyLevel {

    /**
     * Calculates the minimum number of operations required to sort each level
     * of a binary tree when traversed level by level.
     * @param root The root node of the binary tree.
     * @return The minimum number of operations.
     */
    public int minimumOperations(TreeNode root) {
        if (root == null) return 0; // Base case: empty tree requires no operations.
        int ans = 0; // Total number of swaps required.

        // Queue for level order traversal.
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root); // Start with the root node.
        int levelNo = 0; // Track the level number (optional).

        // Perform level order traversal.
        while (!q.isEmpty()) {
            int len = q.size(); // Number of nodes at the current level.
            List<Integer> level = new ArrayList<>(); // List to store values at the current level.

            // Traverse all nodes at the current level.
            while (len-- > 0) {
                TreeNode node = q.poll(); // Remove the front node from the queue.
                level.add(node.val); // Add the node's value to the level list.

                // Add the left and right children (if any) to the queue for the next level.
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            // Count the number of swaps required to sort the current level.
            ans += countSwaps(level);

            // Finished processing this level.
            levelNo++;
        }

        return ans; // Return the total number of swaps.
    }

    /**
     * Calculates the minimum number of swaps required to sort a list of integers.
     * @param level The list of integers representing the values at a tree level.
     * @return The number of swaps required to sort the list.
     */
    public static int countSwaps(List<Integer> level) {
        int n = level.size();
        int swaps = 0;

        // Create a sorted version of the list.
        List<Integer> sortedLevel = new ArrayList<>(level);
        Collections.sort(sortedLevel);

        // Map to store the indices of elements in the current list.
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(level.get(i), i);
        }

        // Iterate through the list to identify misplaced elements.
        for (int i = 0; i < n; i++) {
            // If the current element is not in its sorted position.
            if (!level.get(i).equals(sortedLevel.get(i))) {
                // Find the correct index of the current element.
                int correctIndex = indexMap.get(sortedLevel.get(i));

                // Update the map to reflect the swap.
                indexMap.put(level.get(i), correctIndex);
                indexMap.put(level.get(correctIndex), i);

                // Swap the elements to place them correctly.
                Collections.swap(level, i, correctIndex);
                swaps++; // Increment the swap count.
            }
        }

        return swaps; // Return the total number of swaps.
    }

    /**
     * An alternative method to calculate the number of swaps required to sort a list of integers.
     * This method uses O(N^2) time complexity and may result in TLE (Time Limit Exceeded).
     * @param level The list of integers representing the values at a tree level.
     * @return The number of swaps required to sort the list.
     */
    public static int countSwapsN2(List<Integer> level) {
        int n = level.size();
        int swaps = 0;

        // Create a sorted version of the list.
        List<Integer> sortedLevel = new ArrayList<>(level);
        Collections.sort(sortedLevel);

        // Iterate through the list to identify misplaced elements.
        for (int i = 0; i < n; i++) {
            // If the current element is not in its sorted position.
            if (!level.get(i).equals(sortedLevel.get(i))) {
                // Find the correct index of the current element.
                int correctIndex = level.indexOf(sortedLevel.get(i));

                // Swap the elements to place them correctly.
                Collections.swap(level, i, correctIndex);
                swaps++; // Increment the swap count.
            }
        }
        return swaps; // Return the total number of swaps.
    }
}
