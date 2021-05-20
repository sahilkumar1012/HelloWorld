package com.example.helloworld.others;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * LeetCode 89. Gray Code
 *
 *
 * he gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given an integer n representing the total number of bits in the code, return any sequence of gray code.
 *
 * A gray code sequence must begin with 0.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * [0,2,3,1] is also a valid gray code sequence.
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * Example 2:
 *
 * Input: n = 1
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 16
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        // Stack<Integer> s= new Stack<>();
        res.add(0);
        res.add(1);

        for(int i=1;i<n;i++){
            for(int j=res.size()-1;j>=0;j--) {
                res.add(res.get(j)|(1<<i));
            }
        }

        return res;
    }
}
