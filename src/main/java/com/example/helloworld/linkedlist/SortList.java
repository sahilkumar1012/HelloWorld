package com.example.helloworld.linkedlist;

import com.example.helloworld.linkedlist.model.ListNode;

/**
 * 148. Sort List
 *
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */
public class SortList {

    // merging of two sorted halfs.
    private ListNode sortedMerge(ListNode a, ListNode b){
        ListNode result = null;

        if(a==null){
            return b;
        }else if(b==null){
            return a;
        }

        if(a.val <= b.val){
            result = a;
            result.next = sortedMerge(a.next,b);
        }else{
            result = b;
            result.next = sortedMerge(a,b.next);
        }
        return result;
    }

    // merge sort recursion function.
    public ListNode sortList(ListNode head) {
        if(head==null || head.next ==null){
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode nextOfMiddle = middle.next;
        middle.next = null;

        return  sortedMerge(sortList(head),sortList(nextOfMiddle));
    }

    // used two pointer algo to find the middle of the list.
    private ListNode getMiddle(ListNode a){
        if(a==null){
            return a;
        }
        ListNode slow = a;
        ListNode fast = a.next;
        while(fast!=null){
            fast = fast.next;
            if(fast!=null){
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }


    /**
     * using insertion sort. TLE
      */

    public ListNode sortListInsertionSort(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode resHead = new ListNode(Integer.MIN_VALUE);

        while(head != null){
            ListNode temp = head;
            head = head.next;

            // insert this temp at it's appropriate location in resultant list
            ListNode it = resHead;
            while(it.next != null && it.next.val < temp.val){
                it = it.next;
            }
            if(it.next == null){
                it.next = temp;
                temp.next = null;
            }else{
                temp.next = it.next;
                it.next = temp;
            }
        }

        return resHead.next;
    }
}