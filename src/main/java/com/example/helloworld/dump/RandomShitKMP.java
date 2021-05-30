package com.example.helloworld.dump;


public class RandomShitKMP {
    // KMP
    public static void main(String[] args) {
        String string = "abcxabcdabcdabco";
        String pattern = "abcdabcy";

        System.out.println(kmp(string.toCharArray(), pattern.toCharArray()));
    }

    private static boolean kmp(char[] string, char[] pattern) {
        int[] lps = lps(pattern);
        //System.out.println(lps);


        return magicFunction(lps,pattern,string);
    }

    private static boolean magicFunction(int[] lps, char[] pattern, char[] string) {

        int j=0,i=0;
        while(i<string.length && j<pattern.length)
        {
            if(pattern[j]==string[i]){
                j++;
                i++;
            }
            else{
                if(j!=0)
                j=lps[j-1];

                else
                    i++;
            }
        }
        return j==pattern.length;
    }

    private static int[] lps(char[] pattern) {
        int lps[] = new int[pattern.length];
        int index = 0;
        for (int i = 1; i < pattern.length; ) {
            if (pattern[index] == pattern[i]) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
