package com.example.helloworld.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 357. Count Numbers with Unique Digits
 *
 * reference from video https://youtu.be/dcnDIKBWWG0
 *
 *
 *
 *
 Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.



 Example 1:

 Input: n = 2
 Output: 91
 Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, excluding 11,22,33,44,55,66,77,88,99
 Example 2:

 Input: n = 0
 Output: 1


 Constraints:

 0 <= n <= 8


 *
 */
public class NumberOfUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;

        int[] dp = new int[n + 1]; // dp[i] to store numbers of i unique digits.
        int[] ps = new int[n + 1]; // prfix sum array

        dp[0] = 1; // 0 and 1 wala case manually karlia baki mai dimag laga lia.
        ps[0] = 1;

        dp[1] = 9;
        ps[1] = 10;

        int d = 0, prevD = 0; // duplicate and previous duplicates.
        for (int i = 2; i <= n; ++i) {
            d = (dp[i - 1] * (i - 1)) + (prevD * 10);
            dp[i] = (int) Math.pow(10, i) - (int) Math.pow(10, i - 1) - d;
            prevD = d;

            ps[i] = dp[i] + ps[i - 1];
        }


        return ps[n];
    }

    public int countNumbersWithUniqueDigitsBrute(int n) {
        int count = 0;

        for (int i = 0; i < Math.pow(10, n); ++i)
            if (ud(i))
                ++count;

        return count;
    }

    private boolean ud(int n) {
        Set<Integer> set = new HashSet<>();
        for (; n > 0; n /= 10) {
            if (!set.add(n % 10))
                return false;
        }
        return true;
    }
}