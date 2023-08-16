package com.example.helloworld.array.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 239. Sliding Window Maximum
 * hard
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class SlidingWindowMaximum {
    /**
     we'll maintain a doubly linked list, where we'll keep biggest element at the lest most side( keep removing smaller elements before inserting any value). so we'll get max element in every window. overall O(n).
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int idx = 0;        // window idx

        Deque<Integer> dq = new LinkedList<>(); // storing indices
        int currMin = 0, max = Integer.MAX_VALUE;

        // for first window
        for(int i=0; i<k ;i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        ans[idx++] = nums[dq.peekFirst()];

        // rest of the windows
        for(int i=k; i<nums.length; i++){
            // delete elements not eligible for current window
            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            ans[idx++] = nums[dq.peekFirst()];
        }
        return ans;
    }

    //main
    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ans = slidingWindowMaximum.maxSlidingWindow(nums, k);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
        System.out.println("done");
    }
}
