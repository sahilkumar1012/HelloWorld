package com.example.helloworld.hashtable;

/**
 * leetcode 12. Integer to Roman
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 3
 * Output: "III"
 * Explanation: 3 is represented as 3 ones.
 * Example 2:
 *
 * Input: num = 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 3:
 *
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 *
 * Constraints:
 *
 * 1 <= num <= 3999
 */
public class IntegerToRoman {

    Entry[] entries;

    // considering all the test cases.
    public IntegerToRoman(){
        entries = new Entry[]{
                new Entry("M",1000),
                new Entry("CM",900),
                new Entry("D",500),
                new Entry("CD",400),
                new Entry("C",100),
                new Entry("XC",90),
                new Entry("L",50),
                new Entry("XL",40),
                new Entry("X",10),
                new Entry("IX",9),
                new Entry("V",5),
                new Entry("IV",4),
                new Entry("I",1),
        };
    }

    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();

        // iterating through all the cases.
        for(int i=0; i<entries.length; ++i){

            if( (num/entries[i].value) > 0){

                int t = num/entries[i].value;
                while(t-- > 0){
                    res.append(entries[i].symbol); // jitne chahiye utne append kardo
                }
            }
            num %= entries[i].value; // remove the most significant digit.
        }
        return res.toString();
    }

    class Entry{
        public String symbol;
        public int value;
        public Entry(String symbol, int value){
            this.symbol = symbol;
            this.value = value;
        }
    }
}

/*
class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        int index = s.length()-1;
        res += map.get(s.charAt(index));

        while( index-- > 0){
            if( map.get(s.charAt(index)) >= map.get(s.charAt(index+1)) ){
                res += map.get(s.charAt(index));
            }else{
                res -= map.get(s.charAt(index));
            }
        }

        return res;
    }
}
*/