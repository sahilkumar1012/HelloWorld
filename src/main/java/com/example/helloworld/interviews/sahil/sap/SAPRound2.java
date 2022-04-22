package com.example.helloworld.interviews.sahil.sap;

public class SAPRound2 {
    /*

write  a program to find loop in a linked list.

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val ){
        this.val = val;
    }
}

class Solution{
    public boolean detectLoop(ListNode head){
       if(head == null) return false;

       ListNode slow = head, fast = head;
       while(slow ! = null && fast!= null && fast.next != null){
           if(fast == slow)
               return true;
           slow = slow.next;
           fast = fast.next.next;
       }
       return false;
    }
}



wap to print all the permutaions of the given string
S1 = "abdfkjh"

class Solution2{
      // [0, input.length()-1 ]
    public void permute(String input, int left, int right){
        if( left == right ){
            System.out.println(input);
        }else{
            for(int i= left; i<=right ; i++){
                input = swap(input, left, i);
                permute(input, left+1, right);
                input = swap(input, i, left);
            }
        }
    }

    public Map<Integer,Integer> freq(int[] input){
        Map<Integer, Integer> hash = new HashMap<>();

        for(int i : input){
            map.put(i, map.getOrDefault(i,0) + 1 );
        }

        return hash;
    }
}

array = [3,4,5,3,2,5,6,5]


Key
hash(key) > index of block

[ , , , , , ,]
int[] hash = new int[10];
> [0, 9]
> phone % 10  = 9




     */
}
