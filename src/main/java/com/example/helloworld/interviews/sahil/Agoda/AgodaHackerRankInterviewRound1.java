package com.example.helloworld.interviews.sahil.Agoda;


public class AgodaHackerRankInterviewRound1 {
}



class Solution {

    public static void main(String[] args) {
        char [][] playground =  {
                {'S', '0', '1', '0'},
                {'1', '0', '1', '1'},
                {'1', '0', '1', '1'},
                {'1', '1', '1', 'X'}
        };

//        Variation2 :

        //S can move atmost 1 each round
        //X can move atmost 1 each round
        //how many round does it take for S and X meet each other optimally
        /*
        6
        n/2;
        n/2+1
        */
        Solution obj = new Solution();
        System.out.println("output is : " + obj.findMinPath(playground));

    }

    // solution.
    char[][] grid;
    int[][] dir = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    int[][] memo;
    int m; // no of rows
    int n; // cols

    public int findMinPath(char[][] grid){
        this.grid=grid;
        m = grid.length;
        n = grid[0].length;

        memo = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                memo[i][j] = Integer.MAX_VALUE;
            }
        }

        return sol(0, 0);
    }

    // 1 time for every poss of sol m*n O(M*N)

    private int sol(int i, int j){
        // -ve case
        if(i<0 || j<0 || i==m || j==n || grid[i][j] == '0' || grid[i][j] == '2')
            return 100000000; // infinity

        if(grid[i][j] == 'X')
            return 0;

        // check in cache before precessing
        if(memo[i][j] != Integer.MAX_VALUE){
            return memo[i][j];
        }

        grid[i][j] = '2'; // visited
        int min = Integer.MAX_VALUE;
        for(int[] d : dir){
            min = Math.min(min, 1+sol(i + d[0], j + d[1]) );
        }
        grid[i][j] = '1'; // unvisited
        // cache it
        return memo[i][j] = min;
    }
}

// Integer[][] null
// ( i,j) -> min steps from this. to X


// char [][] playground =  {
//     {'S', '1', '1', 'X'},
//     {'1', '0', '1', '1'},
//     {'1', '0', '1', '1'},
//     {'1', '1', '1', '1'}
// }

// ANS: 9, 3

// Find a minimum steps from S to X
// Where is S always at the top left corner [0,0]
// X can be anywhere
// You're only allowed to walk on 1 not 0
// You can walk horizontally and vertically (up or down, left or right)
// The map is randomly generated
