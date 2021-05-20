package com.example.helloworld.linkedlist.model;

public class LinkedListUtil {
    public static void printLinkedList(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head=head.next;
        }
        System.out.println();
    }
}
