package com.example.helloworld.graph;


import java.util.Arrays;

/**
 * leetcode 1319. Number of Operations to Make Network Connected
 *
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.
 *
 * You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.
 *
 * Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4, connections = [[0,1],[0,2],[1,2]]
 * Output: 1
 * Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
 * Example 2:
 *
 *
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * Output: 2
 * Example 3:
 *
 * Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * Output: -1
 * Explanation: There are not enough cables.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 105
 * 1 <= connections.length <= min(n * (n - 1) / 2, 105)
 * connections[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * There are no repeated connections.
 * No two computers are connected by more than one cable.
 */
class UnionFind {
    int[] father;
    int n;      // connected components
    public UnionFind(int n) {
        this.n = n-1;       // total nodes if all are connected
        father = new int[n];
        Arrays.fill(father, -1);
    }
    public int find(int x) {
        if (father[x] == -1) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            father[a] = b;
            n--;
        }
    }
}

public class NumberofOperationstoMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        if (m < n - 1) {
            return -1;
        }
        UnionFind uf = new UnionFind(n);
        for (int[] con : connections) {
            uf.union(con[0], con[1]);
        }
        return uf.n;
    }
}

