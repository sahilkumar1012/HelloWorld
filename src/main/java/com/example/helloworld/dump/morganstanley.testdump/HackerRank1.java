package com.example.helloworld.dump.morganstanley.testdump;


import java.util.Arrays;

/**
 * questions sent by sahil singla over whatsapp.
 */
public class HackerRank1 {

    public static void main(String[] args) {
        for( int i: solve(new int[]{2,1,1,4}, new int[][]{ {1,1,3,1000}, {2,3,7,2} })){
            System.out.print(i + " ");
        }
    }

    public static  int[] solve(int[] A, int[][] operations){
        int[] original  = Arrays.copyOf(A,A.length);

        final int Mod = 1000000007;
        for(int [] operation : operations) {
            int L = operation[0];
            int R = operation[1];
            int a = operation[2];
            int d = operation[3];

            for(int i=L; i<=R; ++i){
                    A[i-1] = original[i-1] + (a+ (( i -L + 1  -1  )%Mod)*d)%Mod;
            }
        }
        return A;
    }
}
