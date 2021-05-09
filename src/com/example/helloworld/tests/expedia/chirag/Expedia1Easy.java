package com.example.helloworld.tests.expedia.chirag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Expedia1Easy {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Switch");
        list.add("pen");
        list.add("Switch");
        list.add("pen");

        System.out.println(new Expedia1Easy().deviceNamesSystem(list));
    }
    public List<String> deviceNamesSystem(List<String> devicenames){
        HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        for(String name: devicenames){
            if(map.get(name)==null){
                res.add(name);
                map.put(name,1);
            }else{
                res.add(name+map.get(name));
                map.put(name,map.get(name)+1);
            }
        }
        return res;
    }
}