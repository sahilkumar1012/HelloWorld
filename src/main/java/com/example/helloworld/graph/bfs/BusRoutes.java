package com.example.helloworld.graph.bfs;

import java.util.*;

/**
 * leetcode 815. Bus Routes
 *
 * You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.
 *
 * For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
 * You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.
 *
 * Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.
 *
 *
 *
 * Example 1:
 *
 * Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * Output: 2
 * Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
 * Example 2:
 *
 * Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 105
 * All the values of routes[i] are unique.
 * sum(routes[i].length) <= 105
 * 0 <= routes[i][j] < 106
 * 0 <= source, target < 106
 */
public class BusRoutes{
        public int numBusesToDestination(int[][] routes, int source, int target) {
            int n = routes.length;

            // Create a map to store bus stop numbers as keys and the buses going through each stop as values.
            Map<Integer, List<Integer>> map = new HashMap<>();

            // fill this map
            for (int i = 0; i < n; i++) { // Iterate through each bus.
                for (int j = 0; j < routes[i].length; j++) { // Iterate through each bus stop in the current bus.
                    int busStopNo = routes[i][j];
                    List<Integer> busNoList = map.getOrDefault(busStopNo, new ArrayList<>());
                    busNoList.add(i); // Add the current bus to the list of buses for this stop.
                    map.put(busStopNo, busNoList);
                }
            }

            // Use a queue for BFS traversal.
            Queue<Integer> q = new LinkedList<>();
            Set<Integer> busStopVis = new HashSet<>();
            Set<Integer> busVis = new HashSet<>();

            q.offer(source);
            busStopVis.add(source);
            int level = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    int currentStop = q.poll();

                    if (currentStop == target) {
                        return level;
                    }

                    // Process all buses that go through the current stop.
                    for (int bus : map.get(currentStop)) {
                        if (busVis.contains(bus)) continue; // Skip already visited buses.

                        int[] stops = routes[bus];
                        for (int stop : stops) {
                            if (busStopVis.contains(stop)) continue; // Skip already visited bus stops.
                            q.offer(stop);
                            busStopVis.add(stop);
                        }
                        busVis.add(bus);
                    }
                }
                level++;
            }

            // If no path is found between source and target, return -1.
            return -1;
        }

}

