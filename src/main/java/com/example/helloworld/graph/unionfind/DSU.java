package com.example.helloworld.graph.unionfind;

import java.util.Arrays;

public class DSU {
    private int[] parent;

    public DSU(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);        // -1 means , this is the parent of this disjoint set
    }

    // Find with path compression
    public int find(int x) {
        if (parent[x] == -1) return x;
        return parent[x] = find(parent[x]);         // path compression
    }

    // Union
    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false; // Already in the same set

        parent[py] = px;
        return true;
    }

}

