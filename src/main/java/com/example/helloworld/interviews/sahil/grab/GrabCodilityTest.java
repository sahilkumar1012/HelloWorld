package com.example.helloworld.interviews.sahil.grab;

import java.util.HashSet;

public class GrabCodilityTest {

}
class GrabCodilityTestProblem1{
    class Solution {
        public int solution(int[] A) {
            // write your code in Java SE 8
            int maxSeen = -1;
            int result = 0;

            for(int i = 0; i < A.length; i++){
                maxSeen = Math.max(maxSeen, A[i]);
                if(i+1 == maxSeen)      // valid it's a valid state
                    result++;
            }

            return result;
        }

    }
}
class GrabCodilityTestProblem2{
    class Tree{
        public Tree l, r;
        public int x;
    }
    class Solution {
        int max = 0;

        public int solution(Tree T) {
            // write your code in Java SE 8
            paths(T, new HashSet<Integer>());
            return max;
        }

        // any root to node path with distinct values, capturing max length so far for this path
        private void paths(Tree root, HashSet<Integer> set){
            if(root == null) return;

            if(set.contains(root.x)){
                return;
            }
            set.add(root.x);
            max = Math.max(max, set.size());

            paths(root.l, set);
            paths(root.r, set);

            set.remove(root.x);
        }
    }

}
class GrabCodilityTestProblem3{
    // you can also use imports, for example:


// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

    class Solution {
        public int solution(int[] A, int[] B) {
            // write your code in Java SE 8
            UnionFind uf = new UnionFind(A.length+1);
            for(int i=0; i<A.length; i++){
                uf.union(A[i], B[i]);
            }
            uf.correctParent();

            for(int i=1; i<A.length; i++){
                // System.out.print(uf.parent[i] + " ");
                if(uf.parent[i] != uf.parent[i-1])
                    return -1;
            }
            return uf.parent[0];
        }

        // uf modified for directed graph
        class UnionFind {
            // if all the nodes are having same parent that node is having inDegree = (nodes -1)
            public int[] parent;

            public UnionFind(int n) {
                parent = new int[n];
                for(int i=0; i<n; i++)  parent[i] = i;
            }

            public void union(int a, int b) {
                int p = b;
                while(parent[p] != p)       // baap ke baap ke pas jao
                    p = parent[p];

                parent[a] = p;
            }
            public void correctParent(){
                for(int i=0; i<parent.length; i++){
                    union(i, parent[i]);
                }
            }
        }
    }

}