package com.example.helloworld.searching;

/**
 * 33. Search in Rotated Sorted Array
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * All values of nums are unique.
 * nums is guaranteed to be rotated at some pivot.
 * -104 <= target <= 104
 */
public class SearchInSortedRotatedArray {

    public static void main(String[] args) {
        int target = 1;
        int[] nums = new int[]{3,1};    // good sample test case.

        System.out.println(new SearchInSortedRotatedArray().search(nums,target));
    }

    /**
     * using single iteration, modify binary search algorithm.
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;

            if (nums[left] <= nums[mid]) {                 // this portion is already sorted.
                if (target >= nums[left] && target < nums[mid])          // range mai hai kya?
                    right = mid;
                else
                    left = mid + 1; // search in other half
            } else {                // so right is sorted.
                if (target > nums[mid] && target <= nums[right])          // range mai hai kya?
                    left = mid + 1;
                else
                    right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public int searchOld(int[] nums, int target) {
        int n = nums.length;

        if(nums[0] <= nums[n-1])            // coz all are distinct
            return binarySearch(nums,0,n-1,target);

        int pivot = findPivot(nums,0,n-1);  // pivot second wale ki starting hai.

        if(target >= nums[0] && target <= nums[pivot-1])
            return binarySearch(nums,0,pivot-1,target);

        return binarySearch(nums,pivot,n-1,target);
    }

    // vanilla binary search
    private int binarySearch(int[] nums, int start, int end,int target){
        if(start > end)
            return -1;

        int mid = (start+end)/2;
        if(nums[mid] == target)
            return mid;

        if(nums[mid] < target)
            return binarySearch(nums,mid+1,end,target);

        return binarySearch(nums,start,mid-1,target);
    }

    // finding pivot
    private int findPivot(int[] nums, int start, int end){
        // if(start > end)
        //     return -1;

        if( nums[start] <= nums[end] )
            return start;

        int mid = (start+end)/2;

        if(nums[mid] >= nums[start])
            return findPivot(nums, mid+1, end);

        return findPivot(nums, start, mid);
    }

}
