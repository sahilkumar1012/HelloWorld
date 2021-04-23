package com.example.helloworld.dump;

public class GfG{

    private final static int M = 100;

    public static String alternateSort(String A)
    {
        int n = A.length();
        char[] s = A.toCharArray();
        int[] c1 = new int[M];
        int[] c2 = new int[M];

        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(s[i]))
                c2[s[i] - 'A']++;
            else
                c1[s[i] - 'a']++;
        }

        int i = 0, j = 0, k = 0;
        while (k < n)
        {
            while (i < M && c2[i] == 0)
                i++;
            if (i < M) {
                s[k++] = (char)('A' + i);
                c2[i]--;
            }
            while (j < M && c1[j] == 0)
                j++;

            if (j < M) {
                s[k++] = (char)('a' + j);
                c1[j]--;
            }
        }

        return (new String(s));
    }

    // Driver function
    public static void main(String argc[]){

//        String str = "bAwutndekWEdkd";
        String str = "WdSifVREwPTeL";
        System.out.println(alternateSort(str));
    }

}

