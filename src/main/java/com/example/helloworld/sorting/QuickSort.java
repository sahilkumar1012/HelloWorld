package com.example.helloworld.sorting;

import com.example.helloworld.array.ArrayUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * leetcode 912. Sort an Array
 *
 * quick sort array.
 *
 * Ques : why library function is must more faster than this ?
 *
 *
 * will be better if we take mid as pivot.
 *
 * NlogN in best case
 * N^2 in the worst case, as we're choosing last index as pivot every time.
 * NlogN is the average time complexity is we use random pivot every time.
 *
 * problem statement :
 * Given an array of integers nums, sort the array in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{7,2,1,0,12,8,4};
        new QuickSort().quickSort(arr,0, arr.length-1);

        System.out.println("args = " + Arrays.toString(arr));
    }

    /**
     * quick sort on given array from low index to high index.
     * @param arr
     * @param low
     * @param high
     */
    public void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    // taking right most as pivot.

    /**
     * implementation as per CLRS book, corman. taking right most as pivot.
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public int partition(int[] arr, int low, int high) {
        int i = low-1;

        // average time is improved too much if we choose random pivot every time
        // checked practically on leetcode .
        Random random = new Random();
        int t = random.nextInt(high-low+1);
        ArrayUtil.swap(arr, low + t, high);

//        ArrayUtil.swap( arr, (high+low)/2 , high);        // if we consider mid instead of random index.

        int pivot = arr[high];

        for(int j=low; j<=high-1; ++j){
            if(arr[j] < pivot){
                i++;
                ArrayUtil.swap(arr, i, j);
            }
        }
        ArrayUtil.swap(arr, i+1, high);
        return i+1;
    }

}
