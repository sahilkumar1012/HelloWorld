package com.example.helloworld.dump;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteThisFile {
    public static void main(String[] args) {
        System.out.println("Hi");
    }

    public int kthGrammar(int n, int k) {
        List<Character> prow = new ArrayList<>();

        prow.add('0');
        for(int i=2; i<=n; i++){
            List<Character> crow = new ArrayList<>();
            for(Character ch : prow){
                if(ch == '0'){
                    crow.add('0');
                    crow.add('1');
                }else if(ch == '1'){
                    crow.add('1');
                    crow.add('0');
                }
            }
            prow.clear();
            prow.addAll(crow);
        }
        return prow.get(k);
    }

}


