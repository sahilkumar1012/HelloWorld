package com.example.helloworld.graph.dfs;

import java.util.List;
import java.util.Stack;

public class KeysAndRooms {
    int n;
    boolean[] visited;
    int vCount;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        n = rooms.size();
        visited = new boolean[n];
        vCount = 0;

        dfs(rooms, 0);

        return vCount == n;
    }
    // or apply dfs using stack.
    public void dfs(List<List<Integer>> rooms, int room){
        visited[room] = true;
        vCount++;

        for(Integer v : rooms.get(room)){
            if(visited[v] == false)
                dfs(rooms, v);
        }
    }


    /**
     * solution using dfs using stack.
     */
    public boolean canVisitAllRoomsStackSolution(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack();
        stack.push(0);

        //At the beginning, we have a to-do list "stack" of keys to use.
        //'seen' represents at some point we have entered this room.
        while (!stack.isEmpty()) { // While we have keys...
            int node = stack.pop(); // Get the next key 'node'
            for (int nei: rooms.get(node)) // For every key in room # 'node'...
                if (!seen[nei]) { // ...that hasn't been used yet
                    seen[nei] = true; // mark that we've entered the room
                    stack.push(nei); // add the key to the to-do list
                }
        }

        for (boolean v: seen)  // if any room hasn't been visited, return false
            if (!v) return false;
        return true;
    }

}
