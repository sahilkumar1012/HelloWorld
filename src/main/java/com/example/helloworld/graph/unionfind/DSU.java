package com.example.helloworld.graph.unionfind;

import java.util.Arrays;

public class DSU {
    private int[] parent;
    private int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];      // by default all 0
        Arrays.fill(parent, -1);        // -1 means , this is the parent of this disjoint set
    }

    // Find with path compression
    public int find(int x) {
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }

    // Union by rank
    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false; // Already in the same set

        // Union by rank
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
        return true;
    }

}

