package com.example.helloworld.dump.morganstanley.testdump;

import java.util.*;

//public class Solution {
//
//    public void getDetails(){
//        List<String> list = new ArrayList<>();
//        list.add("A");
//        list.add("B");
//
//        for(int i=0;i<list.size();i++){
//            if(list.get(i).equals("A"))
//                list.remove("A");
//        }
//        System.out.println(list);
//    }
//    public static void main(String[] args) {
//        new Solution().getDetails();;
//    }
//}


//class Test {
//
//
//    public static void main(String[] args) {
//        int x = 10;
//        int y = 2;
//        try {
//            for (int z = 2; z >= 0; z--) {
//                int ans = x / z;
//                System.out.print(ans + " ");
//            }
//        }catch (Exception e1){
//            System.out.println("e1");
//        }catch (ArithmeticException e1){
//            System.out.println("e2");
//        }
//    }
//}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */

//class Parent{
//    void say(List<String> list){
//        System.out.println("parent");
//    }
//}
//class Child extends Parent{
//    void say(List list){
//        System.out.println("child");
//    }
//}
//
//class Test{
//    public static void main(String[] args) {
//        Child c = new Child();
//        c.say(new LinkedList<String>());
//    }
//}

class NullableBook{
    Optional<String> bookName;
    public NullableBook(Optional<String> name){
        bookName = name;
    }
    public Optional<String> getName(){
        return bookName;
    }
}
class Test{
    public static void main(String[] args) {
        NullableBook nullableBook = new NullableBook(Optional.ofNullable("null"));
        Optional<String> name = nullableBook.getName();
//        name.ifPresent(System.out::println).orElse("Empty");
        name.ifPresent(System.out::println
        );
    }
}