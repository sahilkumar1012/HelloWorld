package com.example.helloworld.interviews.others.himanshu;

/**
 * @author sahil, tokopedia test of himanshu baweja
 *
 * We're given keypad of nokia 3310, and for a given string, we need to find
 * count of substrings whole sum is divisible with their length.
 *
 * substring sum  = sum of number mapped to the specific character in the keypad.
 * like for a,b number is 1. check findValue function for reference.
 *
 *
 */
public class TokopediaTestQues2 {

    public static int countSubstrings(String str) {
        int res = 0;

        for (int l = 1; l <= str.length(); l++) {
            int sum = 0;
            // checing for first substring of this len, starting at index 0
            int ii = 0, jj = l - 1;
            for (int k = ii; k <= jj; k++) {
                sum += findValue(str.charAt(k));
            }
            if (sum % l == 0) {
                res++;
            }
            // sliding window approach
            // check for other strings starting from index 1 of len  = l
            for (int i = 1; i <= str.length() - l; i++) {
                int j = i + l - 1;
                sum -= findValue(str.charAt(i - 1));
                sum += findValue(str.charAt(j));
                if (sum % l == 0) res++;
            }
        }
        return res;
    }

    public static int findValue(char c) {
        if (c == 'a' || c == 'b') return 1;
        else if (c >= 'c' && c <= 'e') return 2;
        else if (c >= 'f' && c <= 'h') return 3;
        else if (c >= 'i' && c <= 'k') return 4;
        else if (c >= 'l' && c <= 'n') return 5;
        else if (c >= 'o' && c <= 'q') return 6;
        else if (c >= 'r' && c <= 't') return 7;
        else if (c >= 'u' && c <= 'w') return 8;
        else if (c >= 'x' && c <= 'z') return 9;
        else return 0;
    }
}