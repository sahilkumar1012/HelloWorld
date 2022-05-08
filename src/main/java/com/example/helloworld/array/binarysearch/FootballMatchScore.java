package com.example.helloworld.array.binarysearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 *
 * Expedia round 1 interview
 * The number of goals achieved by two football teams in matches in a league is given in the form of two lists. For each match of team B, compute the total number of matches of team A where team A has scored less than or equal to the number of goals scored by team B in that match.
 *
 * <fxtInteger and now Arraycisto();
 *
 * 34
 *
 * 35 36
 *
 * 37
 *
 * for (fatty
 *
 * fet 1ds binariearchften, 6. 11-1. 135
 *
 * ans.add(sc | Chat Window
 *
 * 38
 *
 * 20
 *
 * Example
 *
 * teamA-[1,2,3]
 *
 * teamB-(2,4)
 *
 * Team A has played three matches and has scored teamA-[1, 2, 3] goals in each match respectively. Team B has played two matches and has scored team@-12.4 goals in each match respectively. For 2 goals scored by team B in its first match, team A has 2 matches with scores 1 and 2. For 4 goals scored by team 8 in its second match, team A has 3 matches with scores 1, 2 and 3. Hence, the answer is (2, 3).
 *
 * 40
 *
 * 41
 *
 * return ans
 *
 * 43
 *
 * 43
 *
 * 44
 *
 * Function Description
 *
 * 45 v
 *
 * Complete the function counts in the editor below.
 *
 * //2244
 *
 * public static int binarySearchListIntegers list, fnt start, fet end, fet key) ( while(start e
 *
 * fat aid start (end-start)/;
 *
 * start= id;
 *
 * I
 *
 * if(ist.get(id) > key)
 *
 * 47
 *
 * 43 50
 *
 * counts has the following parameters):
 *
 * int teamAin): first array of positive integers int teamB[m): second array of positive integers
 *
 * Return
 *
 * int(m): an array of m positive integers, one for each teamB[] representing the total number of elements from teamA satisfying teamAls team where Osj<nand 0 si<m in the given order.
 *
 * 52
 *
 * 53
 *
 * start wid1;
 *
 * Constraints
 *
 * 56
 *
 * reture starti
 *
 * 57
 *
 * • 2 sm ms 105
 *
 * 58
 *
 * 59
 *
 * •1 steamAlls 10, where 0 sj<n.
 *
 * •1 steamblis 10", where 0 si <m.
 */
class FootballMatchScore {

    /*
     * Complete the 'counts' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY teamA
     *  2. INTEGER_ARRAY teamB
     */

    /**
     *
     * @param teamA
     * @param teamB
     * @return
     */
    /**
     *  The number of goals achieved by two football teams in matches in a league is given in the form of two lists.
     *  For each match of team B, compute the total number of matches of team A where team A has scored less than or equal to the number of goals scored by team B in that match.
     * @param teamA
     * @param teamB
     * @return
     */
    public static List<Integer> counts(List<Integer> teamA, List<Integer> teamB) {
        // Write your code here

        int l1 = teamA.size();
        Collections.sort(teamA); // 1 2 4 4
        List<Integer> ans = new ArrayList<>();

        for(int i : teamB){
            int idx = binarySearch(teamA, 0, l1-1, i);
            ans.add(idx);
        }

        return ans;
    }

    /**
     * binary search returning last index of key in the given list
     * @param list  : given list | sorted with duplicates
     * @param start : start index in the list
     * @param end  : end index in the list
     * @param key: key to search in the given list
     * @return return an index | for a given key , all the elements present at index less than the returned index
     * will be less than or equal to given index.
     *
     * example : 1,2,4,4 key: 4 | index returned is : 4
     *           1,2,4,4 key: 3 | index returned is : 2
     */
    public static int binarySearch(List<Integer> list, int start, int end, int key){
        while(start <= end){
            int mid = start + (end-start)/2;
            if(list.get(mid) == key){
                start = mid;
            }
            if(list.get(mid) > key){
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }
        return start;   // start - 1
    }

    /**
     * teama [1,4,2,4]
     * teamb [3,4]
     * output : [2,4]
     */
}
