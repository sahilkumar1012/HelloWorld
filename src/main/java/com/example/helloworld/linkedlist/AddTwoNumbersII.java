package com.example.helloworld.linkedlist;

import com.example.helloworld.linkedlist.model.ListNode;

/**
 * leetcode 445. Add Two Numbers II
 *
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [7,2,4,3], l2 = [5,6,4]
 * Output: [7,8,0,7]
 * Example 2:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [8,0,7]
 * Example 3:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 *
 *
 * Follow up: Could you solve it without reversing the input lists?
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        return reverse(addTwoNumbersI(l1,l2));
    }

    public ListNode reverse(ListNode head){

        ListNode prev = null,curr = head,next=null;

        while(curr != null){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public ListNode addTwoNumbersI(ListNode l1, ListNode l2) {
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
