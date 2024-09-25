package com.example.helloworld.array.slidingwindow;

/**
 * leetcode 2134. Minimum Swaps to Group All 1's Together II
 *
 * A swap is defined as taking two distinct positions in an array and swapping the values in them.
 *
 * A circular array is defined as an array where we consider the first element and the last element to be adjacent.
 *
 * Given a binary circular array nums, return the minimum number of swaps required to group all 1's present in the array together at any location.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,1,1,0,0]
 * Output: 1
 * Explanation: Here are a few of the ways to group all the 1's together:
 * [0,0,1,1,1,0,0] using 1 swap.
 * [0,1,1,1,0,0,0] using 1 swap.
 * [1,1,0,0,0,0,1] using 2 swaps (using the circular property of the array).
 * There is no way to group all 1's together with 0 swaps.
 * Thus, the minimum number of swaps required is 1.
 * Example 2:
 *
 * Input: nums = [0,1,1,1,0,0,1,1,0]
 * Output: 2
 * Explanation: Here are a few of the ways to group all the 1's together:
 * [1,1,1,0,0,0,0,1,1] using 2 swaps (using the circular property of the array).
 * [1,1,1,1,1,0,0,0,0] using 2 swaps.
 * There is no way to group all 1's together with 0 or 1 swaps.
 * Thus, the minimum number of swaps required is 2.
 * Example 3:
 *
 * Input: nums = [1,1,0,0,1]
 * Output: 0
 * Explanation: All the 1's are already grouped together due to the circular property of the array.
 * Thus, the minimum number of swaps required is 0.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */
public class MinimumSwapstoGroupAll1sTogetherII {

    // Sliding window technique to find the minimum swaps needed to group all 1's together.
    public int minSwaps(int[] nums) {
        // Count the total number of 1's in the array
        int ones = 0;
        for(int num : nums)
            if(num == 1) ones++;

        // The window length will be equal to the number of 1's in the array
        int wlen = ones;
        System.out.println("wlen: " + wlen);

        // If the number of 1's equals the length of the array, they are already grouped together
        if(wlen == nums.length) return 0;

        // Initialize the first window and count the number of 0's within this window
        int idx = 0;
        int zerocount = 0;
        for(idx=0; idx<wlen; idx++){
            if(nums[idx] == 0){
                zerocount++;
            }
        }

        // Store the number of 0's in the first window as the initial answer
        int ans = zerocount;

        // To handle the circular nature of the array, create a new array that is double the size of the original
        int[] dnums = new int[nums.length*2];
        fill(dnums, nums);

        // Slide the window across the entire doubled array and update the answer with the minimum number of 0's encountered
        for( ; idx<dnums.length; idx++){
            // Add the element at the end of the current window
            if(dnums[idx] == 0){
                zerocount++;
            }
            // Remove the element that is no longer in the window
            if(dnums[idx-wlen] == 0){
                zerocount--;
            }

            // Update the answer with the minimum number of 0's in any window
            ans = Math.min(ans, zerocount);
        }

        // Return the minimum number of swaps needed to group all 1's together
        return ans;
    }

    // Helper function to fill the doubled array with elements from the original array twice
    private void fill(int[] dnums, int[] nums){
        int idx = 0;
        int n = nums.length;

        // Fill the first half of the doubled array
        for(int num : nums){
            dnums[idx] = nums[idx];
            idx++;
        }
        // Fill the second half of the doubled array
        idx = 0;
        for(int num : nums){
            dnums[idx + n] = nums[idx];
            idx++;
        }
    }
}

