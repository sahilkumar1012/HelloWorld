package com.example.helloworld.greedy;

/**
 * leetcode 11. Container With Most Water
 *
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class ContainerWithMostWater {
    /**
     go greedy, i,j two pointers at extreme positions.
     calculate area, then increment the pointer which is having lowest height.
     becuase if we increase the pointer with heigher height then it is of no use. area will always decrease in that case.
     */
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int ans = 0;

        while (i < j) {
            int width = j - i;
            int h = Math.min(height[i], height[j]);

            // increment the pointer with lower height
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
            ans = Math.max(ans, width * h);
        }
        return ans;
    }
}
