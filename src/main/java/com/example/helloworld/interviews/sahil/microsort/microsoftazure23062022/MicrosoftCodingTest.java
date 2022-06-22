package com.example.helloworld.interviews.sahil.microsort.microsoftazure23062022;

public class MicrosoftCodingTest {
    // check for screenshots
}
class SolutionMicrosoftProblem2 {
    public static void main(String[] args) {
        System.out.println(new SolutionMicrosoftProblem2().solution(new String[]{"X.....>", "..v..X.", ".>..X..", "A......"}));
    }
    int m,n;
    public boolean solution(String[] B) {
        // write your code in Java SE 8
        m = B.length;
        n = B[0].length();

        char[][] matrix = new char[m][n];

        int row = 0;
        for(String s: B){
            int col = 0;
            for(char ch : s.toCharArray()){
                matrix[row][col] = ch;
                col++;
            }
            row++;
        }

        int rowA = -1, colA = -1;
        boolean done = false;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 'A') {
                    rowA = i;
                    colA = j;
                    matrix[i][j] = '.';
                    done = true;
                    break;
                }
            }
            if(done) break;
        }

        // process matrix
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == '>') {
                    int idx = j;
                    matrix[i][j] = '.';
                    while(idx<n && (matrix[i][idx] == '.' || matrix[i][idx] == 'Y') ) {
                        matrix[i][idx] = 'Y';
                        idx++;
                    }
                    matrix[i][j] = 'X';
                }
                if(matrix[i][j] == 'v') {
                    int idx = i;
                    matrix[i][j] = '.';
                    while( idx < m && (matrix[idx][j] == '.' || matrix[idx][j] == 'Y') ){
                        matrix[idx][j] = 'Y';
                        idx++;
                    }
                    matrix[i][j] = 'X';
                }
                if(matrix[i][j] == '^') {
                    int idx = i;
                    matrix[i][j] = '.';
                    while( idx >=0 && (matrix[idx][j] == '.' || matrix[idx][j] == 'Y') ){
                        matrix[idx][j] = 'Y';
                        idx--;
                    }
                    matrix[i][j] = 'X';
                }
                if(matrix[i][j] == '<') {
                    int idx = j;
                    matrix[i][j] = '.';
                    while(idx>=0 && (matrix[i][idx] == '.' || matrix[i][idx] == 'Y') ) {
                        matrix[i][idx] = 'Y';
                        idx--;
                    }
                    matrix[i][j] = 'X';
                }
            }
        }

        if(matrix[rowA][colA] != '.')
            return false;

        // check for path
        return dfs(rowA, colA, matrix);
    }

    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};    // all 4 directions

    private boolean dfs(int i, int j, char[][] matrix) {
        if(i<0 || j<0 || i>=m || j>=n || matrix[i][j] != '.'){
            return false;
        }
        if(i==m-1 && j==n-1) return true;

        matrix[i][j] = 'K';
        boolean ans = false;
        for(int[] d : dir){
            ans |= dfs(i + d[0], j + d[1], matrix);
        }
        matrix[i][j] = '.';

        return ans;
    }
}

class SolutionMicrosoftProblem1 {
    public int solution(int N, int K) {
        // write your code in Java SE 8
        int ans = 0;
        while(K > 0) {
            if(N == 0) return -1; // No glasses left
            if(N >= K) {
                // K litres glass available, so just one biggest glass is sufficient
                ans++;
                break;
            }
            else {
                // Need to take a biggest glass, updating N,K accordingly
                ans++;
                K = K-N;
                N = N-1;
            }
        }
        return ans;
    }
}