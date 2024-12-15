package com.example.helloworld.greedy;

import java.util.PriorityQueue;

/**
 * leetcode 1792. Maximum Average Pass Ratio , medium , asked in Amazon
 *
 * code harmony video explanation : https://youtu.be/rQZSm61A4N4
 *
 * my leetcode solution : https://leetcode.com/problems/maximum-average-pass-ratio/solutions/6148559/easy-to-understand-greedy-priority-queue-s0k6/
 *
 * There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, there are totali total students, but only passi number of students will pass the exam.
 *
 * You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.
 *
 * The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.
 *
 * Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of the actual answer will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
 * Output: 0.78333
 * Explanation: You can assign the two extra students to the first class. The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.
 * Example 2:
 *
 * Input: classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
 * Output: 0.53485
 *
 *
 * Constraints:
 *
 * 1 <= classes.length <= 105
 * classes[i].length == 2
 * 1 <= passi <= totali <= 105
 * 1 <= extraStudents <= 105
 */
public class MaximumAveragePassRatio {

    // Comparator method to compare the gain in pass ratio when an extra student is added
    private static int compare(int[] c1, int[] c2){
        // Current pass ratios
        double pr1 = c1[0] * 1.0 / c1[1];
        double pr2 = c2[0] * 1.0 / c2[1];

        // New pass ratios if one student is added
        double npr1 = (c1[0] + 1.0) / (c1[1] + 1.0);
        double npr2 = (c2[0] + 1.0) / (c2[1] + 1.0);

        // Gain in pass ratios
        double d1 = npr1 - pr1;
        double d2 = npr2 - pr2;

        // Compare based on the higher gain in pass ratio
        return Double.compare(d2, d1);
    }

    // Helper method to calculate the pass ratio of a class
    private double passRatio(int[] c){
        return c[0] * 1.0 / c[1];
    }

    // Method to maximize the average pass ratio after distributing extra students
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;

        // Priority queue to store classes, ordered by the comparator
        PriorityQueue<int[]> pq = new PriorityQueue<>(MaximumAveragePassRatio::compare);

        double totalPR = 0.0; // To keep track of the total pass ratio

        // Add all classes to the priority queue and calculate the initial total pass ratio
        for(int i = 0; i < n; i++){
            int[] curr = classes[i];
            pq.offer(new int[]{curr[0], curr[1]});
            totalPR += passRatio(curr);
        }

        // Distribute the extra students
        while(extraStudents > 0){
            // Poll the class that has the highest gain in pass ratio when an extra student is added
            int[] bestClass = pq.poll();

            // Update the total pass ratio by removing the old ratio and adding the new one
            totalPR -= passRatio(bestClass);
            bestClass[0]++; // Increment the number of passes
            bestClass[1]++; // Increment the total number of students
            totalPR += passRatio(bestClass);

            // Re-add the updated class back to the priority queue
            pq.offer(bestClass);
            extraStudents--; // Decrease the count of extra students
        }

        // Return the average pass ratio after distributing all extra students
        return totalPR / n;
    }
}
