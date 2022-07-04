package com.example.helloworld.stack.easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * leetcode 20. Valid Parentheses
 *
 Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.


 Example 1:

 Input: s = "()"
 Output: true
 Example 2:

 Input: s = "()[]{}"
 Output: true
 Example 3:

 Input: s = "(]"
 Output: false


 Constraints:

 1 <= s.length <= 104
 s consists of parentheses only '()[]{}'.

 */
public class ValidParentheses {


    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> bracketMap;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public ValidParentheses() {
        this.bracketMap = new HashMap<>();
        this.bracketMap.put(')', '(');
        this.bracketMap.put('}', '{');
        this.bracketMap.put(']', '[');
    }

    public boolean isValid(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.bracketMap.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.bracketMap.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}
