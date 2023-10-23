package com.example.helloworld.bitmanipulation;

/**
 * leetcode 342. Power of Four
 *
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 *
 * An integer n is a power of four, if there exists an integer x such that n == 4x.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 16
 * Output: true
 * Example 2:
 *
 * Input: n = 5
 * Output: false
 * Example 3:
 *
 * Input: n = 1
 * Output: true
 *
 *
 * Constraints:
 *
 * -231 <= n <= 231 - 1
 *
 *
 * Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfFour {

    /**
     Approach 4: Bit Manipulation + Math

     Let's first check if xxx is a power of two:
     x > 0 and x & (x - 1) == 0.
     Now one could be sure that x=2ax = 2^ax=2
     a
     .
     Though xxx is a power of four only if aaa is even.

     Next step is to consider both cases a=2ka = 2ka=2k and a=2k+1a = 2k + 1a=2k+1,
     and to compute xxx modulo after division by three:

     (22kmod  3)=(4kmod  3)=((3+1)kmod  3)=1(2^{2k} \mod 3) = (4^k \mod 3) = ((3 + 1)^k \mod 3) = 1(2
     2k
     mod3)=(4
     k
     mod3)=((3+1)
     k
     mod3)=1

     ((22k+1)mod  3)=((2×4k)mod  3)=((2×(3+1)k)mod  3)=2((2^{2k + 1}) \mod 3) = ((2 \times 4^k) \mod 3) = ((2 \times(3 + 1)^k) \mod 3) = 2((2
     2k+1
     )mod3)=((2×4
     k
     )mod3)=((2×(3+1)
     k
     )mod3)=2

//     If xxx is a power of two and x % 3 == 1, then xxx is a power of four.     */
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && (num % 3 == 1);
    }

    // sahil's lengthy solution / brute force
    public boolean isPowerOfFourOld(int n) {
        if( n==1 ) return true;
        if( n==0 ) return false;
        if( n%2==1 || n < 4) return false;

        int count = 0, idx = -1;
        for(int i=1; i<=31 && n>0; i++){
            if ((n & 1) == 1) {
                count++; idx = i;
            }
            n>>=1;
        }

        if(idx %2 == 0 ) return false;
        return count==1;
    }

}
