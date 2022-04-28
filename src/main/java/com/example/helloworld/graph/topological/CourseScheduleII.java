package com.example.helloworld.graph.topological;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * leetcode 210. Course Schedule II | topological sort standard problem
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 */
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;

        // prepare the adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : prerequisites){
            adj.get(e[0]).add(e[1]);
        }

        // edge case | no solution present if loop in this directed graph
        if( hasCycle(n, adj) ) return new int[0];

        // topological sort code (using dfs)
        Deque<Integer> stack = new ArrayDeque<>();      /// java suggesting using Deque instead of Stack
        boolean visited[] = new boolean[n];

        for(int i=0; i<n ;i++){
            if( !visited[i] ){
                topo(i, adj, visited, stack);
            }
        }

        int[] ans = new int[stack.size()];
        for(int i=ans.length-1; i>=0; i--){
            ans [i] = stack.pop();
        }
        return ans;
    }

    private void topo(int s, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Deque<Integer> stack){
        visited[s] = true;
        for(int i : adj.get(s) ){
            if( !visited[i] ){
                topo(i, adj, visited, stack);
            }
        }
        stack.push(s);
    }

    /** detect cycle in directed graph
     *
     * @param numCourses number of nodes in graph for n : [0 .... n-1]
     * @param adj adjacency list, representing directed graph
     * @return
     */
    private boolean hasCycle(int numCourses, ArrayList<ArrayList<Integer>> adj){

        boolean[] visited = new boolean[numCourses];
        boolean[] currVisited = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!visited[i] && cycle(i, visited, currVisited, adj)){
                return true;
            }
        }

        return false;   // no cycle present in this directed graph.
    }
             // logic to detect cycle in directed graph
    private boolean cycle(int s, boolean[] visited, boolean[] currVisited, ArrayList<ArrayList<Integer>> adj){
        visited[s] = true;
        currVisited[s] = true;

        for( int i : adj.get(s) ){
            if(!visited[i] && cycle(i, visited, currVisited, adj)){
                return true;
            }else if (visited[i] && currVisited[i]){
                return true;
            }
        }

        return currVisited[s] = false;
    }
}
