package com.example.helloworld.array;

/**
 * leetcode 414. Third Maximum Number
 *
 * Given integer array nums, return the third maximum number in this array. If the third maximum does not exist, return the maximum number.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation: The third maximum is 1.
 * Example 2:
 *
 * Input: nums = [1,2]
 * Output: 2
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 *
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow up: Can you find an O(n) solution?
 */
public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,Integer.MIN_VALUE};
        System.out.println(new ThirdMaximumNumber().thirdMax(input));
    }

    public int thirdMax(int[] nums) {
        long m1 = Long.MIN_VALUE;
        long m2 = m1;
        long m3 = m1;

        int counter = 0;

        for(long a : nums){
            if(a > m1){
                m3 = m2;
                m2 = m1;
                m1 = a;
                counter ++;
            }else if( a>m2 && a<m1 ) {
                m3 = m2;
                m2 = a;
                counter++;
            }else if( a > m3  && a < m2 ) {
                m3 = a;
                counter++;
            }
        }

        return counter < 3 ? (int)m1 : (int)m3;
    }
}
