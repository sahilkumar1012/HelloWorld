package com.example.helloworld.dump;

import com.example.helloworld.tree.model.TreeNode;

import java.util.*;

class SolutionShit {
    public static void main(String[] args) {
        int[] heights = new int[] {4,2,7,6,9,14,12} ;
        new SolutionShit().furthestBuilding(heights, 5, 1);
    }
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        int[] diff= new int[n];
        for(int i=1;i<n;i++){
            diff[i] = heights[i] - heights[i - 1] < 0 ? 0 : heights[i] - heights[i-1];
        }
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i=0;i<n;i++){
            if(diff[i]==0){
                continue;
            }
            if(ladders>0){
                ladders--;
                pq.add(diff[i]);
            }
            else
            {
                pq.add(diff[i]);
                int temp = pq.poll();
                if(temp > bricks)
                    return i-1;
                else
                    bricks=bricks-temp;
            }
        }
        return n-1;
    }
}