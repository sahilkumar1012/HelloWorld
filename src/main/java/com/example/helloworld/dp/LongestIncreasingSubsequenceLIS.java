package com.example.helloworld.dp;

import java.util.Arrays;

/**
 * leetcode 300. Longest Increasing Subsequence
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up:
 *
 * Could you come up with the O(n2) solution?
 * Could you improve it to O(n log(n)) time complexity?
 */
public class LongestIncreasingSubsequenceLIS {

    /*
    https://youtu.be/22s1xxRvy28
    Patience Sort explanation, LIS length is equal to number of piles.
    */

    // O(nlog(n)) time with linear space.
    public int lengthOfLISd(int[] nums) {
        int n = nums.length,numPiles=0;
        int piles[] = new int[n];

        for(int num: nums){
            int destPile = Arrays.binarySearch(piles,0,numPiles,num); // bs : [startIndex, endIndex)
            if(destPile<0){
                destPile = -(destPile+1); // as binar search return -(insertPoint)-1
            }
            piles[destPile] = num;
            if(destPile == numPiles){       // new pile was created.
                numPiles++;
            }
        }
        return numPiles;
    }


    // O(n^2) time with linear space.
    public int lengthOfLISdp(int[] nums) {
        final int n = nums.length;
        int dp[] = new int[n];
        int omax = 0;

        for(int i=0;i<n;i++){
            int max = 0;        // max dp value so far.
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    if(max < dp[j])
                        max = dp[j];
                }
            }
            dp[i] = max + 1;

            if(omax < dp[i])
                omax = dp[i];
        }
        return omax;
    }

    /*
    Another approach is solving the question using DP with binary search.


It needs to explain the meaning of dp array : it is not necessary the current longest sequence, but the sequence that could be used to deduct the len of the longest sequence

In regular DP solution, for every incoming nums[i] , it needs to match against every dp[j] (where j<i）
because each of those dp[j] (where j<i）is possible candidate for new LIS

The smartness behind this DP solution is to remember the one and only one sequence that is capable to produce LIS in the dp array, and that sequence maintain the same len as the LIS

For example [10,9,2,5,7,3,5,8]
1: num[0]=10, dp = [10]
2: num[1]= 9, dp= [9] 9 <10, replace 10 with 9, [9] will be able to produce longer LIS than [10]
3 num[2]= 2, dp = [2] 2 < 9, replace 9 with 2, [2] will be able to produce longer LIS than [9]
4 num[3]= 5, dp = [2, 5] append 5, [2, 5] will be the candidate to produce longer LIS
5 num[4]= 7, dp = [2, 5, 7] append 7, [2, 5, 7] will be the candidate to produce longer LIS
6 num[5]= 3, dp = [2, 3, 7] 3<5 , replace 5 with 3, [2, 3, 7] will be the candidate to produce longer LIS
[2,3,7] is not a valid sequence, but a candidate for [2,3,5] to be developed
If nums stop at [10,9,2,5,7,3,5], we still get correct LIS (dp.len==3)
7 num[6]= 5, dp = [2, 3, 5] 5<7 , replace 7 with 5, [2, 3, 5] will be the candidate to produce longer LIS
8 num[7]= 8, dp = [2, 3, 5, 8] append 8, [2, 3,5,8] will be the candidate to produce longer LIS




    */
}

