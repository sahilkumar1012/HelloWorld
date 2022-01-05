package com.example.helloworld.linkedlist.easy;

import com.example.helloworld.linkedlist.model.LinkedListUtil;
import com.example.helloworld.linkedlist.model.ListNode;

/**
 * leetcode 206. Reverse Linked List
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);

       // head= new ReverseLinkedList().reverseByIteration(head);
        head = new ReverseLinkedList().reverseRecursively(head);
        LinkedListUtil.printLinkedList(head);

    }

    /***
     * This function will reverse linked List using iteration
     * @param head of input list to be reversed.
     * @return headOfReverseNode
     */
    public ListNode reverseByIteration(ListNode head){
        ListNode prev = null, current = head, next;

        while(current !=null){
            next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }
        return prev;
    }

    /**
     * chirag bhai ka recursion hai ye khud ka.
     * @param head
     * @return
     */
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

    /**
     * Reversing a linked list recursively, took reference from geeksforgeeks.
     * @param head
     * @return
     */
    public ListNode reverseRecursively(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode temp = reverseRecursively(head.next);
        head.next.next = head;
        head.next = null;

        return temp;
    }


}
