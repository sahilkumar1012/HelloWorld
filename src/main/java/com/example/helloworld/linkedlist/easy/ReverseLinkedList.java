package com.example.helloworld.linkedlist.easy;

import com.example.helloworld.linkedlist.model.LinkedListUtil;
import com.example.helloworld.linkedlist.model.ListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);

       // head= new ReverseLinkedList().reverseByIteration(head);
        head = new ReverseLinkedList().reverseByRecursion(head);
        LinkedListUtil.printLinkedList(head);

    }

    /***
     * This function will reverse linked List using iteration
     * @param head
     * @return headOfReverseNode
     */
    public ListNode reverseByIteration(ListNode head){

        ListNode prev = null,curr = head,next=null;

        while(curr != null){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public ListNode reverseByRecursion(ListNode head){
             return reverseByRecursionHelper(null,head);
    }

    private ListNode reverseByRecursionHelper(ListNode prev, ListNode head){
        if(head.next==null){
            head.next=prev;
            return head;
        }
        ListNode temp=reverseByRecursionHelper(head,head.next);
        head.next=prev;
        return temp;
    }
}
