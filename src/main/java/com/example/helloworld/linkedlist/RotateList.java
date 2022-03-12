package com.example.helloworld.linkedlist;

import com.example.helloworld.linkedlist.model.ListNode;

/**
 * leetcode 61. Rotate List
 *
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Example 2:
 *
 *
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0) return head;
        int n = lengthOfLinkedList(head);

        if(n==0 || k%n == 0) return head;

        k = k%n;
        int l = n-k-1;
        ListNode temp = head;
        while(l-- > 0){
            temp = temp.next;
        }

        ListNode temp2 = temp.next;
        ListNode newHead = temp2;

        temp.next = null;
        while(temp2.next != null)
            temp2 = temp2.next;
        temp2.next = head;

        return newHead;
    }

    /**
     * function to find the length of a linked list, size of a linked list, length of linked list
     * @param head
     * @return
     */
    public int lengthOfLinkedList(ListNode head){
        int len = 0 ;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }
}

