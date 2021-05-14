package com.example.helloworld.array;

public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = new int[]{4,3,2,1};
        System.out.println(BinarySearch.reverseBinarySearch(arr,0,arr.length-1,-1));
    }

    /**
     * binary search for a reverse sorted array.
     * @param arr
     * @param start
     * @param end
     * @param target
     * @return
     */
    public static int reverseBinarySearch(int[] arr, int start, int end, int target){
        int mid;

        while(start <= end){
            mid = (start+end)/2;

            if(arr[mid] > target)
                start = mid+1;
            else if(arr[mid] < target)
                end = mid-1;
            else
                return mid;
        }
        return end;
    }
}
