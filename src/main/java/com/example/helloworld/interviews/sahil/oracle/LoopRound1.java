package com.example.helloworld.interviews.sahil.oracle;

import java.util.ArrayList;
import java.util.List;

public class LoopRound1 {

    public static void main(String[] args) {
        System.out.println(convert("ORACLEISHIRING", 3));
        System.out.println(convert("ORACLEISHIRING", 300));
        System.out.println(convert("A.,.A", 2));
        System.out.println(convert("ORACLEISHIRING", 4));
    }

    private static String convert(String s, int rows){
        List<List<Character>> lists = new ArrayList<>();
        for(int i=0; i<rows; i++){
            lists.add(new ArrayList<>());
        }
        StringBuilder sb = new StringBuilder();

        int n = s.length();
        for(int i=0; i<n;){
            // 0 to n-1
            for(int j=0; j<rows && i<n; j++){
                lists.get(j).add(s.charAt(i));
                i++;
            }
            // n-2 to 1
            for(int j=rows-2; j>0 && i<n; j--){
                lists.get(j).add(s.charAt(i));
                i++;
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<lists.get(i).size(); j++)
                sb.append(lists.get(i).get(j));
        }
        return sb.toString();
    }
}


// for(int i = 0; i<s.len() ;)
//     for(int i=0; i<row: i++){
//         ans.get(row).add(ch);
//         i++;
//     }
//     for(int j=row-2; j>0)
//     i++;

// The string "ORACLEISHIRING" is written in a zigzag pattern on a given number of rows like this (displayed with fixed-width font for clarity):

// O   L   H   N
// R C E S I I G
// A   I   R


// And then read line by line: "OLHNRCESIIGAIR"

// Write the code that will take a string and make this conversion given a number of rows:

// string convert(string s, int numRows);

// Example 1
// Input: s = "ORACLEISHIRING", numRows = 3
// Output: "OLHNRCESIIGAIR"

// Example 2
// Input: s = "A", numRows = 1
// Output: "A"


// Example 3
// Input: s = "ORACLEISHIRING", numRows = 4
// O    I      N
// R  E S   I  G
// A L  H R
// C    I
// Output: "OINRESIGALHRCI"

// Constraints

// 1 <= s.length <= 1000

// s consists of English letters (both lower and upper case), ',', and '.'.

// 1 <= numRows <= 1000

// char[row][col] - 1000 , s.length

// 0
// 1 1
// 2

// 0
// n-1

// n-2 - 1

// top to bottom:

// bottom to up :  (keep increasing columns )




