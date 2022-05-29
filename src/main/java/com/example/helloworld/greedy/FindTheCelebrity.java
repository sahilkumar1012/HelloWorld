package com.example.helloworld.greedy;

/**
 * leetcode 277. Find the Celebrity
 *
 * Suppose you are at a party with n people labeled from 0 to n - 1 and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know the celebrity, but the celebrity does not know any of them.
 *
 * Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is ask questions like: "Hi, A. Do you know B?" to get information about whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 *
 * You are given a helper function bool knows(a, b) that tells you whether A knows B. Implement a function int findCelebrity(n). There will be exactly one celebrity if they are at the party.
 *
 * Return the celebrity's label if there is a celebrity at the party. If there is no celebrity, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: graph = [[1,1,0],[0,1,0],[1,1,1]]
 * Output: 1
 * Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j, otherwise graph[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.
 * Example 2:
 *
 *
 * Input: graph = [[1,0,1],[1,1,0],[0,1,1]]
 * Output: -1
 * Explanation: There is no celebrity.
 *
 *
 * Constraints:
 *
 * n == graph.length == graph[i].length
 * 2 <= n <= 100
 * graph[i][j] is 0 or 1.
 * graph[i][i] == 1
 *
 *
 * Follow up: If the maximum number of allowed calls to the API knows is 3 * n, could you find a solution without exceeding the maximum number of calls?
 */


/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class FindTheCelebrity extends Relation {
    public int findCelebrity(int n) {

        // for(int i=0; i<n; i++){
        //     if(isCelebrity(i,n))
        //         return i;
        // }
        int cc = 0; // candidate celebrity
        for(int i=0; i<n; i++){
            if(knows(cc, i))                // means cc can not be our celebrity
                cc = i;         // pruning
        }
        if(isCelebrity(cc, n))
            return cc;

        return -1;
    }

    // check if the given candidate is celebrity or not
    private boolean isCelebrity(int ii, int n){
        for(int i=0; i<n; i++){
            if(i == ii) continue;
            if(knows(ii, i) || !knows(i, ii))
                return false;
        }
        return true;
    }
}


/**
 * ignore this class, wrote to avoid compilation errors.
 */
class Relation{
    public boolean knows(int i, int j){
        return true;
    }
}