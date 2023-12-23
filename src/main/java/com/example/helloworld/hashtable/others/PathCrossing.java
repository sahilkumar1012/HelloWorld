package com.example.helloworld.hashtable.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 1496. Path Crossing
 * https://leetcode.com/problems/path-crossing/
 *
 * Problem Description:
 * Given a string path, which consists of characters 'N', 'S', 'E', or 'W' representing
 * movements (north, south, east, or west) respectively. The starting point is at (0, 0)
 * on a 2D plane. Determine if the path crosses itself at any point.
 */
public class PathCrossing {

    /**
     * Check if the given path crosses itself at any point.
     *
     * @param path A string representing the movements 'N', 'S', 'E', or 'W'.
     * @return true if the path crosses itself, false otherwise.
     */
    public boolean isPathCrossing(String path) {

        // Create a map to store the movements for each direction.
        Map<Character, int[]> map = new HashMap<>();
        map.put('E', new int[]{1,0});  // East: Move right (increase x-coordinate).
        map.put('W', new int[]{-1,0}); // West: Move left (decrease x-coordinate).
        map.put('N', new int[]{0,1});  // North: Move up (increase y-coordinate).
        map.put('S', new int[]{0,-1}); // South: Move down (decrease y-coordinate).

        // Initial position at origin (0, 0).
        int x = 0, y = 0;

        // Set to keep track of visited coordinates.
        Set<String> visited = new HashSet<>();
        visited.add("" + x + "-" + y); // Mark the starting point as visited.

        // Traverse the path and update the coordinates.
        for(char ch : path.toCharArray()){
            int[] d = map.get(ch); // Get the direction movement.
            x = x + d[0];          // Update x-coordinate.
            y = y + d[1];          // Update y-coordinate.

            String key = ""+x+"-"+y; // Create a unique key for the current position.

            // If the current position has been visited before, return true.
            if(visited.contains(key)){
                return true;
            }

            // Mark the current position as visited.
            visited.add(key);
        }

        // If the path doesn't cross itself, return false.
        return false;
    }
}
