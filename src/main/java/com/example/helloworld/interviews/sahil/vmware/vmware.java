package com.example.helloworld.interviews.sahil.vmware;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * vmware coding test
 */
public class vmware {
    // check com.example.helloworld.interviews.sahil.vmware.Bingo.getWinningCombo for solution and screenshot in the current directory for problem statement.
}

class Bingo {

    /*
    solution function
     */
    public static String getWinningCombo(String[][] ticket, int[] sequence) {
        Set<Integer> corners = new HashSet<>();
        Set<Integer> first = new HashSet<>();
        Set<Integer> middle = new HashSet<>();
        Set<Integer> last = new HashSet<>();
        Set<Integer> all = new HashSet<>();

        for(int i=0; i<3; i++){
            for(int j=0; j<9; j++){
                if(ticket[i][j] != null && !ticket[i][j].equals("")){
                    all.add(Integer.parseInt(ticket[i][j]));
                }
            }
        }
        int as = all.size();

        boolean lt = false;
        // first row
        for(int i=0; i<9; i++){
            if(ticket[0][i]!= null && !ticket[0][i].equals(""))    {
                first.add(Integer.parseInt(ticket[0][i]));
                if(!lt){
                    corners.add(Integer.parseInt(ticket[0][i]));
                    lt = true;
                }
            }
        }
        // middle row
        for(int i=0; i<9; i++){
            if(ticket[1][i]!= null && !ticket[1][i].equals(""))
                middle.add(Integer.parseInt(ticket[1][i]));
        }
        // third row
        boolean lb = false;
        for(int i=0; i<9; i++){
            if(ticket[2][i]!= null && !ticket[2][i].equals(""))    {
                last.add(Integer.parseInt(ticket[2][i]));
                if(!lb){
                    corners.add(Integer.parseInt(ticket[2][i]));
                    lb = true;
                }
            }
        }

        // rt & rb
        for(int i=8; i>=0; i--){
            if(ticket[0][i]!= null && !ticket[0][i].equals(""))    {
                corners.add(Integer.parseInt(ticket[0][i]));
                break;
            }
        }
        for(int i=8; i>=0; i--){
            if(ticket[2][i]!= null && !ticket[2][i].equals(""))    {
                corners.add(Integer.parseInt(ticket[2][i]));
                break;
            }
        }

        String ans = "";
        for(int i : sequence){
            first.remove(i);
            corners.remove(i);
            middle.remove(i);
            last.remove(i);
            all.remove(i);

            if(corners.isEmpty()){
                ans = i + "C"; break;
            }
            if(first.isEmpty()){
                ans = i + "FR"; break;
            }
            if(middle.isEmpty()){
                ans = i + "MR"; break;
            }
            if(last.isEmpty()){
                ans = i + "LR"; break;
            }
            if(all.size() <= as-7){
                ans = i + "ES"; break;
            }
        }

        return ans.equals("") ? "NW" : ans;
    }


    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

                String[][] ticket = new String[3][9];

                // Read first row of the ticket
                String[] row1 = readFromInput(bufferedReader).trim().split(",");
                for (int i = 0; i < row1.length; i++) {
                    ticket[0][i] = row1[i].trim();
                }

                // Read second row of the ticket
                String[] row2 = readFromInput(bufferedReader).trim().split(",");
                for (int i = 0; i < row2.length; i++) {
                    ticket[1][i] = row2[i].trim();
                }

                // Read third row of the ticket
                String[] row3 = readFromInput(bufferedReader).trim().split(",");
                for (int i = 0; i < row3.length; i++) {
                    ticket[2][i] = row3[i].trim();
                }

                // Read co-ordinatror sequence
                String[] seq =  readFromInput(bufferedReader).trim().split(",");
                int[] sequence;
                sequence = new int[seq.length];
                for (int i = 0; i < seq.length; i++) {
                    sequence[i] = Integer.parseInt(seq[i].trim());
                }

                //Read expected result
                String expectedWinningStreak = readFromInput(bufferedReader).trim();

                String winningStreak = Bingo.getWinningCombo(ticket, sequence);

                bufferedWriter.write(String.valueOf(expectedWinningStreak.equals(winningStreak)));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFromInput(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine().trim();
    }


}

