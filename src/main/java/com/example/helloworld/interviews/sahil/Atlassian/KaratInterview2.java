//package com.example.helloworld.interviews.sahil.Atlassian;
//
//import java.util.*;
//
//
//
///*
//We are working on a security system for a badged-access room in our company's building.
//
//We want to find employees who badged into our secured room unusually often. We have an unordered list of names and entry times over a single day. Access times are given as numbers up to four digits in length using 24-hour time, such as "800" or "2250".
//
//Write a function that finds anyone who badged into the room three or more times in a one-hour period. Your function should return each of the employees who fit that criteria, plus the times that they badged in during the one-hour period. If there are multiple one-hour periods where this was true for an employee, just return the earliest one for that employee.
//
//badge_times = [
//  ["Paul",      "1355"], ["Jennifer",  "1910"], ["Jose",    "835"],
//  ["Jose",       "830"], ["Paul",      "1315"], ["Chloe",     "0"],
//  ["Chloe",     "1910"], ["Jose",      "1615"], ["Jose",   "1640"],
//  ["Paul",      "1405"], ["Jose",       "855"], ["Jose",    "930"],
//  ["Jose",       "915"], ["Jose",       "730"], ["Jose",    "940"],
//  ["Jennifer",  "1335"], ["Jennifer",   "730"], ["Jose",   "1630"],
//  ["Jennifer",     "5"], ["Chloe",     "1909"], ["Zhang",     "1"],
//  ["Zhang",       "10"], ["Zhang",      "109"], ["Zhang",   "110"],
//  ["Amos",         "1"], ["Amos",         "2"], ["Amos",    "400"],
//  ["Amos",       "500"], ["Amos",       "503"], ["Amos",    "504"],
//  ["Amos",       "601"], ["Amos",       "602"], ["Paul",   "1416"],
//];
//
//Expected output (in any order)
//   Paul: 1315 1355 1405
//   Jose: 830 835 855 915 930
//   Zhang: 10 109 110
//   Amos: 500 503 504
//
//1. iteration over records.
//2. Map<Name, SortedList<Time>> -
//  3. <name, time>   // if time enries > time-1 are >=3
//
//3. result Map<Name, List<Time>>
//
//
//// PriorityQueue< <name, time> >  , increasing order of time.
//
//
//n: length of the badge records array
//*/
////import java.io.*;
////        import java.util.*;
////        import javafx.util.Pair;
//
//class Solution {
//
//    // problem 1 : <name, status> , <paul, entry or exit>
//    // returnc collection of all the persons who forgot to entry and who forgot to exit.
//    public List<Set<String>> sol(String[][] records){
//        Set<String> room = new HashSet<>();
//        Set<String> skippedentry = new HashSet<>();
//        Set<String> skippedexit = new HashSet<>();
//
//        for(String[] record: records){
//            String name = record[0];
//            String status = record[1];
//
//            if(status.equals("enter")){
//                if(room.contains(name)){
//                    skippedexit.add(name);
//                }else{
//                    room.add(name);
//                }
//            }else if(status.equals("exit")){
//                if(room.contains(name)){
//                    room.remove(name);
//                }else{
//                    skippedentry.add(name);
//                    room.remove(name);
//                }
//            }
//        }
//
//        for(String name: room)
//            skippedexit.add(name);
//
//        List<Set<String>> result = new ArrayList();
//        result.add(skippedexit);
//        result.add(skippedentry);
//        return result;
//    }
//
//    /**
//     * this is the follow up question from interviewer,
//     * where times are mentioned, and return list of names who accessed the room >=3 times in one hour.
//     * @param records
//     * @return
//     */
//    public List<Map<String,List<String>>> sol2(String[][] records){
//        List<Map<String,List<String>>> result = new ArrayList();
//
//        Map<String, List<String>> map = new HashMap();
//
//        for(String[] record: records){
//            String name = record[0];
//            String time = record[1];
//
//            map.putIfAbsent(name, new ArrayList());
////            map.put(name, time);
//
//            List<String> times = new ArrayList();
//            // capture all the time >= time-1 in a list
////            if(list.size()>=3){
////
////            }
//
//        }
//
//        return result;
//    }
//    public static void main(String[] argv) {
//        String[][] badgeTimes = new String[][] {
//                {"Paul", "1355"},
//                {"Jennifer", "1910"},
//                {"Jose", "835"},
//                {"Jose", "830"},
//                {"Paul", "1315"},
//                {"Chloe", "0"},
//                {"Chloe", "1910"},
//                {"Jose", "1615"},
//                {"Jose", "1640"},
//                {"Paul", "1405"},
//                {"Jose", "855"},
//                {"Jose", "930"},
//                {"Jose", "915"},
//                {"Jose", "730"},
//                {"Jose", "940"},
//                {"Jennifer", "1335"},
//                {"Jennifer", "730"},
//                {"Jose", "1630"},
//                {"Jennifer", "5"},
//                {"Chloe", "1909"},
//                {"Zhang", "1"},
//                {"Zhang", "10"},
//                {"Zhang", "109"},
//                {"Zhang", "110"},
//                {"Amos", "1"},
//                {"Amos", "2"},
//                {"Amos", "400"},
//                {"Amos", "500"},
//                {"Amos", "503"},
//                {"Amos", "504"},
//                {"Amos", "601"},
//                {"Amos", "602"},
//                {"Paul", "1416"},
//        };
//    /*
//    Solution o = new Solution();
//    System.out.println(o.sol(records1));
//    System.out.println(o.sol(records2));
//    System.out.println(o.sol(records3));
//    System.out.println(o.sol(records4));
//    */
//    }
//}
