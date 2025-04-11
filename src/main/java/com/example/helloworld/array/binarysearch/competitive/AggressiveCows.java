package com.example.helloworld.array.binarysearch.competitive;

import java.util.*;
/**
 * spoj : https://www.spoj.com/problems/AGGRCOW/
 *
 * Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1 ... xN (0 <= xi <= 1,000,000,000).
 *
 * His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
 *
 * Input
 *
 * t – the number of test cases, then t test cases follows.
 * * Line 1: Two space-separated integers: N and C
 * * Lines 2..N+1: Line i+1 contains an integer stall location, xi
 *
 * Output
 *
 * For each test case output one integer: the largest minimum distance.
 *
 * Example
 *
 * Input:
 *
 * 1
 * 5 3
 * 1
 * 2
 * 8
 * 4
 * 9
 * Output:
 *
 * 3
 * Output details:
 *
 * FJ can put his 3 cows in the stalls at positions 1, 4 and 8,
 * resulting in a minimum distance of 3.
 */
public class AggressiveCows {

    public static boolean canPlaceCows(int[] stalls, int cows, int minDist) {
        int count = 1;
        int lastPos = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= minDist) {
                count++;
                lastPos = stalls[i];
                if (count == cows) return true;
            }
        }

        return false;
    }

    public static int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int best = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canPlaceCows(stalls, cows, mid)) {
                best = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return best;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int c = sc.nextInt();
            int[] stalls = new int[n];
            for (int i = 0; i < n; i++) {
                stalls[i] = sc.nextInt();
            }

            System.out.println(aggressiveCows(stalls, c));
        }

        sc.close();
    }
}
