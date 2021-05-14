package com.example.helloworld.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 17. Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 *
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinationsOfPhoneNumber {


    public List<String> letterCombinations(String digits) {
        if(!digits.equals(""))
            combinations(digits,"");

        return arr;
    }

    String letter[]={"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; // "abc" mapped to 2 in phone
    List<String> arr=new ArrayList<>();

    public void combinations(String digits,String asf){

        if(digits.equals("")){
            arr.add(asf);
            return;
        }

        int number=digits.charAt(0)-'0'; //getting the digits like in case of "23" we get 2

        String let=letter[number-1]; //accesing which string is present in the given index

        for(int j=0;j<let.length();j++)
            combinations(digits.substring(1),asf+let.charAt(j));
    }


}
