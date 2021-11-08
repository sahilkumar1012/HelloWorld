package com.example.helloworld.dp.catalannumber;

import java.util.Scanner;

/**
 * pepcoding : https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/count-valleys-mountains-official/ojquestion
 *
 * 1. You are given a number n, representing the number of upstrokes / and number of downstrokes .
 * 2. You are required to find the number of valleys and mountains you can create using strokes.
 * E.g.
 *
 * countvalleys
 *
 * Note -> At no point should we go below the sea-level. (number of downstrokes should never be more than number of upstrokes).
 * Input Format
 * A number n
 * Output Format
 * A number representing the number of valleys and mountains you can create using strokes.
 * Question Video
 *
 *   COMMENTConstraints
 * 0 <= n <= 15
 * Sample Input
 * 4
 * Sample Output
 * 14
 */
public class CountOfValleysAndMountains {
    public static int countOfValleysAndMountains(int n){
        return CatalanNumber.findNthCatalanNumber(n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(CountOfValleysAndMountains.countOfValleysAndMountains(n));
    }
}
