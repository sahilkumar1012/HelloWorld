package com.example.helloworld.array.binarysearch;

/**
 * leetcode 1287. Element Appearing More Than 25% In Sorted Array
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 *
 * Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,6,6,6,6,7,10]
 * Output: 6
 * Example 2:
 *
 * Input: arr = [1,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 105
 *
 */
public class ElementAppearingMoreThan25PercentInSortedArray {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int[] candidates = {arr[n/4], arr[n/2], arr[3*n/4]};

        for(int candidate : candidates){
            int left = first(arr, candidate);
            int right = last(arr, candidate);

            if( (right-left + 1) * 4 > n){
                return candidate;
            }
        }

        return -1;
    }

    private int first ( int[] arr, int a ){
        int left = 0, right = arr.length-1;
        int res = -1;
        while( left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] > a){
                right = mid -1;
            }else if(arr[mid] < a){
                left = mid + 1;
            }else{
                res = mid;
                right = mid-1;
            }
        }
        return res;
    }

    private int last ( int[] arr, int a){
        int left = 0, right = arr.length-1;
        int res = -1;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] > a){
                right = mid -1;
            }else if(arr[mid] < a){
                left = mid + 1;
            }else{
                res = mid;
                left = mid + 1;
            }
        }

        return res;
    }

}
