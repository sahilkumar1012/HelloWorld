package com.example.helloworld.trie;

import java.util.ArrayList;
import java.util.List;


/**
 * leetcode 212. Word Search II
 *
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * Example 2:
 *
 *
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 *
 */
public class WordSearchII {

    // trie
    public class Trie {
        Trie[] childern;
        String word;

        public Trie() {
            this.childern = new Trie[26];
            this.word = null;
        }
    }
    public Trie buildTrie(String[] words) {
        Trie root = new Trie();

        for ( String word : words) {
            Trie curr = root;

            for ( char c : word.toCharArray()) {
                int i = c - 'a';

                if (curr.childern[i] == null)
                    curr.childern[i] = new Trie();
                curr = curr.childern[i];
            }
            curr.word = word;
        }
        return root;
    }


    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        Trie root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board,result,root,i,j);
            }
        }

        return result;
    }

    public void dfs(char[][] board, List<String> result, Trie root, int i , int j) {
        char c = board[i][j];

        if (c == '*'|| root.childern[c - 'a'] == null)
            return;

        root = root.childern[c - 'a'];

        if (root.word != null) {
            result.add(root.word);
            root.word = null;
        }

        board[i][j] = '*';

        if (i > 0)
            dfs(board,result,root,i-1,j);
        if (j > 0)
            dfs(board,result,root,i,j-1);
        if (i < board.length - 1)
            dfs(board,result,root,i+1,j);
        if (j < board[0].length - 1)
            dfs(board,result,root,i,j+1);

        board[i][j] = c;
    }
}
