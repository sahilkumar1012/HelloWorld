package com.example.helloworld.dump;

import java.util.*;


public class DeleteThisFile {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int a : nums){
            pq.offer(a);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.poll();
//        Arrays.sort(nums);
//        return nums[nums.length-k];
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp;
        int mad = Integer.MAX_VALUE; // maximum absolute difference.

        for(int i=1; i<arr.length; ++i){
            if(Math.abs(arr[i]-arr[i-1]) < mad){            // this pair is better.
                mad = Math.abs(arr[i]-arr[i-1]);
                ans.clear();
            }
            if(Math.abs(arr[i]-arr[i-1]) == mad){     // we also need to consider this pair
                temp = new ArrayList<>();
                temp.add(arr[i-1]); temp.add(arr[i]);
                ans.add(temp);
            }
        }
        return ans;
    }
}



class Expedia2{
    private static ArrayList<String> scatterPalindrome(String param){
        int n = param.length();
        HashSet<String> res = new HashSet<>();
        if(param == null || n == 0) {
            return new ArrayList<String>();
        }

        HashMap<Character, Integer> charMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int numEven = 0;
            int numOdd = 0;
            charMap.clear();
            for(int j = i + 1; j < n + 1; j++) {
//                System.out.println(i + "|" + j);
                char cur = param.charAt(j - 1);
                charMap.put(cur, charMap.getOrDefault(cur, 0) + 1);
                int curCount = charMap.get(cur);
                if(curCount % 2 == 0) {
                    numEven++;
                    numOdd--;
                } else {
                    numOdd++;
                    if(numEven > 0 && curCount != 1) {
                        numEven--;
                    }
                }
//                System.out.println(param.substring(i, j) + "|odd: " + numOdd + "|even: " + numEven);
                if(numEven == charMap.size() || numOdd == 1) {
                    res.add(param.substring(i, j));
                }
            }
        }
        return new ArrayList<String>(res);
    }

    public static void main(String[] args) {
//        System.out.println(getPalindSubstring("bbrrg"));
//        System.out.println(getPalindSubstring("abc"));
//        System.out.println(scatterPalindrome("ddrrg").size());
        System.out.println((int)1e9);
    }
    private static ArrayList<String> scatterPalindrome1(String param){
        int n = param.length();
        HashSet<String> res = new HashSet<>();
        if(param == null || n == 0) {
            return new ArrayList<String>();
        }

        HashMap<Character, Integer> charMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int numEven = 0;
            int numOdd = 0;
            charMap.clear();
            for(int j = i + 1; j < n + 1; j++) {
//                System.out.println(i + "|" + j);
                char cur = param.charAt(j - 1);
                charMap.put(cur, charMap.getOrDefault(cur, 0) + 1);
                int curCount = charMap.get(cur);
                if(curCount % 2 == 0) {
                    numEven++;
                    numOdd--;
                } else {
                    numOdd++;
                    if(numEven > 0 && curCount != 1) {
                        numEven--;
                    }
                }
//                System.out.println(param.substring(i, j) + "|odd: " + numOdd + "|even: " + numEven);
                if(numEven == charMap.size() || numOdd == 1) {
                    res.add(param.substring(i, j));
                }
            }
        }
        return new ArrayList<String>(res);
    }
    private static Integer getPalindSubstring(String s){
        List<String> res = new ArrayList<>();
        dfs(s, res, 0, new StringBuilder());
        return res.size();
    }

    private static void dfs(String s, List<String> res, int cur, StringBuilder sb) {
        if(isValid(sb.toString()) && sb.length()>0){
            System.out.println("candidate: "+sb.toString());
            res.add(sb.toString());
        }
        for(int i=cur; i<s.length(); i++){
            if(i>cur && s.charAt(i)==s.charAt(i-1))
                continue;
            sb.append(s.charAt(i));
            dfs(s, res, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private static boolean isValid(String s) {
        int[] cnt = new int[26];
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }
        int count = 0;
        for(int i=0; i<cnt.length; i++){
            if(cnt[i]%2 == 1){
                count++;
            }
        }
        return count<2;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int[] temp;
        HashMap<String, List<Integer>> map = new HashMap<>();

        String fstring;
        int i=0;
        for(String s: strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            s = ch.toString();

            map.getOrDefault(s,new ArrayList<>()).add(i++);
        }

        List<List<String>> res = new ArrayList<>();
        for(String s: map.keySet()){
            List<Integer> idxs = map.get(s);
            List<String> t = new ArrayList<>();

            for(int ii : idxs){
                t.add(strs[ii]);
            }
            res.add(t);
        }

        return res;
    }
}
