package com.example.helloworld.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Key{
    int[] freq;

    public Key(int[] f){
        freq = f;
    }

    @Override
    public boolean equals(Object input){
        Key key = (Key) input;
        int[] a = key.freq;
        for(int i=0; i<a.length; ++i){
            if(a[i] != this.freq[i])
                return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        String str = "";
        for(int i=0; i<freq.length; i++){
            str += freq[i];
        }
        return str.hashCode();
    }

}
public class GroupAnagram {

    public static void main(String[] args) {
        System.out.println(new GroupAnagram().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
    public final char a = 'a';

    public List<List<String>> groupAnagrams(String[] strs) {
        int[] temp;
        HashMap<Key, List<String>> map = new HashMap<>();

        for(String s: strs){
            temp = new int[26];
            for(char ch : s.toCharArray()){
                temp[ch-a]++;
            }
            Key key = new Key(temp);
            if(map.get(key)==null)
                map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for(Key key : map.keySet()){
            res.add(map.get(key));
        }

        return res;
    }
}
