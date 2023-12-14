package com.example.helloworld.array.easy;

/**
 * leetcode 1582. Special Positions in a Binary Matrix
 * https://leetcode.com/problems/special-positions-in-a-binary-matrix/
 * similar problem : https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/
 *
 * Given an m x n binary matrix mat, return the number of special positions in mat.
 *
 * A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
 * Output: 1
 * Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
 * Example 2:
 *
 *
 * Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * Explanation: (0, 0), (1, 1) and (2, 2) are special positions.
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * mat[i][j] is either 0 or 1.
 */
public class SpecialPositionsinaBinaryMatrix {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowSum = new int[m];
        int[] colSum = new int[n];
        int count = 0;

        // Calculate the sum of each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }

        // Check for special positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {
        SpecialPositionsinaBinaryMatrix obj = new SpecialPositionsinaBinaryMatrix();
        // Example usage:
        int[][] mat1 = {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        System.out.println("Output for mat1: " + obj.numSpecial(mat1)); // Output: 1

        int[][] mat2 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println("Output for mat2: " + obj.numSpecial(mat2)); // Output: 3
    }
}



class SpecialPositionsInMatrix {
    public static int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    // Check row and column for other non-zero elements
                    boolean isSpecial = true;
                    for (int k = 0; k < m; k++) {
                        if (k != i && mat[k][j] == 1) {
                            isSpecial = false;
                            break;
                        }
                    }
                    for (int k = 0; k < n; k++) {
                        if (k != j && mat[i][k] == 1) {
                            isSpecial = false;
                            break;
                        }
                    }

                    if (isSpecial) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Example usage:
        int[][] mat1 = {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        System.out.println("Output for mat1: " + numSpecial(mat1)); // Output: 1

        int[][] mat2 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println("Output for mat2: " + numSpecial(mat2)); // Output: 3
    }
}
