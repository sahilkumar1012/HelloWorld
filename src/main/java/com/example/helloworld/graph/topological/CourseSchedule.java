package com.example.helloworld.graph.topological;

import java.util.ArrayList;

/**
 * leetcode 207. Course Schedule
 * reference : DetectCycleInDirectedGraph.java
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique
 */
public class CourseSchedule {

    // if cycle present in this directed graph
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return hasCycle(numCourses, prerequisites) == false;
    }

    private boolean hasCycle(int numCourses, int[][] prerequisites){

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : prerequisites){
            adj.get(e[0]).add(e[1]);
        }

        System.out.println(adj);

        boolean[] visited = new boolean[numCourses];
        boolean[] currVisited = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!visited[i] && cycle(i, visited, currVisited, adj)){
                return true;
            }
        }

        return false;   // no cycle in this directed graph.
    }

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
