package com.example.helloworld.array.others;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 773. Sliding Puzzle , hard , asked in Uber , Airbnb
 * Code Harmony Video Explanation : https://youtu.be/MOliFyItS6A
 *
 * On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0. A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 *
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 *
 * Given the puzzle board board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 * Example 2:
 *
 *
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 * Example 3:
 *
 *
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 *
 *
 * Constraints:
 *
 * board.length == 2
 * board[i].length == 3
 * 0 <= board[i][j] <= 5
 * Each value board[i][j] is unique.
 */

public class SlidingPuzzle {

    // Direction map for valid moves from each position on the flattened board.
    // Each index corresponds to a position on the 1D representation of the board,
    // and the values are the indices it can swap with (adjacent tiles).
    private final int[][] dir = {
            {1, 3},    // Position 0 can swap with positions 1 and 3.
            {0, 2, 4}, // Position 1 can swap with positions 0, 2, and 4.
            {1, 5},    // Position 2 can swap with positions 1 and 5.
            {0, 4},    // Position 3 can swap with positions 0 and 4.
            {3, 5, 1}, // Position 4 can swap with positions 3, 5, and 1.
            {4, 2}     // Position 5 can swap with positions 4 and 2.
    };

    /**
     * Solves the sliding puzzle and returns the minimum number of moves required to solve it.
     * If solving is impossible, returns -1.
     *
     * @param board The 2x3 puzzle board as a 2D array.
     * @return The least number of moves to solve the puzzle or -1 if unsolvable.
     */
    public int slidingPuzzle(int[][] board) {
        // Convert the board into a string representation for easier manipulation.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }

        // Map to track visited states and their minimum move counts.
        Map<String, Integer> visited = new HashMap<>();

        // Perform a recursive DFS to explore all possible states.
        sol(sb.toString(), visited, sb.toString().indexOf("0"), 0);

        // Return the number of moves to reach the target state or -1 if unsolvable.
        return visited.getOrDefault("123450", -1);
    }

    /**
     * Recursive helper function to explore all possible board states using DFS.
     *
     * @param state   Current board state as a string.
     * @param visited Map to store the minimum moves for each visited state.
     * @param zeroidx Index of the empty tile (0) in the string representation.
     * @param moves   Current move count.
     */
    void sol(String state, Map<String, Integer> visited, int zeroidx, int moves) {
        // If the current state has been visited with fewer or equal moves, skip it.
        if (visited.containsKey(state) && visited.get(state) <= moves) {
            return;
        }

        // Mark the current state as visited with the minimum move count.
        visited.put(state, moves);

        // Explore all valid moves from the current position of the empty tile (0).
        for (int p : dir[zeroidx]) {
            // Generate a new state by swapping 0 with an adjacent tile.
            String newState = swap(state, zeroidx, p);

            // Recurse with the new state, updating the zero index and move count.
            sol(newState, visited, p, moves + 1);
        }
    }

    /**
     * Swaps two characters in a string and returns the new string.
     *
     * @param str Original string.
     * @param i   Index of the first character to swap.
     * @param j   Index of the second character to swap.
     * @return The new string with the characters swapped.
     */
    private String swap(String str, int i, int j) {
        // Use StringBuilder to perform the swap operation.
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
