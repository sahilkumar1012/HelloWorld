package com.example.helloworld.graph.unionfind;


import java.util.Arrays;

/**
 * leetcode 684. Redundant Connection , Disjoint Set Union ( DSU )
 *
 * Code Harmony Video Explanation : https://youtu.be/oHNaJFk6qdg
 *
 * Code Harmony Video on Disjoint Set union : https://youtu.be/Z5nvixnV158
 *
 * My leetcode solution : https://leetcode.com/problems/redundant-connection/solutions/6345504/easy-to-understand-100-faster-disjoint-set-union-detailed-video-explanation
 *
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 *
 * You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: edges = [[1,2],[1,3],[2,3]]
 * Output: [2,3]
 * Example 2:
 *
 *
 * Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
 * Output: [1,4]
 *
 *
 * Constraints:
 *
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ai < bi <= edges.length
 * ai != bi
 * There are no repeated edges.
 * The given graph is connected.
 *
 *
 *
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);

        for(int[] edge: edges){
            if( ! uf.union(edge[0]-1, edge[1]-1) ){
                return edge;
            }
        }

        return new int[]{};     // won't reach here as per problem.
    }

    static class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);        // no parent, single node currently in component, khud ka parent
        }

        public int find(int x) {
            if (parent[x] == -1) {
                return x;
            }
            return parent[x] = find(parent[x]);       // pruning , path compression
        }

        public boolean union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a != b) {
                parent[a] = b;
                return true;
            }
            return false;       // already connected | part of one component.
        }
    }

}

