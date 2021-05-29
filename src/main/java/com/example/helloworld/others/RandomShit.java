package com.example.helloworld.others;


public class RandomShit {
    // KMP
    public static void main(String[] args) {
        String string = "";
        String pattern = "";

        System.out.println(kmp(string.toCharArray(), pattern.toCharArray()));
    }

    private static boolean kmp(char[] string, char[] pattern) {
        int[] lps = lps(pattern);
        System.out.println(lps);
        return true;
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
