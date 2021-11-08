package com.example.helloworld.dp.catalannumber;

import java.util.Scanner;

/**
 * pepcoding:
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/count-brackets-official/ojquestion
 *
 * https://youtu.be/n-8R95-5MXw?list=TLGGRbeq73roQtUwODExMjAyMQ
 *
 *
 * 1. You are given a number n, representing the number of opening brackets ( and closing brackets )
 * 2. You are required to find the number of ways in which you can arrange the brackets if the closing brackets should never exceed opening brackets
 * e.g.
 * for 1, answer is 1 -> ()
 * for 2, answer is 2 -> ()(), (())
 * for 3, asnwer is 5 -> ()()(), () (()), (())(), (()()), ((()))
 * Input Format
 * A number n
 * Output Format
 * A number representing the number of ways in which you can arrange the brackets if the closing brackets should never exceed opening brackets
 * Question Video
 *
 *   COMMENTConstraints
 * 0 <= n <= 15
 * Sample Input
 * 4
 * Sample Output
 * 14
 */
public class CountBrackets {

    public static int countBrackets(int n){
        return CatalanNumber.findNthCatalanNumber(n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(CountBrackets.countBrackets(n));
    }

}
