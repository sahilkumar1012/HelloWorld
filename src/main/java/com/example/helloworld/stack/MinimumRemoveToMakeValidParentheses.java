package com.example.helloworld.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * leetcode 1249. Minimum Remove to Make Valid Parentheses
 *
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 *
 *
 * Example 1:
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 *
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 *
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is either'(' , ')', or lowercase English letter.
 */
public class MinimumRemoveToMakeValidParentheses {
        public String minRemoveToMakeValid(String s) {
            Stack<int[]> stack = new Stack<>();

            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i);

                if(ch == '('){
                    stack.push(new int[]{(int)'(', i});
                }else if(ch == ')'){
                    if(!stack.isEmpty() && stack.peek()[0] == (int)'(')
                        stack.pop();
                    else
                        stack.push(new int[]{(int)')', i});
                }
            }
            // stack is having all the invalid bracket with their indices
            Set<Integer> set = new HashSet<>();     // invalid index set
            while(!stack.isEmpty()){
                set.add(stack.pop()[1]);
            }

            StringBuilder ans = new StringBuilder();
            for(int i=0; i<s.length(); i++)
                if(!set.contains(i)) ans.append(s.charAt(i));

            return ans.toString();
        }
    }
