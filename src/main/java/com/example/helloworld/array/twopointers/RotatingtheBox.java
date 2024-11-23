package com.example.helloworld.array.twopointers;

/**
 * leetcode 1861. Rotating the Box
 * Code Harmony Video Explanation: https://youtu.be/lUAmqyim-E4


 You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:

 A stone '#'
 A stationary obstacle '*'
 Empty '.'
 The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.

 It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.

 Return an n x m matrix representing the box after the rotation described above.



 Example 1:



 Input: box = [["#",".","#"]]
 Output: [["."],
 ["#"],
 ["#"]]
 Example 2:



 Input: box = [["#",".","*","."],
 ["#","#","*","."]]
 Output: [["#","."],
 ["#","#"],
 ["*","*"],
 [".","."]]
 Example 3:



 Input: box = [["#","#","*",".","*","."],
 ["#","#","#","*",".","."],
 ["#","#","#",".","#","."]]
 Output: [[".","#","#"],
 [".","#","#"],
 ["#","#","*"],
 ["#","*","."],
 ["#",".","*"],
 ["#",".","."]]


 Constraints:

 m == box.length
 n == box[i].length
 1 <= m, n <= 500
 box[i][j] is either '#', '*', or '.'.


 */
public class RotatingtheBox {

    /**
     * Rotates the box 90 degrees clockwise and applies gravity to stones.
     *
     * @param box The input m x n matrix representing the box.
     * @return The resulting n x m matrix after rotation and gravity.
     */
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length; // Number of rows in the original box
        int n = box[0].length; // Number of columns in the original box

        // Initialize the result matrix with dimensions n x m (rotated dimensions)
        char[][] res = new char[n][m];

        // Step 1: Rotate the box 90 degrees clockwise
        // For each cell in the original box, map it to its rotated position in the result matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][m - 1 - i] = box[i][j];
            }
        }

        // Step 2: Apply gravity to make the stones ('#') fall in the rotated matrix
        // Traverse each column of the rotated matrix
        for (int j = 0; j < m; j++) {
            int lowest = n - 1; // Start with the lowest available position for stones in the column

            // Traverse the column from bottom to top
            for (int i = n - 1; i >= 0; i--) {
                if (res[i][j] == '*') {
                    // If an obstacle ('*') is encountered, update the lowest position to one above it
                    lowest = i - 1;
                } else if (res[i][j] == '#') {
                    // If a stone ('#') is encountered, move it to the lowest available position
                    res[i][j] = '.'; // Clear the original position
                    res[lowest][j] = '#'; // Place the stone at the lowest position
                    lowest--; // Update the lowest available position
                }
            }
        }

        // Return the final matrix after rotation and gravity
        return res;
    }
}
