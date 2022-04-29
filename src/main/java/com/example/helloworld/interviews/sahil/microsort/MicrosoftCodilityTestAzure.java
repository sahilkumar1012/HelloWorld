package com.example.helloworld.interviews.sahil.microsort;

import java.util.*;

/**
 * https://leetcode.com/discuss/interview-question/1165018/Microsoft-or-OA-or-India/910820
 *
 * problem related to merging
 *
 * microsoft codility test
 *
 * There are N cranes (numbered from O to N-1) arranged in a line alona a road. Road begins
 * at position O. The K-th crane is located at distance PK from the beainnina
 * of the road and its
 * igth is
 * equal to AK. The cranes
 * cannot change thei
 * - positions. There is a package, initiallv located at position B. that has to be moved bv the cranes to position E. The K-th crane can pick uo the package only
 * if the distance between its position and the packade position is less than or equal to AlKI (the package is within arm ranae from the crane's position). A package can be moved bv a crane to an
 * arbitrarv position within the crane's arm reach (between PIK] - AlKl and PiK] + AlK] for the K-th crane
 * For example, if PK = 5 and AK = 3, the K-th crane can move packages anvwhere between positio
 * and 8, including both of the boundaries
 *
 * DeTermine
 * intIlll
 * Write a Tunction:
 * that.
 * oven two
 * Taras on
 * and P and false other
 * Examples:
 * 1. Given A=21. P=5.1. B=3.E=6.
 * - AllI
 * Pli] + Allis;
 * (interva
 * To leave editor use Ctr + Shift + M
 * Test Output
 * • Run Code
 * 2. Given A = I2. 11. P = 15.1l. B = 2. E = 6. vour function should return false. The crane number zero cannot reach the packaae at its initial position. The crane number one can move it from position 2
 * to anv position between 0 and 2. The crane number zero still will not be able to reach package at anv of these positions, so it is not possible to move package to position 6
 */
class Problem1 {
    public boolean solution(int[] A, int[] P, int B, int E) {
        if(B == E) return true;
        int[][] intervals = new int[P.length][];

        for(int i = 0 ; i < P.length ; i++)
            intervals[i] = new int[]{ P[i] - A[i] , P[i] + A[i]};

        int[][] merged = mergeIntervals(intervals);
        int low = 0, high = merged.length - 1;
        int start = Math.min(B, E), end = Math.max(B, E);

        while (low < high) {
            int mid = (low + high) >>> 1;
            if (merged[mid][0] == start) return end <= merged[mid][1];
            if (merged[mid][0] < start) low = mid + 1;
            else high = mid;
        }
        return check(merged[low], start, end);
    }

    public boolean check(int[] interval, int start, int end) {
        return start >= interval[0] && end <= interval[1];
    }

    public int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length == 0) return new int [][]{};
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));
        ArrayList<int[]> list = new ArrayList<>();
        int i = intervals[0][0];
        int j = intervals[0][1];
        boolean first = true;
        for (int[] interval : intervals) {
            if (first) {
                first = false; continue;
            }
            if (interval[0] <= j) {
                j = Math.max(j, interval[1]);
            } else {
                list.add(new int[]{i, j});
                i = interval[0];
                j = interval[1];
            }
        }
        list.add(new int[]{i, j});
        return list.toArray(new int[list.size()][2]);
    }
}

