package com.example.helloworld.tests.morganstanley.testdump;

import java.util.HashMap;
import java.util.Map;

public class MorganStanley1 {

}

class MorganStanley2 {
    private Map<String, Integer> memo = new HashMap<>();

    private int dfs(int x, int y) {
        String key = x + "," + y;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (x + y == 0) {
            return 0;
        } else if (x + y == 2) {
            return 2;
        } else {
            Integer ret = Math.min(dfs(Math.abs(x - 1), Math.abs(y - 2)),
                    dfs(Math.abs(x - 2), Math.abs(y - 1))) + 1;
            memo.put(key, ret);
            return ret;
        }
    }

    public int minKnightMoves(int x, int y) {
        return dfs(Math.abs(x), Math.abs(y));
    }
}

class IntegerPartition {
    static int count=0;
    public static void partition(int total, int k) {
        if (total == 0) {
            count++;
            return;
        }
        for (int i = Math.min(k, total); i >= 1; i--) {
            partition(total - i, i);
        }
    }
    private static int numberOfWaysForSum(int total, int k) {
        final int M = 1000000007;
        int[][] a = new int[k + 1][total + 1];
        for (int i = 1; i <= total; i++) {
            a[1][i] = 1;
        }
        for (int i = 1; i <= k; i++) {
            a[i][0] = 1;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= total; j++) {
                if (j >= i) {
                    a[i][j] = a[i][j - i] + a[i - 1][j];

                } else {
                    a[i][j] = a[i - 1][j];
                }

            }
        }
        return a[k][total];
    }
    public static void main(String[] args) {
//        partition(5,3);
//        System.out.println("Count: "+count);
//
//        count = 0;
//        partition(4,2);
//        System.out.println("Count: "+count);


        System.out.println(numberOfWaysForSum(5,3));
        System.out.println(numberOfWaysForSum(4,2));
    }
}