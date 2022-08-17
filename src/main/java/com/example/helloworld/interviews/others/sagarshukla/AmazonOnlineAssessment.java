package com.example.helloworld.interviews.others.sagarshukla;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * https://www.geeksforgeeks.org/amazon-interview-experience-for-sde-ii-2/
 *
 *I got a call from an Amazon recruiter. She sent me the coding test link which I had to complete within a week. The given link consisted of three rounds of challenges and each round was mandatory to complete successfully the given assessment.  Below were the rounds.
 *
 * Online Round (Coding Test – 90 mins):
 *
 * Prob1.  Amazon Shopping recently launched a new item whose daily customer ratings for n days are represented by the array ratings. They monitor these ratings to identify products that are not performing well. Find the number of groups that can be formed consisting of 1 or more consecutive days such that the ratings continuously decrease over the days.
 *
 * The ratings are consecutively decreasing if it has the form: r,r-1,r-2.. and so on, where r is the rating on the first days of the group being considered. Two groups are considered different if they contain the ratings of different consecutive days.
 *
 * Prob2. Amazon Academy recently organized a scholarship test on its platform. A total of n students participated in the test. Each student received a unique roll number, i. Each student’s rank is stored at rank[i]. Each student gets a unique rank, so the rank is a permutation of values 1 through n.
 *
 * For improved collaboration, the students are to be divided into groups. Use the following rules to find the imbalance in a group of students.
 *
 * A group has k students where 1 <=k<=n. Groups are formed of k students in the ranks with consecutive roll  numbers i.e  I, (i+1)..(i+k-1)
 * The ranks of the students in a group are then sorted ascending to an array, here named  sorted_rank.
 * The imbalance of the group is then defined as the number of students j, who are more than 1 rank
 * beneath the rank of student just ahead of them,i.e sorted_rank[j] – sorted_rank[j-1] > 1
 *
 *
 *
 */
public class AmazonOnlineAssessment {

}

class AmazonOnlineAssessmentProblem2 {

    //testing
    public static void main(String args[]) {

        Integer[] m_Arr = {4,1,3,2};
        List<Integer> m_ratings = Arrays.asList(m_Arr);

        long m_ans = findTotalImbalance(m_ratings);

        System.out.println(m_ans); //3
//        System.out.println(findTotalm_imbalance(m_ratings));
    }

    public static long findTotalImbalance(List<Integer> rank) {
        long mi = 0;
        int r = 0;
        TreeSet<Integer> mset = new TreeSet<>();

        while (r < rank.size() - 1) {
            mset.clear();
            mset.add(rank.get(r));
            long ci = 0;

            for (int i = r + 1; i < rank.size(); i++) {
                Integer e = rank.get(i);
                mset.add(e);
                Integer f = mset.lower(e);
                Integer c = mset.higher(e);

                if (f == null) {
                    ci += ((c - e) > 1 ? 1 : 0);
                } else if (c == null) {
                    ci += (((e - f) > 1) ? 1 : 0);
                } else {
                    ci += (c - f) > 1 ? -1 : 0;
                    ci += (((c - e) > 1) ? 1 : 0);
                    ci += ((e - f)) > 1 ? 1 : 0;
                }
                mi += ci;
            }
            r++;
        }
        return mi;
    }

    public static long findTotalm_imbalance(List<Integer> rank) {

        long mi = 0;
        int r = 0;
        TreeSet<Integer> mset = new TreeSet<>();

        while (r < rank.size() - 1) {
            mset.clear();
            mset.add(rank.get(r));
            long ci = 0;

            for (int i = r + 1; i < rank.size(); i++) {
                Integer e = rank.get(i);
                mset.add(e);
                Integer f = mset.lower(e);
                Integer c = mset.higher(e);

                if (f == null) {
                    ci += ((c - e) > 1 ? 1 : 0);
                } else if (c == null) {
                    ci += (((e - f) > 1) ? 1 : 0);
                } else {
                    ci += (c - f) > 1 ? -1 : 0;
                    ci += (((c - e) > 1) ? 1 : 0);
                    ci += ((e - f)) > 1 ? 1 : 0;
                }
                mi += ci;
            }
            r++;
        }

        return mi;
    }

}