/**
 * take reference from : https://leetcode.com/discuss/interview-question/1429168/American-Express-OA-or-2021-or-India
 *
 * Given a rectangular grid containing houses built in some cells, find the number of empty cells at a distance of at most K to every house.
 *
 * A retail store chain wants to expand into a new neighborhood. To maximize the number of clients, the new branch should be at a distance of no more than K from all the houses in the neighborhood. A is a matrix of size N x M, representing the neighborhood as a rectangular grid, in which each cell is either an integer 0 (an empty plot) or 1 (a house). The distance between two cells is calculated as the minimum number of cell borders (regardless of whether the cells on the way are empty or occupied) that one has to cross to move from the source to the target cell (without moving through corners). A store can be only built on an empty plot. How many suitable locations are there?
 *
 * For example, given K = 2 and matrix A = [ [0, 0, 0, 0], [0, 0, 1, 0], [1, 0, 0, 1] ], houses are located in cells with coordinates (2, 3), (3, 1) and (3, 4). We can build a new store on two empty plots that are close enough to all the houses. The first possible empty plot is located at (3, 2). The distance to the first house at (2,3) is 2, the distance to the second house at (3, 1) is 1, and the third house at (3, 4) is at a distance of 2. The second possible empty plot is located at (3, 3). The distances to the first, second and third houses are respectively, 1, 2 and 1.
 *
 * A[1] = 0000, A[2] = 0010, A[3] = 1001. Cells at a distance of less than or equal to 2 from all houses are marked in yellow.
 *
 * Write a function:
 * int solution(int K, int arr[][])
 *
 * which, given a positive integer K and matrix A of size N x M, returns the number of empty plots that are close enough to all the houses.
 *
 * Examples:
 *
 * Given K = 2 and A = [ [0, 0, 0, 0], [0, 0, 1, 0], [1, 0, 0, 1] ], the function should return 2, as explained above.
 *
 * Given K = 1 and A = [ [0, 1], [0, 0] ], the function should return 2. We can build a store on empty plots at (1, 1) and (2, 2).
 *
 * A[1] = 01, A[2] = 00. Cells at a distance of less than or equal to 1 from all houses are marked in yellow.
 *
 * Given K = 4 and A = [ [0, 0, 0, 1], [0, 1, 0, 0], [0, 0, 1, 0], [1, 0, 0, 0], [0, 0, 0, 0] ], the function should return 8. Stores can be built on the following plots: (1, 1), (1, 2), (2, 1), (2, 3), (3, 2), (3, 4), (4, 3) and (4, 4).
 * A[1] = 0001, A[2] = 0100, A[3] = 0010, A[4] = 1000, A[5] = 0000. Cells at distance of less than or equal to 4 from all houses are marked in yellow.
 * Write an efficient algorithm for the following assumptions:
 *
 * · K is an integer within the range [1..800];
 *
 * · N and M are integers within the range [2..400];
 *
 * · each element of matrix A is an integer within the range [0..1];
 *
 * · there is at least one house.
 *
 * [0, 0, 0, 0],
 * [0, 0, 1, 0],
 * [1, 0, 0, 1]
 */
class Problem2{

    /**
     * solution description :
     * Description
     * Consider a 5 x 5 grid where house is located at (2,2). Allowable distance k = 2.
     * 0 0 0 0 0
     * 0 0 0 0 0
     * 0 0 1 0 0
     * 0 0 0 0 0
     * 0 0 0 0 0
     *
     * We notice the valid spots on which we can build a store are as follows
     *
     * 0 0 x 0 0
     * 0 x 0 x 0
     * x 0 1 0 x
     * 0 x 0 x 0
     * 0 0 x 0 0
     *
     * Coordinates along ( diagonals are mentioned in the above grid with x as boundary )
     * -- northwest diagonal: (0,2), (1,1), (2,0) -> all add up to 2; x + y = 2
     * -- southeast diagonal: (2,4), (3,3), (4,2) -> all add up to 6; x + y = 6
     * -- northeast diagonal: (0,2), (1,3), (2,4) -> x - y = -2 for all; x - y = -2
     * -- southwest diagonal: (2,0), (3,1), (4,2) -> x - y = 2 for all; x - y = 2
     *
     * Therefore, for a given store located at (a, b), house located at (x,y) is within k distance from store if its coordinates meets the following conditions
     *
     * a + b - k <= x + y <= a + b + k
     * a - b - k <= x - y <= a - b + k
     * For each of the houses, we can determine these 4 local diagonals by calculating both bounds for x + y and x - y, then record the max/min bounds for all the houses to get the 4 global (diagonal) bounds
     * Subsequently, we can check all empty 'plots' and add them to the final result count if they fall within the range
     * @param K
     * @param A
     * @return
     */
    public int solution(int K, int[][] A) {
        int m = A.length, n = A[0].length, k = K;

        Set<String> houses = new HashSet<>(); //for coordinates

        //Finding the coordinates
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    houses.add(i + "&" + j);
                }
            }
        }
        int northwest = Integer.MIN_VALUE;
        int southeast = Integer.MAX_VALUE;

        int southwest = Integer.MIN_VALUE;
        int northeast = Integer.MAX_VALUE;

        for (String house : houses) {
            String arr[] = house.split("&");
            int x = Integer.valueOf(arr[0]);
            int y = Integer.valueOf(arr[1]);
            northwest = Math.max(northwest, x - y - k);
            southeast = Math.min(southeast, x - y + k);

            southwest = Math.max(southwest, x + y - k);
            northeast = Math.min(northeast, x + y + k);
        }
        int ans = 0;
        for (int x = 0; x < m; x++)
            for (int y = 0; y < n; y++)
                if (A[x][y] == 0)
                    if ((northwest <= x - y && x - y <= southeast)
                            && southwest <= x + y && x + y <= northeast)
                        ans += 1;

        return ans;
    }

}