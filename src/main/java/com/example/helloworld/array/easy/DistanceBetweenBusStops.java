package com.example.helloworld.array.easy;

/**
 * leetcode 1184. Distance Between Bus Stops
 *
 * A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring
 * stops where distance[i] is the distance between the stops number i and (i + 1) % n.
 *
 * The bus goes along both directions i.e. clockwise and counterclockwise.
 *
 * Return the shortest distance between the given start and destination stops.
 *
 */
public class DistanceBetweenBusStops {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start > destination)
            return distanceBetweenBusStops(distance, destination, start);

        int sumRange = 0;
        for(int i=start; i<destination; ++i)
            sumRange += distance[i];

        int sumLeft = 0;
        while(--start >= 0){
            sumLeft += distance[start];
        }
        while(destination < distance.length){
            sumLeft += distance[destination++];
        }

        return Math.min(sumRange, sumLeft);
    }
}
