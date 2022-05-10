package com.example.helloworld.interviews.sahil.microsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * see reference screenshots for reference and problem statements.
 */
public class MicrosoftCodilityTest {
}

class MicrosoftCodilityTestProblem1 {
    public int solution(String s) {
        // write your code in Java SE 8
        int n = s.length();
        int ans = 0;

        int xLeft = 0, xRight = 0;
        int yLeft = 0, yRight = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'x') xRight++;
            if (ch == 'y') yRight++;
        }

        for (int i = 0; i < n - 1; i++) {
            char ch = s.charAt(i);

            if (ch == 'x') {
                xLeft++;
                xRight--;
            } else if (ch == 'y') {
                yLeft++;
                yRight--;
            }

            if ((xLeft == yLeft) || (xRight == yRight))
                ans++;
        }
        return ans;
    }
}


class MicrosoftCodilityTestProblem2 {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int nn = A.length;
        int[][] intervals = new int[nn][2];
        for (int i = 0; i < nn; i++) {
            intervals[i][0] = A[i];
            intervals[i][1] = B[i];
        }
        // sort intervals
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        ArrayList<Integer[]> res = new ArrayList<>();

        int n = intervals.length;
        int i = 0;

        for (i = 0; i < n; ++i) {
            int start = intervals[i][0], end = intervals[i][1];

            while (i + 1 <= n - 1 && intervals[i + 1][0] <= end) {
                start = Math.min(start, intervals[i + 1][0]);
                end = Math.max(end, intervals[i + 1][1]);
                ++i;
            }
            res.add(new Integer[]{start, end});
        }

        // No need for this section as we only need the size | convert res list to 2d array and return.
        int[][] ans = new int[res.size()][2];
        for (i = 0; i < res.size(); ++i) {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }
        return res.size();
    }
}