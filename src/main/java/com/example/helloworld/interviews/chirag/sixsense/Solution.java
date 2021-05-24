package com.example.helloworld.interviews.chirag.sixsense;

import java.util.*;

class Index{
    public int x;
    public int y;

    public Index(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return " " +x+ " " +y;
    }
}

/**
 * 6sense coding question
 * Word Seek problem
 *
 * Working solution
 *
 * 1. Word Seek Please read the instructions carefully. Given a grid of letters, find the words in the grid. The letters can be in straight sequence in any of the directions from the first character of the word. All words might not be in the grid. Print the word and the start row and column position for each word that is found. For words that are not found, print -1 for both the row and column position. All indices start from 0 The accepted solution should have the lowest complexity ie. You should iterate over the grid of characters only once (not once per word). ie. If there are "n" words given, don't parse through the grid "n" times. The input words are sorted alphabetically. The output words should also be sorted.
 *
 */
public class Solution {
    HashSet<String> set ;

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
                int i = c - 'A';

                if (curr.childern[i] == null)
                    curr.childern[i] = new Trie();
                curr = curr.childern[i];
            }
            curr.word = word;
        }
        return root;
    }

    public static void main(String[] args) throws Exception {
        List<String> boardStrings = new ArrayList<>();
        String temp = "";

        Scanner in = new Scanner(System.in);
        while( in.hasNextLine() && (temp = in.nextLine()).trim().length()>0 )
            boardStrings.add(temp.trim());

        int row = boardStrings.size();
        int col = boardStrings.get(0).length();
        char[][] board = new char[row][];
        for(int i=0; i<row; i++){
            board[i] = boardStrings.get(i).toCharArray();
        }
//        char[][] board = { { 'A', 'B', 'C', 'D' },
//                { 'P', 'R', 'A', 'T' },
//                { 'K', 'I', 'T', 'A' },
//                {'A', 'N', 'D', 'Y' } };

        List<String> wordList= new ArrayList<>();
        while(in.hasNextLine() && (temp = in.nextLine()).trim().length()>0 )
            wordList.add(temp.trim());

        String[] words = wordList.toArray(new String[wordList.size()]); // new String[wordList.size()];

        List<String> results = new Solution().findWords(board, words);
        for(String res : results){
            System.out.println(res);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        set = new HashSet<>();

        List<String> result = new ArrayList<String>();
        Trie root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board,result,root,i,j, new Index(i,j), 0);
            }
        }

        for( String s : words){
            if(!set.contains(s))
                result.add(s + new Index(-1,-1));
        }

        Collections.sort(result);
        return result;
    }

    public void dfs(char[][] board, List<String> result, Trie root, int i , int j, Index starting, int cond) {
        char c = board[i][j];

        if (c == '*'|| root.childern[c - 'A'] == null)
            return;

        root = root.childern[c - 'A'];

        if (root.word != null) {
            if(!set.contains(root.word))
                set.add(root.word);
            result.add(root.word + starting);              // with starting row and col
            root.word = null;
        }

        board[i][j] = '*';

        if (i > 0 && ( cond == 0 || cond == 1))
            dfs(board,result,root,i-1,j, starting, 1);

        if (j > 0 && ( cond == 0 || cond == 2))
            dfs(board,result,root,i,j-1, starting, 2);

        if (i < board.length - 1 && ( cond == 0 || cond == 3))
            dfs(board,result,root,i+1,j, starting, 3);

        if (j < board[0].length - 1 && ( cond == 0 || cond == 4))
            dfs(board,result,root,i,j+1, starting,4);


        if (i > 0 && j>0 && ( cond == 0 || cond == 5))
            dfs(board,result,root,i-1,j-1, starting, 5);

        if (i<board.length-1 && j > 0 && ( cond == 0 || cond == 6))
            dfs(board,result,root,i+1,j-1, starting, 6);

        if (i < board.length - 1 && j < board[0].length - 1 && ( cond == 0 || cond == 7))
            dfs(board,result,root,i+1,j+1, starting,7);

        if (j < board[0].length - 1 && i>0 && ( cond == 0 || cond == 8))
            dfs(board,result,root,i-1,j+1, starting,8);

        board[i][j] = c;
    }


}
