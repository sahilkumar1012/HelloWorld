package com.example.helloworld.interviews.chirag.microsoft;

/**
 * link for reference : https://leetcode.com/discuss/interview-question/1770045/microsoft-oa-maximumsum
 *
 */
public class CodilityMicrosoftChirag {
    // below are the three problems
}

/**
 * Minimum number of water container needed.
 *
 * Suppose you have an array of houses "-H-H-H", each house needs to be close to a water tank on either its left or right side. How many water tanks do you need? Water Tanks can only go where there is a dash.
 *
 * Ex. "-H-H-H" -> solution: 2 tanks needed, one option is '-HTHTH', or 'TH-HTH'
 *
 *  */
class CodilityMicrosoftChiragProblem2{
    public static int solution(String str) {
        int count = 0;
        if (str.length() < 2 || str.indexOf('H') == -1 || str.indexOf('-') == -1)
            return -1;
        StringBuilder sbuffer = new StringBuilder(str);
        int l = sbuffer.length();
        if (sbuffer.charAt(0) == 'H') {
            if (sbuffer.charAt(1) == 'H')
                return -1;
            else
                sbuffer = sbuffer.replace(1, 2, "T");
        }
        if (sbuffer.charAt(l - 1) == 'H') {
            if (sbuffer.charAt(l - 2) == 'H')
                return -1;
            else
                sbuffer = sbuffer.replace(l - 2, l - 1, "T");
        }

        for (int i = 1; i < l - 1; i++) {
            if (sbuffer.charAt(i) == 'H') {
                if (sbuffer.charAt(i - 1) == 'H' && sbuffer.charAt(i + 1) == 'H')
                    return -1;
                if (sbuffer.charAt(i - 1) != 'T' && sbuffer.charAt(i + 1) != 'T') {
                    if (sbuffer.charAt(i + 1) == '-')
                        sbuffer = sbuffer.replace(i + 1, i + 2, "T");
                    else
                        sbuffer = sbuffer.replace(i - 1, i, "T");
                }
            }
        }

        for (int i = 0; i < sbuffer.length(); i++) {
            if (sbuffer.charAt(i) == 'T')
                count++;
        }
        if (count == 0)
            count = -1;
        return count;
    }
}


/**
 You are given a string S, which consists entirely of decimal digits (0−9).
 Using digits from S, create a palindromic number with the largest possible decimal value.
 You should use at least one digit and you can reorder the digits.

 A palindromic number remains the same when its digits are reversed; for instance, "7", "44" or "83238".
 Any palindromic number you create should not, however, have any leading zeros, such as in "0990" or "010".
 For example, decimal palindromic numbers that can be created from "8199" are:
 "1", "8", "9", "99", "919" and "989".

 Among them, “989” has the largest value.

 Write a function:
 class Solution { public String solution(String S); }
 that, given a string S of N digits, returns the string representing the palindromic number with the largest value.
 Examples:
 1. Given "39878", your function should return "898".
 2. Given "00900", your function should return "9".
 3. Given "0000", your function should return "0".
 4. Given "54321", your function should return "5".
 Write an efficient algorithm for the following assumptions:
 N is an integer within the range [1..100,000];
 string S consists only of digits (0−9).
 */
class CodilityMicrosoftChiragProblem3{
    public String solution(String s) {
        // write your code in Java SE 8
        int[] count = new int[10];
        for(char ch : s.toCharArray()){
            int temp = ch - '0';
            count[temp]++;
        }
        StringBuilder sb = new StringBuilder();
        int maxOdd = -1;
        for(int i = 0; i <= 9; i++){
            if(count[i] % 2 == 1) maxOdd = i;
        }
        if(maxOdd != -1) sb.append(maxOdd);
        for(int i = 1; i <=9 ; i++){
            int counter = count[i];
            if(count[i] == 0) continue;
            if(count[i] % 2 == 1) counter = count[i] - 1;
            for(int j = 0; j < counter / 2; j++){
                sb.append(i);
                sb.insert(0, i);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}


/**
 * easy problem, refer image : microsoft problem 1 assembly loader easy problem.png
 */
class CodilityMicrosoftChiragProblem1 {
    public int solution(String S) {
        // write your code in Java SE 8
        int count = 0, res = 0;
        for(char ch: S.toCharArray()){
            if(ch == 'L'){
                count += (-1);
            }else{
                count += (+1);
            }
            if(count == 0)
                res ++;
        }
        return res;
    }
}
