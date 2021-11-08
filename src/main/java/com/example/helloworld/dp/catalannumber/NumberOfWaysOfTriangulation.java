package com.example.helloworld.dp.catalannumber;

/**
 * pepcpding : Number Of Ways Of Triangulation
 * problem : [ https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/number-of-ways-of-triangulation-official/ojquestion ]
 * video link : https://youtu.be/jSGW3YKkyHQ?list=TLGGFjIGnt8pEFQwODExMjAyMQ
 *
 * 1. You are given a number N, which represents the number of sides in a polygon.
 * 2. You have to find the total number of ways in which the given polygon can be triangulated.
 * Input Format
 * A number N
 * Output Format
 * A number representing number of ways of traingulating a N-sided polygon.
 * Question Video
 *
 *   COMMENTConstraints
 * 1 <= N <= 15
 * Sample Input
 * 5
 * Sample Output
 * 5
 */
public class NumberOfWaysOfTriangulation {

    public static int numberOfWaysOfTriangulation(int numberOfSidesInPolygon){
        if(numberOfSidesInPolygon < 3)
            throw new RuntimeException("Triangulation is not possible for polygon with sides less than 3.");

        return CatalanNumber.findNthCatalanNumber(numberOfSidesInPolygon-2);
    }

}
