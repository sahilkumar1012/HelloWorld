package com.example.helloworld.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * problem link : https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/smallest-number-following-pattern-official/ojquestion
 * asked in Goldman Sachs CA, Google
 *
 * leetcode : 484. Find Permutation , https://leetcode.com/problems/find-permutation/
 *
 * 1. You are given a pattern of upto 8 length containing characters 'i' and 'd'.
 * 2. 'd' stands for decreasing and 'i' stands for increasing
 * 3. You have to print the smallest number, using the digits 1 to 9 only without repetition, such that
 * the digit decreases following a d and increases following an i.
 *
 * e.g.
 * d -> 21
 * i -> 12
 * ddd -> 4321
 * iii -> 1234
 * dddiddd -> 43218765
 * iiddd -> 126543
 *
 * Constraints
 * 0 < str.length <= 8
 * str contains only 'd' and 'i'
 * Sample Input
 * ddddiiii
 * Sample Output
 * 543216789
 */
public class SmallestNumberFollowingPattern {

    /**
     * input is considered to be valid always.
     * @param pattern
     * @return
     */
    static String smallestNumberFollowingPatter(String pattern){
        Deque<Integer> stack = new ArrayDeque<>();
        int k = 1;
        StringBuilder sb = new StringBuilder();

        for(char ch : pattern.toCharArray()){
            if(ch == 'd'){
                stack.push(k++);
            }else{
                stack.push(k++);

                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }
        }
        stack.push(k);
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
//        return Integer.parseInt(sb.toString());
    }


}
