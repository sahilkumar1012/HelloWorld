package com.example.helloworld.dp;


/**
 *
leetcode 338. Counting Bits
 reference video link : https://youtu.be/awxaRgUB4Kw

 Given an integer num, return an array of the number of 1's in the binary representation of every number in the range [0, num].



 Example 1:

 Input: num = 2
 Output: [0,1,1]
 Explanation:
 0 --> 0
 1 --> 1
 2 --> 10
 Example 2:

 Input: num = 5
 Output: [0,1,1,2,1,2]
 Explanation:
 0 --> 0
 1 --> 1
 2 --> 10
 3 --> 11
 4 --> 100
 5 --> 101


 Constraints:

 0 <= num <= 105
 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] dp = new int[num + 1];

        for (int i = 1; i <= num; ++i) {
            dp[i] = dp[i / 2] + i % 2; // even or odd case.
        }
        return dp;
    }


    public int[] countBitsPoor(int num) {
        int[] ans = new int[num + 1];

        int temp, k;
        for (int i = 0; i <= num; ++i) {
            temp = 0;

            // count 1 in bits. (logn time)

            k = i; // k for temporary number
            while (k > 0) {
                if ((k & 1) == 1)
                    ++temp;
                k >>= 1;
            }

            ans[i] = temp;
        }
        return ans;
    }
}
