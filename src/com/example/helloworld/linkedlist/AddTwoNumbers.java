package com.example.helloworld.linkedlist;

import com.example.helloworld.linkedlist.model.ListNode;

/**
 * leetcode 2. Add Two Numbers
 *
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head = new ListNode();
        ListNode dummyNode = head;
        int carry = 0;

        while(l1 != null && l2 != null){
            int val1 = l1.val;
            int val2 = l2.val;
            ListNode newNode = new ListNode();
            if((val1 + val2 + carry) > 9){
                newNode.val = (val1 + val2 + carry) - 10;
                carry = 1;
            } else {
                newNode.val = (val1 + val2 + carry);
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            head.next = newNode;
            head = head.next;
        }

        while(l1 != null){
            ListNode newNode = new ListNode();
            if(l1.val + carry > 9){
                newNode.val = (l1.val + carry) - 10;
                carry = 1;
            } else {
                newNode.val = l1.val + carry;
                carry = 0;
            }
            head.next = newNode;
            head = head.next;
            l1 = l1.next;
        }

        while(l2 != null){
            ListNode newNode = new ListNode();
            if(l2.val + carry > 9){
                newNode.val = (l2.val + carry) - 10;
                carry = 1;
            } else {
                newNode.val = l2.val + carry;
                carry = 0;
            }
            head.next = newNode;
            head = head.next;
            l2 = l2.next;
        }

        if(carry > 0){
            ListNode newNode = new ListNode(carry);
            head.next = newNode;
            head = head.next;
        }

        return dummyNode.next;
    }
}
