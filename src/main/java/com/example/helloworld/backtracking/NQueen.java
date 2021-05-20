package com.example.helloworld.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 51. N-Queens
 *
 * (took reference from pepcoding bro's video)
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 * Example 2:
 *
 * Input: n = 1
 * Output: [["Q"]]
 */
public class NQueen {

    public List<List<String>> solveNQueens(int n) {
        boolean col[] = new boolean[n];
        boolean ndiag[] = new boolean[2*n-1];
        boolean rdiag[] = new boolean[2*n-1];
        int board[][] = new int[n][n];
        List<List<String>> res = new ArrayList<>();

        solve(board,col,ndiag,rdiag,res,0);
        return res;
    }

    private void solve(int[][] board, boolean[] col, boolean[] ndiag, boolean[] rdiag,
                       List<List<String>> res,int row){
        if(row==board.length){
            addInRes(board, res);
            return;
        }
        for(int i=0;i<board.length;i++){
            if(col[i]==true || ndiag[row+i]==true || rdiag[row-i+board.length-1]==true){
                continue;
            }else{
                board[row][i] = 1;  // queen rakho, col aur dono diagonal invalidate karo
                col[i] = true;
                ndiag[row+i] = true;
                rdiag[row-i+board.length-1] = true;

                solve(board,col,ndiag,rdiag,res,row+1);

                board[row][i] = 0;      // vapsi mai sab kuch undo karo
                col[i] = false;
                ndiag[row+i] = false;
                rdiag[row-i+board.length-1] = false;
            }
        }
    }

    private void addInRes(int[][] board, List<List<String>> res){
        List<String> ans = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<board.length;j++){
                sb.append(board[i][j]==0 ? "." : "Q");
            }
            ans.add(sb.toString());
        }
        res.add(ans);
    }
}