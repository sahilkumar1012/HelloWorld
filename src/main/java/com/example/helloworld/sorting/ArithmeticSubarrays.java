package com.example.helloworld.sorting;

import java.util.*;

/**
 * leetcode 1630. Arithmetic Subarrays
 *
 * A sequence of numbers is called arithmetic if it consists of at least two elements, and the difference between every two consecutive elements is the same. More formally, a sequence s is arithmetic if and only if s[i+1] - s[i] == s[1] - s[0] for all valid i.
 *
 * For example, these are arithmetic sequences:
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic:
 *
 * 1, 1, 2, 5, 7
 * You are given an array of n integers, nums, and two arrays of m integers each, l and r, representing the m range queries, where the ith query is the range [l[i], r[i]]. All the arrays are 0-indexed.
 *
 * Return a list of boolean elements answer, where answer[i] is true if the subarray nums[l[i]], nums[l[i]+1], ... , nums[r[i]] can be rearranged to form an arithmetic sequence, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
 * Output: [true,false,true]
 * Explanation:
 * In the 0th query, the subarray is [4,6,5]. This can be rearranged as [6,5,4], which is an arithmetic sequence.
 * In the 1st query, the subarray is [4,6,5,9]. This cannot be rearranged as an arithmetic sequence.
 * In the 2nd query, the subarray is [5,9,3,7]. This can be rearranged as [3,5,7,9], which is an arithmetic sequence.
 * Example 2:
 *
 * Input: nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]
 * Output: [false,true,false,false,true,true]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * m == l.length
 * m == r.length
 * 2 <= n <= 500
 * 1 <= m <= 500
 * 0 <= l[i] < r[i] < n
 * -105 <= nums[i] <= 105
 */
public class ArithmeticSubarrays {

    // implementation using sorting of each subarray.
    // Time complexity: O(m⋅n⋅logn)
    public List<Boolean> checkArithmeticSubarraysUsingSorting(int[] nums, int[] l, int[] r) {
        int m = l.length;

        List<Boolean> ans = new ArrayList<>();

        for(int i=0; i<m; i++){
            // prepare subarray from l[i] to r[i]
            List<Integer> list = new ArrayList<>();
            for(int j=l[i]; j<=r[i]; j++){
                list.add(nums[j]);
            }

            // sort subarray
            Collections.sort(list);

            // check if subarray is arithmetic
            boolean isAP = true;
            int d = list.get(1) - list.get(0);
            for(int j=2; j<list.size(); j++){
                if(list.get(j) - list.get(j-1) != d)
                    isAP = false;
            }

            ans.add(isAP);  // keep storing result for each query
        }

        return ans;
    }


    /**
     * without sorting the subArrays
     * Time complexity: O(m⋅n)
     * @param nums
     * @param l         start of subArray for each query
     * @param r         end of subArray for each query
     * @return          boolean for each query, whether it's AP or not.
     */

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> ans = new ArrayList<>();

        for(int i=0; i<m; i++){
            int[] arr = new int[r[i] - l[i] + 1];
            for(int j=l[i]; j<=r[i]; j++){
                arr[j-l[i]] = nums[j];
            }

            ans.add(check(arr));
        }
        return ans;
    }

    private boolean check(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<arr.length; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            set.add(arr[i]);
        }

        if((max - min)%(arr.length-1) != 0) return false;
        int diff = (max - min)/(arr.length-1);

        int curr = min + diff;
        while(curr < max){
            if(!set.contains(curr)){
                return false;
            }
            curr += diff;
        }
        return true;
    }


}
