package com.example.helloworld.bitmanipulation;

/**
 * leetcode 2429. Minimize XOR
 *
 * code harmony video explanation : https://youtu.be/4luftcH6isY
 *
 * my leetcode solution : https://leetcode.com/problems/minimize-xor/solutions/6283132/easy-to-understand-bit-manipulation-100-sureu
 *
 *
 * Given two positive integers num1 and num2, find the positive integer x such that:
 *
 * x has the same number of set bits as num2, and
 * The value x XOR num1 is minimal.
 * Note that XOR is the bitwise XOR operation.
 *
 * Return the integer x. The test cases are generated such that x is uniquely determined.
 *
 * The number of set bits of an integer is the number of 1's in its binary representation.
 *
 *
 *
 * Example 1:
 *
 * Input: num1 = 3, num2 = 5
 * Output: 3
 * Explanation:
 * The binary representations of num1 and num2 are 0011 and 0101, respectively.
 * The integer 3 has the same number of set bits as num2, and the value 3 XOR 3 = 0 is minimal.
 * Example 2:
 *
 * Input: num1 = 1, num2 = 12
 * Output: 3
 * Explanation:
 * The binary representations of num1 and num2 are 0001 and 1100, respectively.
 * The integer 3 has the same number of set bits as num2, and the value 3 XOR 1 = 2 is minimal.
 *
 *
 * Constraints:
 *
 * 1 <= num1, num2 <= 109
 */
public class MinimizeXOR {
    public int minimizeXor(int num1, int num2) {

        // Initialize result with num1
        int result = num1;

        // Count the number of set bits (1s) in num2
        int setbits = 0;
        while(num2 > 0) {
            num2 = num2 & (num2 - 1); // Remove the least significant set bit
            setbits++;
        }

        // Count the number of set bits in result (num1)
        int temp = result;
        int sb = 0;
        while(temp > 0) {
            temp = temp & (temp - 1); // Remove the least significant set bit
            sb++;
        }

        // If the number of set bits in result is greater than the set bits in num2
        if(sb > setbits) {
            int sbtr = sb - setbits; // Number of extra set bits to remove
            while(sbtr-- > 0) {
                result = result & (result - 1); // Remove the least significant set bit
            }
        }
        // If the number of set bits in result is less than the set bits in num2
        else if(sb < setbits) {
            int sbta = setbits - sb; // Number of set bits to add
            for(int i = 0; i < 32; i++) {
                if(sbta == 0) break; // Stop once the required bits are added

                // If the current bit is 0, set it
                if((result & (1 << i)) == 0) {
                    result = result | (1 << i); // Set the bit at position i
                    sbta--;
                }
            }
        }

        return result; // Return the minimized XOR value
    }

}
