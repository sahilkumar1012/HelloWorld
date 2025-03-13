package com.example.helloworld.interviews.sahil.uber;

import java.util.PriorityQueue;

public class DSARound1Mar25 {
}


// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.core.JsonProcessingException;

// Main class should be named 'Solution' and should not be public.
/*
// Design and implement a Consumer that monitors the asynchronous reception of packets during a large data transfer. The consumer must support two primary operations:

// 1. PackageReceived(PacketID) – Records the reception of a packet with a given `PacketID`.
// 2. GetMinimumMissingPacket() – Returns the smallest `PacketID` that has not yet been received.

set[] - received packages

priority queue [received packages in order] - min.

[0, n-1]

1 2 3 _ 5 _ 7 _ _ 10



// Requirements:

// - Assume packets arrive asynchronously in arbitrary order.
// - The system is responsible for receiving large number of packets.
// - At any given point, the consumer must be able to determine the smallest missing PacketID that has yet to be received.
// - Every packet within the range [0, N-1] will be received at least once, but not necessarily in order
// - The program is long-running, meaning it must have optimal space and time complexity for entire execution.


// PackageReceived(0)
// PackageReceived(2)
// GetMinimumMissingPacket() -> 1
// PackageReceived(1)
// GetMinimumMissingPacket() -> 3
// PackageReceived(6)
// PackageReceived(4)
// GetMinimumMissingPacket() -> 3


[0,n-1] idx++ 0, 1, 2, 3 sum(m) = n

pq[0, n-1] - remove all the package received - log(n)
pq.peek();      O(1)

// PackageReceived(0)       [0]
// PackageReceived(2)       [0,2]
// GetMinimumMissingPacket() -> 1
// PackageReceived(1)           [0,2,1]
// GetMinimumMissingPacket() -> 3
// PackageReceived(6)           [0,2,1,6]
// PackageReceived(4)           [0,2,1,6,4]
// GetMinimumMissingPacket() -> 3


*/
class Solution {
    int N;
    PriorityQueue<Integer> pq;

    // preprocessing
    // O(NlogN) time
    // heap - complete binary tree -> heapify
    public Solution(int N){
        this.N = N;
        pq = new PriorityQueue<>();

        for(int i=0; i<=N-1; i++)
            pq.offer(i);
    }
    // O(log(N)) time / query
    public void packageReceived(int pId){
        if(pId <0 || pId >=N)
            System.out.println("Invalid package id - "+ pId);
        else{
            try{
                // if(pq is not locked, lock it )
                pq.remove(pId);
                // remove lock.
            }catch(Exception e){

            }
        }
    }
    // O(1) / query
    public int getMinimumMissingPacket(){
        if(pq.isEmpty()){
            System.out.println("No missing package."); return -1;
        }
        // if( pq is locked , wait)
        return pq.peek();
    }

    public static void main(String[] args){
        Solution o = new Solution(5);

        o.packageReceived(2);
        o.packageReceived(3);
        o.packageReceived(4);
        // o.packageReceived(6);

        System.out.println(o.getMinimumMissingPacket());
        o.packageReceived(0);
        System.out.println(o.getMinimumMissingPacket());
        o.packageReceived(1);
        System.out.println(o.getMinimumMissingPacket());
        o.packageReceived(5);
        System.out.println(o.getMinimumMissingPacket());
    }

}

