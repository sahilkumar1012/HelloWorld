package com.example.helloworld.interviews.sahil.uiPath;

public class UiPathInterviewRound2Coding {

    // array with height of block on it.
    public static int sol(int[] input) {      // 2,0,4,1,2,1,3
        int n = input.length;
        // find the index with maximum height
        int iMax = 0;
        for (int i = 1; i < n; i++) {
            if (input[i] > input[iMax])
                iMax = i;
        }

        int ans = 0;     // imax = 2
        // process left part of max height, 1,0,2,3,0,5,     0,3
        //    (0,iMax)
        int iMaxLeft = 0;
        for (int i = 1; i < iMax; i++) {      // all the items have iMaxLeft as left max and iMax as right max.
            int min = Math.min(input[iMaxLeft], input[iMax]);
            if (input[i] < min) {
                ans += min - input[i];
            }
            if (input[i] > input[iMaxLeft])
                iMaxLeft = i;
        }


        // process right part of max height
        //    (iMax, n-1);
        int iMaxRight = n - 1;
        for (int i = n - 2; i > iMax; i--) {
            int min = Math.min(input[iMaxRight], input[iMax]);
            if (input[i] < min) {
                ans += min - input[i];
            }
            if (input[i] > input[iMaxRight])
                iMaxRight = i;
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] input = new int[]{2, 0, 4, 1, 2, 1, 3};
        System.out.println(sol(input));

        input = new int[]{2, 2, 2};
        System.out.println(sol(input));

        input = new int[]{2};
        System.out.println(sol(input));
    }
}


