package com.example.helloworld.dp;


/**
 * leetcode 42. Trapping Rain Water
 * code harmony video explanation : https://youtu.be/qsxiV7DGzEo
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 *
 * Note: do it in the linear time and constant space.
 */
public class TrappingRainWater {
    /**
     * first need to check the maximun height of the buliding.
     * fir left se right tak jaoge to maxRight already pata hai and maxLeft usi iteration mai iterate kar sakte hai hum.
     *
     * same right se left mai iterate karege to maxLeft is already known because of maxHeight
     * right se maxHeight tak wali iteration mai humm maxRight calculate karte rhege.
     */
    public int trap(int[] height) {

        int n = height.length;
        if(n==0)
            return 0;
        int res = 0;
        /*

        // this below solution is requiring linear space .
        int[] maxL = new int[n];
        int[] maxR = new int[n];

        maxL[0] = height[0];
        for(int i=1; i<n; ++i){
            maxL[i] = Math.max(maxL[i-1],height[i]);
        }

        maxR[n-1] = height[n-1];
        for(int i=n-2; i>=0; --i){
            maxR[i] = Math.max(maxR[i+1], height[i]);
        }

        for(int i=0; i<n; ++i){
            int sum = Math.min(maxR[i], maxL[i]) - height[i];
            if(sum > 0){
                res += sum;
            }
        }
        */
        int mh = -1, mhidx = -1;
        for(int i=0; i<n; ++i){
            if(height[i] > mh){
                mh = height[i]; mhidx = i;
            }
        }
        int result = 0,sum=0;

        int msf = height[0];
        for(int i=1; i<mhidx; ++i){
            sum = Math.min(msf, mh)  - height[i];
            if(sum > 0)
                result += sum;

            if(height[i] > msf)
                msf = height[i];
        }

        msf = height[n-1];
        for(int i=n-2; i>mhidx; --i){
            sum = Math.min(msf, mh) - height[i];
            if(sum > 0)
                result += sum;

            if(height[i] > msf)
                msf = height[i];
        }

        return result;
    }
}
