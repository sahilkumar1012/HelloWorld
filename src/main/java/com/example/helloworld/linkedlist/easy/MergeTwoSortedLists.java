package com.example.helloworld.linkedlist.easy;

import com.example.helloworld.linkedlist.model.ListNode;

/**
 * leetcode 21. Merge Two Sorted Lists
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1), itr = res;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                itr.next = list1;
                list1 = list1.next;
            }else{
                itr.next = list2;
                list2 = list2.next;
            }
            itr = itr.next;
        }
        while(list1 != null){
            itr.next = list1;
            list1 = list1.next;
            itr = itr.next;
        }
        while(list2 != null){
            itr.next = list2;
            list2 = list2.next;
            itr = itr.next;
        }
        return res.next;
    }
}