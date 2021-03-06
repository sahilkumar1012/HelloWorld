package com.example.helloworld.searching;

/**
 * leetcode 4. Median of Two Sorted Arrays
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Example 3:
 *
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 * Example 4:
 *
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 * Example 5:
 *
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 *
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class MedianOfTwoSortedArray {
    /*
    * took reference from Tushar roy's video. to get this log(min(x,y)) time solution.

    https://youtu.be/LPFhl65R7ww

    Sample Example :
    1, 3, 8, 9, 15
    7, 11, 18, 19, 21 25

    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;

        // considering first array as smaller
        if(x > y){
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = x;

        // binary search wala logic, chote array pe chalaege.(first one)
        while(low <= high){
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            int maxLeftX = (partitionX==0) ? Integer.MIN_VALUE : nums1[partitionX-1];
            int minRightX = (partitionX==x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY==0) ? Integer.MIN_VALUE : nums2[partitionY-1];
            int minRightY = (partitionY==y) ? Integer.MAX_VALUE : nums2[partitionY];

            // butterscotch binary search.
            if(maxLeftX <= minRightY && maxLeftY <=minRightX){ // at the solution

                if( (x+y)%2 ==0){ // even wala case, 2 candidate hoge
                    return (double) ( Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY) )/2;
                }else{
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            }else if(maxLeftX > minRightY){
                high = partitionX-1;
            }else{
                low = partitionX+1;
            }
        }

        throw new IllegalArgumentException();
    }
}
