package com.example.helloworld.searching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 154. Find Minimum in Rotated Sorted Array II
 *
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:
 *
 * [4,5,6,7,0,1,4] if it was rotated 4 times.
 * [0,1,4,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 *
 * Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
 *
 * You must decrease the overall operation steps as much as possible.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5]
 * Output: 1
 * Example 2:
 *
 * Input: nums = [2,2,2,0,1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums is sorted and rotated between 1 and n times.
 *
 *
 * Follow up: This problem is similar to Find Minimum in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why?
 */
public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int n = nums.length;

        if(nums[0] < nums[n-1])
            return nums[0];

        int ans = nums[0];
        // // brute force
        // for(int i=1; i<n; i++){
        //     if(ans > nums[i])
        //         ans = nums[i];
        // }

        int l = 0, r = n-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid] < ans) ans = nums[mid];

            if(nums[mid] < nums[r]){    // this right side portion is sorted.
                if(nums[mid] < ans) ans = nums[mid];
                r = mid-1;
            }
            else if(nums[mid] > nums[l]){
                if(nums[l] < ans) ans = nums[l];
                l = mid+1;
            }else{
                if(nums[mid] == nums[r]){
                    r--;
                }
                if(nums[mid] == nums[l]){
                    l++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArrayII obj = new FindMinimumInRotatedSortedArrayII();
        int[] arr = new int[]{3,3,1,3};
        System.out.println(obj.findMin(arr));
    }
}

class FindMinimumInRotatedSortedArrayIIBucketingSolution {
    public String frequencySort(String s) {
        if (s == null) {
            return null;
        }
        // capture frequency
        Map<Character, Integer> map = new HashMap();
        int max = 0;
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
            max = Math.max(max, map.get(c));
        }

        List<Character>[] array = buildBucketArray(map, max);

        return buildOutputString(array);
    }

    private List<Character>[] buildBucketArray(Map<Character, Integer> map, int maxCount) {
        List<Character>[] array = new List[maxCount + 1];
        for (Character c : map.keySet()) {
            int count = map.get(c); // considering frequency count as index in our array.
            if (array[count] == null) {
                array[count] = new ArrayList();
            }
            array[count].add(c);
        }
        return array;
    }

    private String buildOutputString(List<Character>[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i > 0; i--) {
            var list = array[i];
            if (list != null) {
                for (Character c : list) {
                    // jo index hai utni bar hi vo characters add ho jaege.
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}