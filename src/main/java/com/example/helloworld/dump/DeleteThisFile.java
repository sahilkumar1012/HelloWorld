package com.example.helloworld.dump;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteThisFile {
    public static void main(String[] args) {

    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        // create an array of list<list<Integer>
        List<List<Integer>>[] arr = new List[n+1];
        for(int i=0; i<n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            int size = groupSizes[i];

            List<List<Integer>> row = arr[size];
            if(row.size() == 0){
                row.add(new ArrayList<>());
            }
            if(row.get(row.size()-1).size() == size){
                row.add(new ArrayList<>());
            }
            row.get(row.size()-1).add(i);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            List<List<Integer>> row = arr[i];
            if(row.size() > 0){
                result.addAll(row);
            }
        }

        return result;
    }

}


