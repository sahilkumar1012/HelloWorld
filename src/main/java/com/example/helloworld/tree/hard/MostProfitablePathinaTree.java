package com.example.helloworld.tree.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * leetcode 2467. Most Profitable Path in a Tree
 *
 * code harmony video explanation : https://youtu.be/ngTRBEr7z2g
 *
 * my leetcode solution : https://leetcode.com/problems/most-profitable-path-in-a-tree/solutions/6461002/easy-explanation-tree-dfs-java-c-python-detailed-video-explanation
 *
 *
 * There is an undirected tree with n nodes labeled from 0 to n - 1, rooted at node 0. You are given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
 *
 * At every node i, there is a gate. You are also given an array of even integers amount, where amount[i] represents:
 *
 * the price needed to open the gate at node i, if amount[i] is negative, or,
 * the cash reward obtained on opening the gate at node i, otherwise.
 * The game goes on as follows:
 *
 * Initially, Alice is at node 0 and Bob is at node bob.
 * At every second, Alice and Bob each move to an adjacent node. Alice moves towards some leaf node, while Bob moves towards node 0.
 * For every node along their path, Alice and Bob either spend money to open the gate at that node, or accept the reward. Note that:
 * If the gate is already open, no price will be required, nor will there be any cash reward.
 * If Alice and Bob reach the node simultaneously, they share the price/reward for opening the gate there. In other words, if the price to open the gate is c, then both Alice and Bob pay c / 2 each. Similarly, if the reward at the gate is c, both of them receive c / 2 each.
 * If Alice reaches a leaf node, she stops moving. Similarly, if Bob reaches node 0, he stops moving. Note that these events are independent of each other.
 * Return the maximum net income Alice can have if she travels towards the optimal leaf node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: edges = [[0,1],[1,2],[1,3],[3,4]], bob = 3, amount = [-2,4,2,-4,6]
 * Output: 6
 * Explanation:
 * The above diagram represents the given tree. The game goes as follows:
 * - Alice is initially on node 0, Bob on node 3. They open the gates of their respective nodes.
 *   Alice's net income is now -2.
 * - Both Alice and Bob move to node 1.
 *   Since they reach here simultaneously, they open the gate together and share the reward.
 *   Alice's net income becomes -2 + (4 / 2) = 0.
 * - Alice moves on to node 3. Since Bob already opened its gate, Alice's income remains unchanged.
 *   Bob moves on to node 0, and stops moving.
 * - Alice moves on to node 4 and opens the gate there. Her net income becomes 0 + 6 = 6.
 * Now, neither Alice nor Bob can make any further moves, and the game ends.
 * It is not possible for Alice to get a higher net income.
 * Example 2:
 *
 *
 * Input: edges = [[0,1]], bob = 1, amount = [-7280,2350]
 * Output: -7280
 * Explanation:
 * Alice follows the path 0->1 whereas Bob follows the path 1->0.
 * Thus, Alice opens the gate at node 0 only. Hence, her net income is -7280.
 *
 *
 * Constraints:
 *
 * 2 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * edges represents a valid tree.
 * 1 <= bob < n
 * amount.length == n
 * amount[i] is an even integer in the range [-104, 104].
 *
 *
 */
public class MostProfitablePathinaTree {
    ArrayList<Integer>[] adj; // Adjacency list representation of the graph
    Map<Integer, Integer> bobPath; // Stores the path of Bob with time taken to reach each node
    int max = Integer.MIN_VALUE; // Stores the maximum profit Alice can collect
    int[] amount; // Stores the profit associated with each node
    boolean[] visited; // Tracks visited nodes to prevent cycles

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        // Prepare adjacency list
        int n = amount.length;
        bobPath = new HashMap<Integer, Integer>();
        this.amount = amount;
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++)
            adj[i] = new ArrayList<Integer>();

        visited = new boolean[n];

        // Build the adjacency list from edges
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        // Find Bob's path to node 0
        bobPath(bob, 0); // Starting node of Bob, time initialized to 0

        // Find Alice's maximum profit path
        Arrays.fill(visited, false); // Reset visited array
        alice(0, 0, 0); // Start Alice from node 0

        return max; // Return the maximum profit Alice can achieve
    }

    private boolean bobPath(int node, int time) {
        visited[node] = true;
        bobPath.put(node, time); // Store the time Bob reaches this node

        if(node == 0) { // If Bob reaches node 0, return true
            return true;
        }

        // Traverse neighbors to find a path to node 0
        for(int nei : adj[node]) {
            if(!visited[nei] && bobPath(nei, time + 1)) {
                return true;
            }
        }

        // Undo the path if not leading to node 0
        bobPath.remove(node);
        return false;
    }

    // DFS to calculate maximum income for Alice
    private void alice(int node, int time, int income) {
        visited[node] = true;

        // If Alice reaches first, collect full amount
        if(!bobPath.containsKey(node) || time < bobPath.get(node)) {
            income += amount[node];
        }
        // If both reach at the same time, collect half the amount
        else if(time == bobPath.get(node)) {
            income += amount[node] / 2;
        }

        // If leaf node (not root), update max profit
        if(adj[node].size() == 1 && node != 0) {
            max = Math.max(max, income);
        }

        // Recur for all unvisited neighbors
        for(int nei : adj[node]) {
            if(!visited[nei]) {
                alice(nei, time + 1, income);
            }
        }
    }

}
