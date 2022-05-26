package com.example.helloworld.interviews.sahil.microsort;

/**
 * leetcode https://leetcode.com/problems/maximum-number-of-balloons/
 * and backtracking question as below.
 */
public class MicrosoftCodilityTest3Azure {
    // question 2 is as below
    // question 1 is from leetcode : https://leetcode.com/problems/maximum-number-of-balloons/
}

/**
 * Example test:   ['.##.#', '#.#..', '#...#', '#.##.']
 * OK
 *
 * Example test:   ['.#..#', '##..#', '...#.']
 * OK
 *
 * Example test:   ['##.', '#.#', '.##']
 * OK
 *
 * Example test:   ['...', '...', '...']
 * OK
 *
 * simple (Simple hand-written test cases.)
 * OK
 *
 * one_size_ships (Boards containing only ships of size 1 placed in a checkerboard pattern.)
 * OK
 *
 * ships_at_the_edges (All ships are placed at the edges of the board.)
 * OK
 *
 * rectangular_ships (Boards containing only rectangular ships.)
 * OK
 *
 * non_rectangular_ships (Boards containing only L-shaped ships of size 3.)
 * OK
 *
 * random_boards (Random boards.)
 * OK
 *
 * corner (Corner test cases.)
 * OK
 *
 * one_ship (There is only one ship on the board.)
 * OK
 */
class MicrosoftCodilityTest3AzureBattleshipGame {
    int m,n;
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};    // all 4 directions

    public int[] solution(String[] B) {
        m = B.length;
        n = B[0].length();
        int ans[] = new int[3];

        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(B[i].charAt(j) == '#'){
                    count = helper(B, i, j);
                    ans[count-1]++; // boat count increased
                }
            }
        }
        return ans;
    }

    private int helper(String[] B, int i, int j){
        if(i<0 || j<0 || i>=m || j>=n || B[i].charAt(j) == '.')
            return 0;

        int ans = 1;

        String str = B[i];
        str = str.substring(0,j)+'.'+str.substring(j+1);
        B[i] = str;

        for(int[] d: dir){
            ans += helper(B, i+d[0], j+d[1]);
        }
        return ans;
    }
}


class MicrosoftCodilityTest3AzureProblem1 {
    public int solution(String S) {
        return helper(S, "BALLOON");
    }

    private int helper(String text, String pattern) {
        int n = text.length(), m = pattern.length(), answer = Integer.MAX_VALUE;
        int freqInText[] = new int[26];
        int freqInPattern[] = new int[26];

        // Frequency in text.
        for (int i = 0; i < n; i++) {
            freqInText[text.charAt(i) - 'A']++;
        }
        // Frequency in pattern.
        for (int i = 0; i < m; i++) {
            freqInPattern[pattern.charAt(i) - 'A']++;
        }

        // comparing frequency
        for (int i = 0; i < 26; i++) {
            if (freqInPattern[i] > 0) {
                answer = Math.min(answer, freqInText[i] / freqInPattern[i]);
            }
        }

        return answer;
    }
}
