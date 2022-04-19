package com.example.helloworld.interviews.others.himanshu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * coding test set 3, beautiful numbers, hacker rank link :
 */
public class PayPalCodingTest {
    /**
     * question 1 , beautiful numbers
     */
    public static long[] tot = new long[1000005];

    public static boolean check(int u){
        int cnt = 60;
        while(cnt -- > 0){
            int ans = 0;
            while(u > 0){
                ans += (u%10) * (u%10);
                u /= 10;
            }
            u = ans;
            if(u == 1 ) return true;
        }
        return false;
    }
    public static void pre(){
        for(int i=1; i<=1000000; i++){
            if(check(i)){
                tot[i] = i;
            }
        }
        for(int i=1; i<= 1000000; i++){
            tot[i] += tot[i-1];
        }
    }

    public static void main(String[] args) throws IOException {
        pre();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            String[] str = br.readLine().split(" ");
            int l = Integer.parseInt(str[0]);
            int r = Integer.parseInt(str[1]);

            long out_ = solve(l, r);
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }
    static long solve(int l, int r){
        // Your code goes here
        return tot[r] - tot[l-1];
    }
}

class PayPalCodingTest2{
    /**
     * question 2.
     * paypal set 3 question , title : Hurray!
     ( max tasks to be completed in a given budget )
     You are given a straight line statring at 0 to 10^9. You start at zero and there are n tasks you can perform. ith task is located at point 'i' in the line and requries 't' time to be performed. To perform the task you need to reach the ppoint 'i' and spend 't' time at that location. e.g (5,8) lies at 5 so travel distance is 5 and work effort is 8.
     Total effort is calculated as travel distance + time required to complete the work.

     It takes one sec to travel one unit of path.

     Now we are given total T seconds and we need to complete as many tasks as possible and reach back to starting position
     Find the max number of tasks that you can finish in time T.
     e.g
     3 16 -> 3 tasks and 16 units of total time
     2 8 -> task 1 at position 2 in line and takes 8 sec to complete
     4 5 -> task 2 at position 4 in line and takes 5 sec to complete
     5 1 -> task 3 at position 5 in line and takes 1 sec to complete

     */
    static int solve(int n, int t, int[][] task){
        PriorityQueue<Integer> pQueue= new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(task, Comparator.comparingInt(o->o[0]));
        int pQueueSum=0;
        int max=0;
        for(int i=0;i<n;i++){
            int totalTime =t;
            int distance = 2*task[i][0];
            int remainingTime=totalTime-distance;
            int currEffort=task[i][1];
            if(remainingTime<0){
                break;
            }
            while(pQueueSum>remainingTime){
                pQueueSum-=pQueue.poll();
            }
            if(pQueue.isEmpty()&&remainingTime>currEffort){
                pQueue.add(currEffort);
                pQueueSum+=currEffort;
            }
            else if(pQueueSum+currEffort<=remainingTime){
                pQueue.add(currEffort);
                pQueueSum+=currEffort;
            }
            else{
                Integer currMax=pQueue.peek();
                if(currMax != null && currMax>currEffort){
                    pQueue.poll();
                    pQueue.add(currEffort);
                    pQueueSum=pQueueSum-currMax+currEffort;
                }
            }
            max=Math.max(max,pQueue.size());
        }
        return max;
    }
}