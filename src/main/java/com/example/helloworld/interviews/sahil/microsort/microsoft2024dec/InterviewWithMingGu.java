package com.codility;

// you can also use imports, for example:
import java.util.*;

class Solution {

    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
        /*
        0 - 1
        1 -
        2 - 0

        */
        List<List<Integer>> adj = new ArrayList<>();
        ArrayList list = new ArrayList<>();
        list.add(1);
        adj.add(list);
        adj.add(new ArrayList<>());

        Solution s = new Solution();
        int[] res = s.topo(adj);
        for(int val : res){
            System.out.println(val);
        }

        // printing result
    }
    // u -> v       b - {c,d}
//      <key , list>
/*
a - {b}
b - {c,d}
c - {e};
d - {};
e - {}


stack:


c
e


0,1,2,3,4
*/
    List<List<Integer>> adj;

    private int[] topo(List<List<Integer>> adj){
        int n = adj.size();
        this.adj = adj;
        boolean[] visited = new boolean[n];

        Stack<Integer> stack = new Stack<>();

        // initiate dfs from every non visited node
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, visited, stack);
            }
        }
        int[] ans = new int[n];

        for(int i=stack.size()-1; i>=0; i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
    private void dfs(int u, boolean[] visited, Stack<Integer> s){
        visited[u] = true;
        // proceed with this dfs.
        for(int v : adj.get(u)){
            if(!visited[v]){
                dfs(v, visited, s);
            }
        }
        s.push(u);
    }
}

/**
 a->b

 b->c
 b->d

 c->e

 {a,b,c,d,e}

 [a,b,c]
 [d]


 nodes with dependency.

 do topological sorting.

 1. preparing adj list
 2. perform dfs.


 */
