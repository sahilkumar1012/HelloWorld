package com.example.helloworld.dp.arraydp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 368. Largest Divisible Subset
 *
 * code harmony solution video : https://youtu.be/A5spyU-PpmQ
 *
 * Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
 *
 * answer[i] % answer[j] == 0, or
 * answer[j] % answer[i] == 0
 * If there are multiple solutions, return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,2]
 * Explanation: [1,3] is also accepted.
 * Example 2:
 *
 * Input: nums = [1,2,4,8]
 * Output: [1,2,4,8]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * All the integers in nums are unique.
 *
 */
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Sort the input array in ascending order
        Arrays.sort(nums);
        // Length of the input array
        int n = nums.length;
        // Variables to keep track of the length of the largest divisible subset and its ending index
        int anslen = 0, ansidx = -1;

        // 2D List to store the largest divisible subset ending at each index
        List<List<Integer>> dp = new ArrayList<>();
        for(int i=0; i<n; i++)
            // Initialize each list in dp with an empty list
            dp.add(new ArrayList<>());

        // Iterate over each element in the input array
        for(int i=0; i<n; i++){
            // Initialize a list to store the current maximum subset
            List<Integer> maxSubset = new ArrayList();

            // Iterate over elements before the current element
            for(int j=0; j<i; j++){
                // Check if the current element is divisible by the previous element
                if(nums[i] % nums[j] == 0 && maxSubset.size() < dp.get(j).size()){
                    // If so, update the maxSubset to the largest subset ending at the previous element
                    maxSubset = dp.get(j);
                }
            }

            // Add the current element to the maxSubset
            dp.get(i).addAll(maxSubset);
            dp.get(i).add(nums[i]);

            // Update the length and index of the largest divisible subset if needed
            if(anslen < dp.get(i).size()){
                anslen = dp.get(i).size();
                ansidx = i;
            }
        }

        // Return the largest divisible subset
        return dp.get(ansidx);
    }
}
