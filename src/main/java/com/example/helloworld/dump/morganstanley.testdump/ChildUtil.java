package com.example.helloworld.dump.morganstanley.testdump;

public class ChildUtil extends ParentUtil {
    public static void main(String[] args) {
        new ChildUtil().callStuff();
    }
    void callStuff(){
        System.out.print("this "+ this.doStuff());
        ParentUtil p = new ParentUtil();
    }
}
