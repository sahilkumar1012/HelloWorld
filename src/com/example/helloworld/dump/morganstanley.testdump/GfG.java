package com.example.helloworld.dump.morganstanley.testdump;
import java.util.*;

// Java program to find minimum steps to reach to
// specific cell in minimum moves by Knight
class GFG {

    static class cell {
        int x, y;
        int dis;

        public cell(int x, int y, int dis)
        {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    static boolean isInside(int x, int y, int N)
    {
        return (x >= 1 && x <= N && y >= 1 && y <= N);
    }

    static int minStepToReachTarget(
            int kp[], int tp[],
            int n)
    {
        int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

        Vector<cell> q = new Vector<>();

        q.add(new cell(kp[0], kp[1], 0));

        cell t;
        int x, y;
        boolean visit[][] = new boolean[n + 1][n + 1];

//        for (int i = 1; i <= n; i++)
//            for (int j = 1; j <= n; j++)
//                visit[i][j] = false;

        visit[kp[0]][kp[1]] = true;

        while (!q.isEmpty()) {
            t = q.firstElement();
            q.remove(0);

            if (t.x == tp[0] && t.y == tp[1])
                return t.dis;

            for (int i = 0; i < 8; i++) {
                x = t.x + dx[i];
                y = t.y + dy[i];

                if (isInside(x, y, n) && !visit[x][y]) {
                    visit[x][y] = true;
                    q.add(new cell(x, y, t.dis + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static int minMoves(int n, int startRow, int startCol, int endRow, int endCol){
        return minStepToReachTarget(new int[]{startRow+1,startCol+1}, new int[]{endRow+1,endCol+1},n);
    }


    public static void main(String[] args)
    {
        int N = 6;
        int knightPos[] = { 6, 2 };
        int targetPos[] = { 1, 6 };
        System.out.println(
                minStepToReachTarget(
                        knightPos, targetPos, N));
    }
}

// This code contributed by Rajput-Ji