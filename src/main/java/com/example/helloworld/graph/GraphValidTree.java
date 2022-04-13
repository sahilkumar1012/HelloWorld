package com.example.helloworld.graph;

import java.util.Arrays;

/**
 * leetcode 261. Graph Valid Tree
 *
 * You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
 *
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
 * Output: true
 * Example 2:
 *
 *
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= n <= 2000
 * 0 <= edges.length <= 5000
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * There are no self-loops or repeated edges.
 */
public class GraphValidTree {

    class UnionFind{
        int[] father;
        int n;              // n-1 edges are required to make this graph fully connected with no loops.

        public UnionFind(int n){
            this.n = n-1;       // to make it a single connected graph with no loops
            father = new int[n];
            Arrays.fill(father, -1);
        }
        public int find(int x){
            if(father[x] == -1){
                return x;
            }
            return father[x] = find(father[x]);     // pruning
        }
        public boolean union(int a, int b){
            a = find(a);
            b = find(b);
            if(a != b){
                n--;    // using one edge
                father[a] = b;
                return true;        // this edge will cause loop, so not a valid tree.
            }
            return false;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            if( uf.union(edge[0], edge[1]) == false){      // same parent.
                return false;
            }
        }
        return uf.n == 0;
    }
}