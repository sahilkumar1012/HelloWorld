package com.example.helloworld.design;

import java.util.*;

/**
 * leetcode 3508. Implement Router , Cisco interview Question
 *
 * code harony explanation video : https://youtu.be/slsa4SzzGXY
 *
 * Design a data structure that can efficiently manage data packets in a network router. Each data packet consists of the following attributes:
 *
 * source: A unique identifier for the machine that generated the packet.
 * destination: A unique identifier for the target machine.
 * timestamp: The time at which the packet arrived at the router.
 * Implement the Router class:
 *
 * Router(int memoryLimit): Initializes the Router object with a fixed memory limit.
 *
 * memoryLimit is the maximum number of packets the router can store at any given time.
 * If adding a new packet would exceed this limit, the oldest packet must be removed to free up space.
 * bool addPacket(int source, int destination, int timestamp): Adds a packet with the given attributes to the router.
 *
 * A packet is considered a duplicate if another packet with the same source, destination, and timestamp already exists in the router.
 * Return true if the packet is successfully added (i.e., it is not a duplicate); otherwise return false.
 * int[] forwardPacket(): Forwards the next packet in FIFO (First In First Out) order.
 *
 * Remove the packet from storage.
 * Return the packet as an array [source, destination, timestamp].
 * If there are no packets to forward, return an empty array.
 * int getCount(int destination, int startTime, int endTime):
 *
 * Returns the number of packets currently stored in the router (i.e., not yet forwarded) that have the specified destination and have timestamps in the inclusive range [startTime, endTime].
 * Note that queries for addPacket will be made in increasing order of timestamp.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * ["Router", "addPacket", "addPacket", "addPacket", "addPacket", "addPacket", "forwardPacket", "addPacket", "getCount"]
 * [[3], [1, 4, 90], [2, 5, 90], [1, 4, 90], [3, 5, 95], [4, 5, 105], [], [5, 2, 110], [5, 100, 110]]
 *
 * Output:
 * [null, true, true, false, true, true, [2, 5, 90], true, 1]
 *
 * Explanation
 *
 * Router router = new Router(3); // Initialize Router with memoryLimit of 3.
 * router.addPacket(1, 4, 90); // Packet is added. Return True.
 * router.addPacket(2, 5, 90); // Packet is added. Return True.
 * router.addPacket(1, 4, 90); // This is a duplicate packet. Return False.
 * router.addPacket(3, 5, 95); // Packet is added. Return True
 * router.addPacket(4, 5, 105); // Packet is added, [1, 4, 90] is removed as number of packets exceeds memoryLimit. Return True.
 * router.forwardPacket(); // Return [2, 5, 90] and remove it from router.
 * router.addPacket(5, 2, 110); // Packet is added. Return True.
 * router.getCount(5, 100, 110); // The only packet with destination 5 and timestamp in the inclusive range [100, 110] is [4, 5, 105]. Return 1.
 * Example 2:
 *
 * Input:
 * ["Router", "addPacket", "forwardPacket", "forwardPacket"]
 * [[2], [7, 4, 90], [], []]
 *
 * Output:
 * [null, true, [7, 4, 90], []]
 *
 * Explanation
 *
 * Router router = new Router(2); // Initialize Router with memoryLimit of 2.
 * router.addPacket(7, 4, 90); // Return True.
 * router.forwardPacket(); // Return [7, 4, 90].
 * router.forwardPacket(); // There are no packets left, return [].
 *
 *
 * Constraints:
 *
 * 2 <= memoryLimit <= 105
 * 1 <= source, destination <= 2 * 105
 * 1 <= timestamp <= 109
 * 1 <= startTime <= endTime <= 109
 * At most 105 calls will be made to addPacket, forwardPacket, and getCount methods altogether.
 * queries for addPacket will be made in increasing order of timestamp.
 *
 */
public class ImplementRouter {
}


class Router {
    private int memoryLimit;
    private Deque<int[]> queue; // FIFO packets
    private Set<String> packetSet; // for duplicate detection
    private Map<Integer, List<Integer>> destTimestamps; // dest -> all timestamps
    private Map<Integer, Integer> startIdx; // dest -> index pointer of first valid timestamp

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new ArrayDeque<>();
        this.packetSet = new HashSet<>();
        this.destTimestamps = new HashMap<>();
        this.startIdx = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (packetSet.contains(key)) return false; // duplicate

        // evict oldest if full
        if (queue.size() == memoryLimit) {
            int[] oldest = queue.pollFirst();
            String oldKey = oldest[0] + "#" + oldest[1] + "#" + oldest[2];
            packetSet.remove(oldKey);

            // increment pointer for that destination
            startIdx.put(oldest[1], startIdx.get(oldest[1]) + 1);
        }

        queue.offerLast(new int[]{source, destination, timestamp});
        packetSet.add(key);

        destTimestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        startIdx.putIfAbsent(destination, 0);
        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[]{};
        int[] packet = queue.pollFirst();
        String key = packet[0] + "#" + packet[1] + "#" + packet[2];
        packetSet.remove(key);

        // increment pointer for that destination
        startIdx.put(packet[1], startIdx.get(packet[1]) + 1);
        return packet;
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destTimestamps.containsKey(destination)) return 0;
        List<Integer> list = destTimestamps.get(destination);
        int start = startIdx.getOrDefault(destination, 0);

        // if all timestamps for this destination are already forwarded/evicted
        if (start >= list.size()) return 0;

        int left = lowerBound(list, start, startTime);
        int right = upperBound(list, start, endTime);
        return right - left;
    }

    // lowerBound: first index >= target
    private int lowerBound(List<Integer> list, int from, int target) {
        int l = from, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) >= target) r = m;
            else l = m + 1;
        }
        return l;
    }

    // upperBound: first index > target
    private int upperBound(List<Integer> list, int from, int target) {
        int l = from, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) > target) r = m;
            else l = m + 1;
        }
        return l;
    }
}
