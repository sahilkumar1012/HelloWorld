package com.example.helloworld.segmentTree;
import java.util.ArrayList;


/**
 * Range Minimum Query
 * Problem Description
 *
 * Given an integer array A of size N.
 *
 * You have to perform two types of query, in each query you are given three integers x,y,z.
 *
 * If x = 0, then update A[y] = z.
 * If x = 1, then output the minimum element in the array A between index y and z inclusive.
 * Queries are denoted by a 2-D array B of size M x 3 where B[i][0] denotes x, B[i][1] denotes y, B[i][2] denotes z.
 *
 *
 *
 * Problem Constraints
 * 1 <= N, M <= 105
 *
 * 1 <= A[i] <= 109
 *
 * If x = 0, 1<= y <= N and 1 <= z <= 109
 *
 * If x = 1, 1<= y <= z <= N
 *
 *
 *
 * Input Format
 * First argument is an integer array A of size N.
 *
 * Second argument is a 2-D array B of size M x 3 denoting queries.
 *
 *
 *
 * Output Format
 * Return an integer array denoting the output of each query where value of x is 1.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 4, 1]
 *  B = [
 *         [1, 1, 3]
 *         [0, 1, 5]
 *         [1, 1, 2]
 *      ]
 * Input 2:
 *
 *  A = [5, 4, 5, 7]
 *  B = [
 *         [1, 2, 4]
 *         [0, 1, 2]
 *         [1, 1, 4]
 *      ]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 4]
 * Output 2:
 *
 *  [4, 2]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  For 1st query, the minimum element from range (1, 3) is 1.
 *  For 2nd query, update A[1] = 5, now A = [5, 4, 1].
 *  For 3rd query, the minimum element from range (1, 2) is 4.
 * Explanation 2:
 *
 *  For 1st query, the minimum element from range (2, 4) is 4.
 *  For 2nd query, update A[1] = 2, now A = [2, 4, 5, 7].
 *  For 3rd query, the minimum element from range (1, 4) is 2.
 */
public class RangeMinimumQuery {
    int[] tree;
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = A.size()-1;
        tree = new int[4*n];
        build(A,0,n,1);                  // Time :- O(n)

        for(ArrayList<Integer> l : B){
            if(l.get(0)==0){
                update(0,n,1,l.get(1)-1,l.get(2));
            }
            else{
                res.add(query(l.get(1)-1,l.get(2)-1,0,n,1));
            }
        }
        return res;

    }

    private void build(ArrayList<Integer> A,int start,int end,int idx){
        if(start == end){
            tree[idx] =A.get(start);
            return ;
        }
        int mid = (start + end)/2;
        build(A,start,mid,2*idx);
        build(A,mid+1,end,2*idx+1);
        tree[idx] = Math.min(tree[2*idx],tree[2*idx+1]);
    }

    private int query(int left,int right,int start,int end,int idx){
        if(end < left || right < start){                // No Overlap
            return Integer.MAX_VALUE;
        }
        if(left <= start && end <= right){              // Complete Overlap
            return tree[idx];
        }
        // Partial overlap
        int mid = (start + end)/2;
        int l = query(left,right,start,mid,2*idx);
        int r = query(left,right,mid+1,end,2*idx+1);
        return Math.min(l,r);
    }
    private void update(int start,int end,int idx,int id,int val ){
        if(start == end){
            tree[idx]=val;
            return;
        }
        int mid = (start+end)/2;
        if(id<=mid){
            update(start,mid,idx*2,id,val);
        }
        else
            update(mid+1,end,idx*2+1,id,val);
        tree[idx]=Math.min(tree[2*idx],tree[2*idx +1]);

    }

}
