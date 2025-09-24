package com.example.helloworld.math;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * leetcode 166. Fraction to Recurring Decimal , Math, Long Division , Asked in Goldman Sachs n MAANG
 *
 * code harmony explanation video : https://youtu.be/30dpJ4Jg2-o
 *
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * If multiple answers are possible, return any of them.
 *
 * It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
 *
 *
 *
 * Example 1:
 *
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 *
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 *
 * Input: numerator = 4, denominator = 333
 * Output: "0.(012)"
 *
 *
 * Constraints:
 *
 * -231 <= numerator, denominator <= 231 - 1
 * denominator != 0
 *
 *
 */


public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int n, int d) {
        // If numerator is 0, the fraction is 0
        if(n == 0) return "0";

        // To build the result string
        StringBuilder sb = new StringBuilder();

        // Determine the sign of the result
        // If exactly one of n or d is negative, prepend "-"
        if( (n < 0) ^ (d < 0) ){
            sb.append("-");
        }

        // Convert to long to prevent overflow and take absolute values
        long a = Math.abs((long) n); // numerator
        long b = Math.abs((long) d); // denominator

        // Append the integer part of the division
        sb.append(a / b);

        // Calculate the initial remainder
        long remainder = a % b;

        // If no remainder, return the result as there is no fractional part
        if(remainder == 0){
            return sb.toString();
        }

        // There is a fractional part, so add the decimal point
        sb.append(".");

        // Map to store previously seen remainders and their positions in sb
        Map<Long, Integer> map = new HashMap<>();

        // Process fractional part using long division
        while(remainder != 0){
            // If this remainder has been seen before, it's repeating
            if(map.containsKey(remainder)){
                int pos = map.get(remainder);
                sb.insert(pos, "("); // insert '(' at the first occurrence
                sb.append(")");      // append ')' at the end
                break;               // repeating part handled, exit loop
            }

            // Store the position of this remainder
            map.put(remainder, sb.length());

            // Multiply remainder by 10 and append the quotient digit
            sb.append(remainder * 10 / b);

            // Update remainder
            remainder = (remainder * 10) % b;
        }

        // Return the final string representation
        return sb.toString();
    }
}
