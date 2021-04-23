package com.example.helloworld.dump;

public class Dump {
    int count=0;

    public void solveUnitFractions(){
        int a = 2, b = 3, c,d;
        while( count++ < 11 ){
            c = b*(b-1);
            d =
            d = (c-1)*c;
            System.out.println(" a:"+a+" b:"+b+" c:"+c+ " d:"+d);
            c = c+1;
        }
    }

    public static void main(String[] args) {
        new Dump().solveUnitFractions();
    }
}
