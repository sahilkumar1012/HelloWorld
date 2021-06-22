package com.example.helloworld.dump;

import com.example.helloworld.tree.model.TreeNode;

import java.util.*;

class X {
    public static void main(String[] args) {
        try {
            badMethod();
            System.out.print("A");
        } catch (Exception ex) {
            System.out.print("B");
        } finally {
            System.out.print("C");
        }
        System.out.print("D");
    }

    public static void badMethod() {
        throw new Error();
    }
}

//public class Test {
//    Test() {
//    } // line 1
//static void Test() { this(); }
//// line 2
//public static void main(String[] args) {
//        Test();  } }


class MyClass {
        int i;
        int j;

        public MyClass(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public void call() {
            System.out.print("One");
        }
    }

class Test {
    int solution(int M, int[] A) {
        int N = A.length;
        int[] count = new int[M + 1];
        for (int i = 0; i <= M; i++)
            count[i] = 0;
        int maxOccurence = 0;
        int index = -1;
        for (int i = 0; i < N; i++) {
                count[A[i]]++;
                int tmp = count[A[i]];
                if (tmp > maxOccurence) {
                    maxOccurence = tmp;
                    index = i;
                }
        }
        return A[index];
    }

    public static void main(String args[]) {
        int[] arr = new int[]{2};
        System.out.println(new Test().solution(3,arr));
    }
}

