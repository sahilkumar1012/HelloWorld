package com.example.helloworld.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * leetcode 1424. Diagonal Traverse II
 *
 * https://leetcode.com/problems/diagonal-traverse-ii/
 *
 *
 * Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below images.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,4,2,7,5,3,8,6,9]
 * Example 2:
 *
 *
 * Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
 * Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i].length <= 105
 * 1 <= sum(nums[i].length) <= 105
 * 1 <= nums[i][j] <= 105
 */
public class DiagonalTraverseII {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<int[]> list = new ArrayList<>();     // col, (i+j) , val

        for(int i=0; i<nums.size(); i++){
            for(int j=0; j<nums.get(i).size(); j++){
                list.add( new int[]{j, (i+j), nums.get(i).get(j)} );
            }
        }

        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1])
                    return o1[0]-o2[0];
                return o1[1] - o2[1];
            }
        });

        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i)[2];
        }
        return res;
    }

}
