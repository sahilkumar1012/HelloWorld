package com.example.helloworld.bit;

import java.util.Arrays;

public class BitwiseAndOfNumberRange{

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5
                ,7));;
        //700000000
        //2147483641
    }

    public static int rangeBitwiseAnd(int left, int right) {
        if(left==right)
            return left;

        int n = right-left;
        int po2=0;
        while(n!=0){
            n>>=1;
            po2++;
        }

        // Dhoor paindi algo by Kaka
        left >>= po2;
        left <<= po2;
        right >>= po2;
        right <<= po2;

        return (left & right);
    }


}

/*
c++ code

class Solution {
    public:
    int rangeBitwiseAnd(int m, int n) {

        int count=0;

        while(m!=n)
        {
            m=m>>1;
            n=n>>1;
            count++;
        }
        return m<<count;
    }
};


 */