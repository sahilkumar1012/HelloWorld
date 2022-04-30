package com.example.helloworld.graph.dfs;

import java.util.*;

/**
 * leetcode 399. Evaluate Division
 * reference video:  https://youtu.be/UcDZM6Ap5P4
 *
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 *
 *
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 * Example 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 *
 * Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 *
 *
 * Constraints:
 *
 *     1 <= equations.length <= 20
 *     equations[i].length == 2
 *     1 <= Ai.length, Bi.length <= 5
 *     values.length == equations.length
 *     0.0 < values[i] <= 20.0
 *     1 <= queries.length <= 20
 *     queries[i].length == 2
 *     1 <= Cj.length, Dj.length <= 5
 *     Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */
public class EvaluateDivision {
    class Solution {
        class Node{
            public String dest;
            public double cost;
            public Node(String dest, double cost){
                this.dest = dest;
                this.cost = cost;
            }

        }
        Map<String, List<Node>> graph;

        // reference video for explanation : https://youtu.be/UcDZM6Ap5P4
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            graph = buildGraph(equations, values);

            double[] result = new double[queries.size()];
            for(int i=0; i<queries.size(); i++)
                result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());      // source to dest

            return result;
        }

        private double dfs(String src, String dest, Set<String> visited){
            if(!graph.containsKey(src) || !graph.containsKey(dest))
                return -1.0;
            if(src.equals(dest))
                return 1.0;

            visited.add(src);

            for(Node node : graph.get(src)){
                if(!visited.contains(node.dest)){
                    double ans = dfs(node.dest, dest, visited);
                    if(ans != -1.0)     // no worries, we're exploring all the possibilities
                        return ans * node.cost;
                }
            }
            return -1.0;
        }

        // building graph
        private Map<String, List<Node>> buildGraph( List<List<String>> equations, double[] values ){
            Map<String, List<Node>> g = new HashMap<>();

            for(int i=0; i < equations.size(); i++){
                String src = equations.get(i).get(0);
                String dest = equations.get(i).get(1);

                g.putIfAbsent(src, new ArrayList<Node>());
                g.putIfAbsent(dest, new ArrayList<Node>());

                g.get(src).add(new Node(dest, values[i]));
                g.get(dest).add(new Node(src, 1 / values[i]));
            }
            return g;
        }
    }
}
