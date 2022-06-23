package com.example.helloworld.interviews.sahil.moneyview;

import java.util.*;

/*

Problem 1 :

Task is to write a function that, given a list of words and a string, finds and returns the word in the list that is scrambled up inside the string, if any exists. There will be at most one matching word. The letters don't need to be in order or next to each other. The letters cannot be reused.
Example:
words = ['cat', 'baby', 'dog', 'bird', 'car', 'ax']
string1 = 'tcabnihjs'  -> cat
string2 ='badgutbsy' -> baby
string3 ='cc' ->  Null/None
find_embedded_word(words, string1) -> cat (the letters do not have to be in order)

  */

  /*

Problem 2 :

Find k numbers with most occurrences in the given array
  arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9},
  k = 3
  Output: 5 11 7

    hahing
    array of size 101 () []

    hashMap< element, freq of element >

    keySet > list > sort this list according to value in the map.

map :
    7 > 2
    10 > 1
    11 > 2
    5 > 3
    2 > 1
    8 > 1
    9 > 1

key : 7 , 10 , 11, 5 , 2, 8, 9




  */

public class MoneyViewRound1 {

    public List<Integer> sol2(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: arr){
            map.put( i , map.getOrDefault(i,0) + 1 );
        }

        List<Integer> keys = new ArrayList<>();
        keys.addAll(map.keySet());

        // System.out.println(keys);
        // sorted in decreasing order on the basis of it's frequency in arr
        Collections.sort(keys, (a, b) -> {
            return map.get(b) - map.get(a);
        });

        // System.out.println(keys);

        // top k most frequent elements
        List<Integer> ans  = new ArrayList<>();
        if(k < arr.length){
            for(int i=0; i<k; i++){
                ans.add(keys.get(i));
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        MoneyViewRound1 obj = new MoneyViewRound1();
        // System.out.println(obj.sol(new String[]{"cat", "baby"} , "tcabnihjs"));
        // System.out.println(obj.sol(new String[]{"cat", "baby"} , "badgutbsy"));
        // System.out.println(obj.sol(new String[]{"cat", "baby"} , "cc"));

        System.out.println( obj.sol2(new int[]{7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9}, 3)  );
    }

    public String sol(String[] words, String input){
        int[] hash = new int[26];
        for(char ch : input.toCharArray()){
            hash[ch-'a']++;
        }

        int[] h;
        for(String word : words){
            h =  Arrays.copyOf(hash, 26);
            // process current word;
            boolean found = true;
            for(char ch : word.toCharArray()){
                if(h[ch-'a'] == 0)
                    found = false;
                h[ch-'a'] --;
            }

            if(found)
                return word;
        }

        return null; // no word can be formed
    }

}

// Your Previous  code is preserved below:
// const _ = require('lodash');

// function helloWorld() {
//   console.log('Hello, World');
// }

// _.times(5, helloWorld);