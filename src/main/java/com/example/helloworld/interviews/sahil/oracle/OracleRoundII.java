package com.example.helloworld.interviews.sahil.oracle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OracleRoundII {
}



/**
 Two puzzles asked:

 puzzle: 3 scietist > forest >
 kill them >

 test to be passed

 test 5 hats 2 black and 3 white

 queue > one hat on top of each hat. 2 hidden
 1 > 2 > 3



 puzzle: 25 horses , find top 3 horses, we have 5 lane ground.
 races = 5 + 1 + 1 =
 x . .
 . . .
 .



 */
class DumpOracleRoundII {

    public final int END = 15;

    private List<String> readLastNLines(List<String> file, int n){
//        int fileSize = file.size();
        Queue<String> queue = new LinkedList<>();
        List<String> res = new ArrayList<>();

        List<String> chunk = new ArrayList<>(); // chunk of n size
        for(int i=0; i<END; ){
            int k = n;

            while (k-- > 0 && i++ != END) {
                chunk.add(file.get(k - i));
            }
//            addInQueue
            if( i== END ) break;
        }

        return null;
    }

    public static void main(String[] args) {

    }
}


