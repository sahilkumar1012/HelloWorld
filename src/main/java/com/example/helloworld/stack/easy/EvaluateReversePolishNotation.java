package com.example.helloworld.stack.easy;

import java.util.Stack;

/**
 * leetcode 150. Evaluate Reverse Polish Notation
 *
 * code harmony solution video : https://youtu.be/5IJDyeyw5FE
 *
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 *
 * Evaluate the expression. Return an integer that represents the value of the expression.
 *
 * Note that:
 *
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 *
 *
 * Example 1:
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 *
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 *
 * Constraints:
 *
 * 1 <= tokens.length <= 104
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */
public class EvaluateReversePolishNotation {
    /**
     * Evaluates the given array of tokens representing a Reverse Polish Notation expression.
     *
     * @param tokens The array of tokens.
     * @return The result of the evaluation.
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>(); // Stack to hold operands during evaluation
        Integer lo, ro; // Variables to hold the left and right operands

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            switch (token) {
                case "+":
                    // Addition operation
                    ro = s.pop();
                    lo = s.pop();
                    s.push(lo + ro);
                    break;
                case "-":
                    // Subtraction operation
                    ro = s.pop();
                    lo = s.pop();
                    s.push(lo - ro);
                    break;
                case "*":
                    // Multiplication operation
                    ro = s.pop();
                    lo = s.pop();
                    s.push(lo * ro);
                    break;
                case "/":
                    // Division operation
                    ro = s.pop();
                    lo = s.pop();
                    s.push(lo / ro);
                    break;
                default:
                    // Operand, push it onto the stack
                    s.push(Integer.valueOf(token));
            }
        }
        return s.pop(); // Result of the evaluation is the final element in the stack
    }
}
}
