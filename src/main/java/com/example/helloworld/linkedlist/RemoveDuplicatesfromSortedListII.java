package com.example.helloworld.linkedlist;

import com.example.helloworld.linkedlist.model.ListNode;

/**
 * leetcode 82. Remove Duplicates from Sorted List II
 * Solution : https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/solution/
 *
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 *
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class RemoveDuplicatesfromSortedListII {

    // sentinel + predecessor approach // optimized approach
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(-1,head)
                , pred = sentinel;

        while(head!=null){
            if(head.next!=null && head.val == head.next.val){
                // moving till the end of dupliate sublist
                while(head.next!=null && head.val == head.next.val){
                    head = head.next; // skip them
                }
                // skip all duplicates, last one too.
                pred.next = head.next;
            }else{
                pred = pred.next;
            }
            head = head.next; // move forward
        }
        return sentinel.next;
    }

    // self slow solution intuitive approach
    public ListNode deleteDuplicatesSlowSoltion(ListNode head) {
        ListNode res = new ListNode (-1100);
        ListNode last = res;

        while( head != null && head.next != null ){
            if(head.next.val == head.val){
                while(head.next != null && head.next.val == head.val)
                    head = head.next;
            }else{
                System.out.print(head.val +  "  ");
                last.next = head;
                last = last.next;
            }
            head = head.next;       // this current element is used.
        }

        last.next = null;
        if(head != null && last.val != head.val){
            last.next = head;
        }
        return res.next;
    }
}
