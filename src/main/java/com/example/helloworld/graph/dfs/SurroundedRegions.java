package com.example.helloworld.graph.dfs;

/**
 *
 * leetcode 130. Surrounded Regions
 *
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 * Example 2:
 *
 * Input: board = [["X"]]
 * Output: [["X"]]
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 */
public class SurroundedRegions {

    int m,n;

    /**
     * 1. set the regions linked to boundaries to a different character.
     * 2. now iterate through the board and set character accordingly.
     * @param board
     */
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        //make all the groups linked to boundaries
        // top row
        for(int i=0; i<n; ++i){
            if(board[0][i] == 'O')
                dfs(board, 0, i);
        }

        // right most column
        for(int i=0; i<m; ++i){
            if(board[i][n-1] == 'O')
                dfs(board, i, n-1);
        }

        // lowest row
        for(int i=0; i<n; ++i){
            if(board[m-1][i] == 'O')
                dfs(board, m-1, i);
        }

        // first col
        for(int i=0; i<m; ++i){
            if(board[i][0] == 'O')
                dfs(board, i, 0);
        }

        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(board[i][j] == 'T')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        if(i>=m || j>=n || i<0 || j<0 || board[i][j]=='X' || board[i][j]=='T')
            return;

        board[i][j] = 'T';

        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }
}