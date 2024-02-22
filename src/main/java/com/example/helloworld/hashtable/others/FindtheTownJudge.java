package com.example.helloworld.hashtable.others;

/**
 * leetcode 997. Find the Town Judge
 *
 * https://leetcode.com/problems/find-the-town-judge/
 *
 * Code harmony solution video : https://youtu.be/O7r0tvYkyxk
 *
 *
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.
 *
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2, trust = [[1,2]]
 * Output: 2
 * Example 2:
 *
 * Input: n = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Example 3:
 *
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 * 0 <= trust.length <= 104
 * trust[i].length == 2
 * All the pairs of trust are unique.
 * ai != bi
 * 1 <= ai, bi <= n
 *
 */
public class FindtheTownJudge {

    /**
     * Finds the town judge's label given the number of people in the town and the trust relationships between them.
     *
     * @param n      The number of people in the town.
     * @param trust  An array representing trust relationships where trust[i] = [ai, bi] indicates that ai trusts bi.
     * @return The label of the town judge if found; otherwise, returns -1.
     */
    public int findJudge(int n, int[][] trust) {
        // If the number of trust relationships is less than the number of people minus one,
        // it's impossible for everyone to trust the same person, hence no town judge exists.
        if (trust.length < n - 1)
            return -1;

        // Arrays to keep track of the number of incoming and outgoing trusts for each person.
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];

        // Counting the number of incoming and outgoing trusts for each person.
        for (int[] t : trust) { // t[0] -> t[1]
            out[t[0]]++;
            in[t[1]]++;
        }

        // Searching for the town judge based on the conditions provided.
        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) {
                return i; // If a person trusts nobody and everyone else trusts them, they are the town judge.
            }
        }

        return -1; // If no town judge is found.
    }

}