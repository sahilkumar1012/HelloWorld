package com.example.helloworld.backtracking;

/**
 * leetcode 79. Word Search
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 */
public class WordSearch {

    int m;
    int n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if( sol(board, new boolean[m][n], word, 0, i, j) )
                    return true;
            }
        }
        return false;
    }

    // backtracking
    private boolean sol(char[][] board, boolean[][] visited, String word, int idx, int i, int j){
        if(idx == word.length())        // found the word
            return true;

        if( i<0 || j<0 || i>=m || j>=n ) // stepped out of the board.
            return false;

        if(!visited[i][j] && word.charAt(idx) == board[i][j]){
            idx++;
            visited[i][j] = true;
            boolean result = false;

            // backtrack in all 4 directions
            result |= sol(board, visited, word, idx, i+1, j);
            result |= sol(board, visited, word, idx, i-1, j);
            result |= sol(board, visited, word, idx, i, j+1);
            result |= sol(board, visited, word, idx, i, j-1);

            if(result)
                return true;

            visited[i][j] = false;
            idx--;
        }

        return false;
    }


    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        boolean result = ws.exist(new char[][]{{'a'}}, "a");
        System.out.println(result);
    }
}