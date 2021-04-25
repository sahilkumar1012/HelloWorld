package com.example.helloworld.array;

/**

leetcode problem : 57. Insert Interval


 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.



 Example 1:

 Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 Output: [[1,5],[6,9]]
 Example 2:

 Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 Output: [[1,2],[3,10],[12,16]]
 Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 Example 3:

 Input: intervals = [], newInterval = [5,7]
 Output: [[5,7]]
 Example 4:

 Input: intervals = [[1,5]], newInterval = [2,3]
 Output: [[1,5]]
 Example 5:

 Input: intervals = [[1,5]], newInterval = [2,7]
 Output: [[1,7]]

 Note: handle edge case properly.
 */
class InsertIntervalMain{
    public static void main(String[] args) {
//        int[][] intervals = new int[][]{ {1,3}, {6,9} };
//        int[] newInterval = new int[]{2,5};

        int[][] intervals = new int[][]{ };
        int[] newInterval = new int[]{2,5};
//        int[][] intervals = new int[][]{ {4,9} };
//        int[] newInterval = new int[]{2,5};


        int[][] res = new InsertInterval().insert(intervals,newInterval);
        for(int[] a: res){
            System.out.println(a[0] + " " + a[1]);
        }
    }
}
public class InsertInterval {
    /*
    given intervals are sorted.
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if(n==0){
            return new int[][]{newInterval};
        }

        int[][] all = new int[n+1][2];

        int i=0; boolean done = false;
        int j=0;
        for(i=0; i<n & j<=n; ++i,++j){
            if(!done){
                if(newInterval[0] < intervals[i][0]){  // just adding the interview at proper location to maintain the order, so no sorting is needed
                    all[j][0] = newInterval[0];
                    all[j][1] = newInterval[1];
                    ++j;
                    done=true;
                }
            }
            all[j][0] = intervals[i][0];
            all[j][1] = intervals[i][1];
        }

        // newInterval not inserted inbetween
        // handle corner cases properly.
        if(j==n){
            all[j][0] = newInterval[0];
            all[j][1] = newInterval[1];
        }

        return new MergeIntervals().merge(all); // and call merge to merge overlapping intervals.
    }


}


