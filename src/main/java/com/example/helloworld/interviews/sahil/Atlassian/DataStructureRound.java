package com.example.helloworld.interviews.sahil.Atlassian;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * content id ,
 *
 *
 * Imagine you are given a stream of content ids along with an associated action to be performed on them.
 * Example of contents are video, pages, posts etc. There can be two actions associated with a content id:
 * increasePopularity → increases the popularity of the content by 1. The popularity increases when someone comments on the content or likes the content
 * decreasePopularity → decreases the popularity of the content by 1. The popularity decreases when a spam bot's/users comments are deleted from the content or its likes are removed from the content
 *
 */

//[ id, popularity ]
class Solution11 {
    // 1-3
    // 2-3
    // map < content id , popularity > // 1, 3  | 1,4 | 1,3 | 1,2
    // maxheap [ (1,3) (2,3),
    public static void main(String[] args) {
        Solution11 o = new Solution11();

        o.increase(1); // 1 - 1
        o.decrease(1);
//        System.out.println(o.getMaxP());
        o.increase(2);
//        o.decrease(2);
        o.decrease(1);

        System.out.println("end " + o.getMaxP());
    }
    Map<Integer, Integer> popularity;
    PriorityQueue<int[]> pq;

    public Solution11(){
        popularity = new HashMap<>();
        pq = new PriorityQueue<>((a,b)-> {return b[1] - a[1];});
    }
    // time : O(N) - N = enteries / operations from the stream.
    public void increase(int contentid){
        popularity.put(contentid, popularity.getOrDefault(contentid, 0) + 1);
        pq.offer(new int[]{contentid, popularity.get(contentid)}); // Log(N)

    }
    public void decrease(int contentid){
        popularity.put(contentid, popularity.getOrDefault(contentid, 0) - 1);
        pq.offer(new int[]{contentid, popularity.get(contentid)});
    }

    // time O(number of increase & decreaase calls )
    // in worst case it can go O(N) , N operations / calls received before getMax.
    public int getMaxP(){
        while(!pq.isEmpty()){
            int[] top = pq.peek();
            int id = top[0];
            int pop = top[1];

            if(pop != popularity.get(id)){      // stale entry
                pq.poll();
                continue;
            }
            return id;
        }
        return 0;
    }

}
