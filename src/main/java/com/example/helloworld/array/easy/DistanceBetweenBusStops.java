package com.example.helloworld.array.easy;

/**
 * Leetcode 1184. Distance Between Bus Stops
 *
 * Problem Statement:
 * A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring
 * stops, where distance[i] is the distance between the stops number i and (i + 1) % n.
 *
 * The bus goes in both directions: clockwise and counterclockwise.
 *
 * The goal is to return the shortest distance between the given start and destination stops.
 */
public class DistanceBetweenBusStops {

    /**
     * Calculate the shortest distance between the start and destination bus stops.
     *
     * @param distance An array where distance[i] represents the distance between stop i and stop (i + 1) % n.
     * @param start    The starting bus stop.
     * @param destination The destination bus stop.
     * @return The shortest distance between the start and destination stops.
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        // If the start stop is greater than the destination stop, swap them.
        // This simplifies the calculations, as we can always calculate distance
        // in a clockwise direction from the lower index to the higher index.
        if (start > destination) {
            return distanceBetweenBusStops(distance, destination, start);
        }

        // Initialize the total distance for the clockwise route from start to destination.
        int sumRange = 0;
        // Calculate the sum of distances from 'start' to 'destination'.
        for (int i = start; i < destination; ++i) {
            sumRange += distance[i]; // Accumulate distances in the clockwise direction.
        }

        // Initialize the total distance for the counterclockwise route.
        int sumLeft = 0;

        // Calculate the distance in the counterclockwise direction from destination to start.
        // First, move left from the 'start' stop to the first stop (i.e., 0).
        // This loop continues until we reach the first stop, summing the distances along the way.
        while (--start >= 0) {
            sumLeft += distance[start]; // Accumulate distances while moving counterclockwise.
        }

        // Then, add the distances from the last stop back to the 'destination' stop.
        // This continues until we reach the destination stop in a counterclockwise direction.
        while (destination < distance.length) {
            sumLeft += distance[destination++]; // Accumulate distances until we reach the destination.
        }

        // Return the minimum distance between the clockwise and counterclockwise distances.
        return Math.min(sumRange, sumLeft);
    }
}
