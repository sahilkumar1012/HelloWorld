package com.example.helloworld.interviews.chirag.VW;

import java.util.Arrays;
import java.util.HashMap;

public class RoundFirst {

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1,2,3,8,9,56,10};

        Arrays.sort(arr);
        //
        System.out.println(arr[n-2]);
    }

    // String with repetative char
public static void main2(String[] args) {
    String s = new String("abcdABCDabcdDD");
    //output: a=2, A=1.
    HashMap <Character,Integer> freq= new HashMap<>();
    for(char c:s.toCharArray()){
        freq.put(c,freq.getOrDefault(c,0)+1);
    }
    for (char c: freq.keySet()){
        System.out.println( c + ""+freq.get(c));
    }

}
}

//abstract class RoundFirst{
//
//}
