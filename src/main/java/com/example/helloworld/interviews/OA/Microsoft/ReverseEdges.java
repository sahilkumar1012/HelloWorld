package com.example.helloworld.interviews.OA.Microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * problem 1
 *
 *  * A country can be represented as a graph with g_nodes cities connected by g_nodes - 1 uni-directional edges. The i^th edge connects cities g_from[i] and g_to[i].
 *  *
 *  * If the roads were bi-directional, every node would be reachable from every other node. The resulting graph would be a tree.
 *  *
 *  * For each city i (1 <= i <= g_nodes), find the minimum number of edges that must be reversed so that it is possible to travel from city i to any other city using the directed edges.
 *  *
 *  * Example
 *  * g_nodes = 4
 *  * g_edges = 3
 *  * g_from = [1, 2, 3]
 *  * g_to = [4, 4, 4]
 *  *
 *  * For node 1, reverse edges: [[2, 4], [3, 4]] (2 edges)
 *  * For node 2, reverse edges: [[1, 4], [3, 4]] (2 edges)
 *  * For node 3, reverse edges: [[1, 4], [2, 4]] (2 edges)
 *  * For node 4, reverse all edges (3 edges)
 *  * Return: [2, 2, 2, 3]
 *  *
 *  * Function Description
 *  * Complete the function countReverseEdges in the editor with the following parameters:
 *  * int g_nodes: the number of nodes
 *  * int g_edges: the number of edges in the graph
 *  * int g_from[g_edges]: the origin node of each directed edge
 *  * int g_to[g_edges]: the terminal node of each directed edge
 *  *
 *  * Returns
 *  * int[g_nodes]: the i^th integer is the minimum number of edges to reverse so that every other node is reachable from the i^th node.
 */
public class ReverseEdges {


    /*
     * Complete the 'countReverseEdges' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts UNWEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i].
     *
     */

    public static List<Integer> countReverseEdges(int gNodes, List<Integer> gFrom, List<Integer> gTo) {
        // Build adjacency list with direction info
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 1; i <= gNodes; i++) adj.put(i, new ArrayList<>());

        for (int i = 0; i < gFrom.size(); i++) {
            int u = gFrom.get(i);
            int v = gTo.get(i);
            adj.get(u).add(new int[]{v, 0}); // original direction
            adj.get(v).add(new int[]{u, 1}); // reverse direction (count as 1 if we need to reverse)
        }

        int[] result = new int[gNodes + 1];
        boolean[] visited = new boolean[gNodes + 1];

        // Step 1: Count reversals needed starting from node 1
        result[1] = dfsCount(1, adj, visited);

        // Step 2: Use rerooting to calculate result for all nodes
        Arrays.fill(visited, false);
        reroot(1, adj, visited, result, gNodes);

        List<Integer> resList = new ArrayList<>();
        for (int i = 1; i <= gNodes; i++) {
            resList.add(result[i]);
        }
        return resList;
    }

    private static int dfsCount(int node, Map<Integer, List<int[]>> adj, boolean[] visited) {
        visited[node] = true;
        int count = 0;
        for (int[] neighbor : adj.get(node)) {
            int next = neighbor[0];
            int rev = neighbor[1];
            if (!visited[next]) {
                count += rev + dfsCount(next, adj, visited);
            }
        }
        return count;
    }

    private static void reroot(int node, Map<Integer, List<int[]>> adj, boolean[] visited, int[] result, int n) {
        visited[node] = true;
        for (int[] neighbor : adj.get(node)) {
            int next = neighbor[0];
            int rev = neighbor[1];
            if (!visited[next]) {
                // if edge is in original direction, moving root to child increases reversal by 1
                // if edge is reversed, moving root to child decreases reversal by 1
                result[next] = result[node] + (rev == 0 ? 1 : -1);
                reroot(next, adj, visited, result, n);
            }
        }
    }



}

