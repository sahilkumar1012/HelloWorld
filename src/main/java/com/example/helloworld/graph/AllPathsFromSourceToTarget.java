package com.example.helloworld.graph;

import java.util.*;

/**
 * leetcode 797. All Paths From Source to Target
 *
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 *
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Example 2:
 *
 *
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * Example 3:
 *
 * Input: graph = [[1],[]]
 * Output: [[0,1]]
 * Example 4:
 *
 * Input: graph = [[1,2,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,2,3],[0,3]]
 * Example 5:
 *
 * Input: graph = [[1,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,3]]
 *
 *
 * Constraints:
 *
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i (i.e., there will be no self-loops).
 * All the elements of graph[i] are unique.
 * The input graph is guaranteed to be a DAG.
 */
public class AllPathsFromSourceToTarget {

    List<List<Integer>> res;

    /**
     * DFS solution
     * @param graph
     * @return All paths from source to destination
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);

        // perform DFS
        solve(graph, temp, 0);

        return res;
    }

    private void solve(int[][] graph, List<Integer> temp, int lastNode){
        if(lastNode == graph.length-1)
            res.add( new ArrayList<>(temp));

        for(int link : graph[lastNode]){
            temp.add(link);
            solve(graph, temp, link);
            temp.remove(temp.size()-1);
        }
    }


    /**
     * Solution using BFS, slower than the other solution using DFS.
     * @param graph
     * @return All paths from source to destination
     */
    public List<List<Integer>> allPathsSourceTargetBFS(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        int startIndex = 0;
        int endIndex = graph.length - 1;
        Queue<List<Integer>> qu = new LinkedList<>();

        qu.add(Arrays.asList(startIndex));

        while (!qu.isEmpty()) {
            int size =qu.size();
            while(size-->0) {
                List<Integer> headList = qu.poll();

                if (headList.get(headList.size() - 1) == endIndex)
                {
                    ans.add(headList);
                }
                int lastnode = headList.get(headList.size() - 1);
                for (int connection : graph[lastnode]) {
                    List<Integer> copyList = new ArrayList<>(headList);
                    copyList.add(connection);
                    qu.add(copyList);
                }
            }
        }

        return ans;
    }

}
