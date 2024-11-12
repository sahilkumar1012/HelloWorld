package com.example.helloworld.interviews.sahil.Atlassian; /**
 *
 */

/*
We are working on a security system for a badged-access room in our company's building.

We want to find employees who badged into our secured room unusually often. We have an unordered list of names and entry times over a single day. Access times are given as numbers up to four digits in length using 24-hour time, such as "800" or "2250".

Write a function that finds anyone who badged into the room three or more times in a one-hour period. Your function should return each of the employees who fit that criteria, plus the times that they badged in during the one-hour period. If there are multiple one-hour periods where this was true for an employee, just return the earliest one for that employee.

badge_times = [
  ["Paul",      "1355"], ["Jennifer",  "1910"], ["Jose",    "835"],
  ["Jose",       "830"], ["Paul",      "1315"], ["Chloe",     "0"],
  ["Chloe",     "1910"], ["Jose",      "1615"], ["Jose",   "1640"],
  ["Paul",      "1405"], ["Jose",       "855"], ["Jose",    "930"],
  ["Jose",       "915"], ["Jose",       "730"], ["Jose",    "940"],
  ["Jennifer",  "1335"], ["Jennifer",   "730"], ["Jose",   "1630"],
  ["Jennifer",     "5"], ["Chloe",     "1909"], ["Zhang",     "1"],
  ["Zhang",       "10"], ["Zhang",      "109"], ["Zhang",   "110"],
  ["Amos",         "1"], ["Amos",         "2"], ["Amos",    "400"],
  ["Amos",       "500"], ["Amos",       "503"], ["Amos",    "504"],
  ["Amos",       "601"], ["Amos",       "602"], ["Paul",   "1416"],
];

Expected output (in any order)
   Paul: 1315 1355 1405
   Jose: 830 835 855 915 930
   Zhang: 10 109 110
   Amos: 500 503 504

n: length of the badge records array

map<name, count>
1315, 1355 , 1405 ,
window ( pirority queue on increasing entering time. ) ( will discard stale records. )

*/
import java.io.*;
import java.util.*;

class Solution {
    public static List<Set<String>> sol(String[][] records){
        Set<String> skipexit = new HashSet<>();
        Set<String> skipentry = new HashSet<>();

        Map<String, String> map = new HashMap<>();
        for(String[] record: records){
            String name = record[0];
            String state = record[1];

            if(state.equals("enter")){
                if(map.containsKey(name) == false){   // first entry
                    map.put(name, "enter");
                }else if(map.containsKey(name) == true) {  // he skipped exit
                    skipexit.add(name);
                }
            }else if(state.equals("exit")){
                if(map.containsKey(name) == true){
                    map.remove(name);
                }else{    // he forgot while entering
                    skipentry.add(name);
                }
            }
        }

        for(String key : map.keySet()){
            skipexit.add(key);
        }

        // remove all from the room
        System.out.println(skipexit);
        System.out.println(skipentry);
        List< Set<String> > ans = new ArrayList<>();
        ans.add(skipexit);
        ans.add(skipentry);
        return ans;
    }
    public static void main(String[] argv) {
        String[][] badgeTimes = new String[][] {
                {"Paul", "1355"},
                {"Jennifer", "1910"},
                {"Jose", "835"},
                {"Jose", "830"},
                {"Paul", "1315"},
                {"Chloe", "0"},
                {"Chloe", "1910"},
                {"Jose", "1615"},
                {"Jose", "1640"},
                {"Paul", "1405"},
                {"Jose", "855"},
                {"Jose", "930"},
                {"Jose", "915"},
                {"Jose", "730"},
                {"Jose", "940"},
                {"Jennifer", "1335"},
                {"Jennifer", "730"},
                {"Jose", "1630"},
                {"Jennifer", "5"},
                {"Chloe", "1909"},
                {"Zhang", "1"},
                {"Zhang", "10"},
                {"Zhang", "109"},
                {"Zhang", "110"},
                {"Amos", "1"},
                {"Amos", "2"},
                {"Amos", "400"},
                {"Amos", "500"},
                {"Amos", "503"},
                {"Amos", "504"},
                {"Amos", "601"},
                {"Amos", "602"},
                {"Paul", "1416"},
        };

    /*
    sol(records1);
    sol(records2);
    sol(records3);
    sol(records4);
    */
    }
}
