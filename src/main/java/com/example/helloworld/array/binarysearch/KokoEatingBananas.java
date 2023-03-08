package com.example.helloworld.array.binarysearch;

/**
 * leetcode 875. Koko Eating Bananas
 *
 *Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 *
 *
 * Example 1:
 *
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * Example 2:
 *
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * Example 3:
 *
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 *
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i : piles)
            max = Math.max(max, i );

        // binary search on answer space
        int low = 1;
        int high = max;
        while(low < high){
            int mid = low + (high-low)/2;
            if( satify(piles, mid, h) ){
                high = mid;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

    // capicity  = mid per hour is sufficient or not?
    private boolean satify(int[] piles, int mid, int h){
        int k = 0;
        for(int pile : piles ){
            int t = (int) Math.ceil((double)pile/(double)mid );
            k += t;
        }
        return k<=h;
    }
}
