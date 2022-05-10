package com.example.helloworld.interviews.sahil.microsort;

import java.util.Arrays;

public class MicrosoftCodilityTest2 {
    // two problems are below
}

/**
 * You are given N numbers on a circle, described by an array A. Find the maximum number of neighbouring pairs whose sums are even. One element ce belong to only one pair.
 *
 * Write a function:
 *
 * class Solution (poblie ist solution (int[] A); }
 *
 * that, given an array A consisting of N Integers, returns the maximum number of neighbouring pairs whose suma are even.
 *
 * Examples:
 *
 * 1. Given A = 14, 2, 5, 8, 7, 3, 71, the function should return 2. We can create two pairs with even sums: (A[0], A[1]) and (A[4], A[5]). Another way to choose two pairs is: (A[0] A[1]) and (AIS), A16D
 *
 * 2. Given A=[14, 21, 16, 35, 221, the function should return 1. There is only one qualifying pair: (A[0] A[4]).
 *

 *
 * 3. Given A-15, 5, 5, 5, 5, 51, the function should retum 3. We can create three pairs: (A[0], A[5]). (A[1] A[2]) and (A[3] A[4D)
 *
 * To leave ed
 *
 * M
 *
 * Test Output
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1.100,000 each element of array A is an integer within the range (0..1,000,000,000).
 */


class MicrosoftCodilityTest2Problem1{
    public int solution(int[] A) {
        // write your code in Java SE 8
        return findMaxEvenPair(A);
    }

    private static int findMaxEvenPair(int[] input) {

        int[] nums = Arrays.copyOf(input, input.length + 1);
        nums[input.length] = nums[0];
        int countCase1 = findMaxPair(0, nums.length - 2, nums);
        int countCase2 = findMaxPair(1, nums.length - 1, nums);

        return Math.max(countCase1, countCase2);
    }

    private static int findMaxPair(int start, int end, int[] nums) {
        int count = 0;
        for (int i = start; i + 1 <= end; i++) {
            if ((nums[i] + nums[i + 1]) % 2 == 0) {
                count++; i++;
            }
        }
        return count;
    }
}

/**
 * We call an array switching if all numbers in even positions are equal and all numbers in odd positions are equal. For example: [3,-7,3,-7,3] and [4, 4, 4) are switching, but [5, 5, 4, 5, 4] and [-3, 2, 3] are not switching. What is the length of the longest switching slice (continuous fragment) in a given array A?
 *
 * Write a function:
 *
 * class Solution (public int solution(int[] A))
 *
 * that, given an array A consisting of N integers, returns the length of the longest switching slice in A.
 *
 * Examples:
 *
 * 1. Given A=(3,2,3,2, 31, the function should return 5, because the whole array is switching.
 *
 * 2. Given A=[7,4,-2,4,-2,-91, the function should return 4. The longest switching slice is (4, -2,4,-21.
 *
 * 3. Given A=17,-5, -5, -5,7,-1, 71, the function should return 3. There are two switching slices of equal length:
 *
 * [-5,-5,-5) and [7,-1,7).
 *
 * 4. Given A=[4], the function should return 1. A single-element slice is also a switching slice.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1.100,000 each element of array A is an integer within the range [-1,000,000,000..1,000,000,000).
 */
class MicrosoftCodilityTest2Problem2 {
    // intuitive approach
    public int solution(int[] input) {
        // write your code in Java SE 8
        if (input.length < 3)
            return input.length;

        int len = 2, tlen = 2;
        for (int i = 2; i < input.length; i++) {
            if (input[i] == input[i - 2]) {
                tlen++;
                len = Math.max(len, tlen);
            } else {
                tlen = 2;
            }
        }

        return len;
    }
}
