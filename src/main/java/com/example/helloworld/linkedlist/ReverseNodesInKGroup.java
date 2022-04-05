package com.example.helloworld.linkedlist;

import com.example.helloworld.linkedlist.model.ListNode;

/**
 * leetcode 25. Reverse Nodes in k-Group
 * reference video pepcoding : https://youtu.be/EKgNMFCShO8
 *
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 */
public class ReverseNodesInKGroup {

    ListNode th=null, tt = null, oh = null, ot = null;

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k==0)
            return head;

        int len = length(head);

        ListNode curr = head;
        while(len >= k){
            int tempk = k;
            while(tempk -- > 0){
                ListNode forw = curr.next;

                curr.next = null;
                addFirstNode(curr);

                curr = forw;
            }
            if(oh == null){
                oh = th;
                ot = tt;
            }else{
                ot.next = th;
                ot = tt;
            }

            th = null; tt = null;
            len -= k;
        }
        ot.next = curr;

        return oh;
    }

    public void addFirstNode(ListNode node){
        if(th == null){
            th = node;
            tt = node;
        }else{
            node.next = th;
            th = node;
        }
    }

    public int length(ListNode head){
        int len = 0;
        while(head != null){
            len ++ ;
            head = head.next;
        }
        return len;
    }

}