package com.example.helloworld.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 1462. Course Schedule IV , Microsoft Uber
 *
 * Topic : Floyd Warshall Algorithm , to find all pairs shortest path ( APSP )
 *
 * Code harmony video explanation : https://youtu.be/2IoIbMvYGcQ
 *
 * My LeetCode solution : https://leetcode.com/problems/course-schedule-iv/solutions/6335077/easy-to-understand-graph-theory-floyd-wa-t8qq
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course ai first if you want to take course bi.
 *
 * For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1.
 * Prerequisites can also be indirect. If course a is a prerequisite of course b, and course b is a prerequisite of course c, then course a is a prerequisite of course c.
 *
 * You are also given an array queries where queries[j] = [uj, vj]. For the jth query, you should answer whether course uj is a prerequisite of course vj or not.
 *
 * Return a boolean array answer, where answer[j] is the answer to the jth query.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
 * Output: [false,true]
 * Explanation: The pair [1, 0] indicates that you have to take course 1 before you can take course 0.
 * Course 0 is not a prerequisite of course 1, but the opposite is true.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]
 * Output: [false,false]
 * Explanation: There are no prerequisites, and each course is independent.
 * Example 3:
 *
 *
 * Input: numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
 * Output: [true,true]
 *
 *
 * Constraints:
 *
 * 2 <= numCourses <= 100
 * 0 <= prerequisites.length <= (numCourses * (numCourses - 1) / 2)
 * prerequisites[i].length == 2
 * 0 <= ai, bi <= numCourses - 1
 * ai != bi
 * All the pairs [ai, bi] are unique.
 * The prerequisites graph has no cycles.
 * 1 <= queries.length <= 104
 * 0 <= ui, vi <= numCourses - 1
 * ui != vi
 */
public class CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {

        // Initialize a boolean matrix to store prerequisite relationships
        boolean[][] isPre = new boolean[n][n];
        for (int[] p : prerequisites) {
            // Mark direct prerequisite relationships
            isPre[p[0]][p[1]] = true;
        }

        // Use Floyd-Warshall algorithm to compute transitive closure
        // This identifies indirect prerequisites
        for (int k = 0; k < n; k++) { // Intermediate node
            for (int i = 0; i < n; i++) { // Start node
                for (int j = 0; j < n; j++) { // End node
                    // If i -> k and k -> j, then i -> j
                    isPre[i][j] = isPre[i][j] || (isPre[i][k] && isPre[k][j]);
                }
            }
        }

        // Prepare the result for the queries
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            // Check if the prerequisite relationship exists for the query
            ans.add(isPre[q[0]][q[1]]);
        }
        return ans; // Return the list of results for all queries
    }

}
