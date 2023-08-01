package com.example.helloworld.backtracking.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * Medium
 * 7.4K
 * 204
 * Companies
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        sol(res,n,k,new ArrayList<>(),1);
        return res;
    }

    // backtracking
    private void sol(List<List<Integer>> res, int n, int k, List<Integer> temp, int idx){
        for(int i=idx; i<=n; i++){
            temp.add(i);
            if(temp.size() == k){
                res.add(new ArrayList<>(temp));
            }
            sol(res, n, k, temp, ++idx);
            temp.remove(temp.size()-1);
        }
    }

    // write a sample main function to test above combination backtracking function
    public static void main(String[] args) {
        Combinations c = new Combinations();
        List<List<Integer>> res = c.combine(4,2);
        for(List<Integer> l : res) {
            System.out.println(l);
        }
    }

}
