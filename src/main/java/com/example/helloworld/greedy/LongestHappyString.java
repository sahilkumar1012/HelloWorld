package com.example.helloworld.greedy;

/**
 * leetcode 1405. Longest Happy String
 *
 * A string is called happy if it does not have any of the strings 'aaa', 'bbb' or 'ccc' as a substring.
 *
 * Given three integers a, b and c, return any string s, which satisfies following conditions:
 *
 * s is happy and longest possible.
 * s contains at most a occurrences of the letter 'a', at most b occurrences of the letter 'b' and at most c occurrences of the letter 'c'.
 * s will only contain 'a', 'b' and 'c' letters.
 * If there is no such string s return the empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: a = 1, b = 1, c = 7
 * Output: "ccaccbcc"
 * Explanation: "ccbccacc" would also be a correct answer.
 * Example 2:
 *
 * Input: a = 2, b = 2, c = 1
 * Output: "aabbc"
 * Example 3:
 *
 * Input: a = 7, b = 1, c = 0
 * Output: "aabaa"
 * Explanation: It's the only correct answer in this case.
 *
 *
 * Constraints:
 *
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 */
public class LongestHappyString {

    // greedy solution.
    public String longestDiverseString(int a, int b, int c) {
        int total=a+b+c;

        int A=0, B=0, C=0;
        StringBuilder sb = new StringBuilder();

        while(total-- > 0){
            // sabse phle max walo ko 2 bar dalega, fir kuch bhi randomly koi bhi value dal dege. fir fir se max pe chala jaega.
            if((a>=b && a>=c && A!=2) || (a>0 && (B==2|| C==2))){
                sb.append("a");
                a--;
                A++;
                B=C=0;
            }
            else if((b>=a && b>=c && B!=2) || (b>0 && (A==2|| C==2))){
                sb.append("b");;
                b--;
                B++;
                A=C=0;
            }
            else if((c>=a && c>=b && C!=2) || (c>0 && (A==2|| B==2))){
                sb.append("c");
                c--;
                C++;
                A=B=0;
            }else{
                break;      // khatam byebye tata.
            }
        }
        return sb.toString();
    }
}
