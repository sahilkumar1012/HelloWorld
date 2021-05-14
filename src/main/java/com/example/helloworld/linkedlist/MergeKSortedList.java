package com.example.helloworld.linkedlist;

import com.example.helloworld.linkedlist.model.ListNode;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *
 * leetcode 23. Merge k Sorted Lists
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 *
 * Constraints:
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length won't exceed 10^4.
 */
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((o1, o2) -> o1.val - o2.val);
        for(int i=0; i<lists.length; ++i){
            if(lists[i]!=null) // handle nulls properly.
                pq.offer(lists[i]);
        }

        ListNode temp;
        ListNode list = new ListNode(-1), last = list;
        while(!pq.isEmpty()){
            temp = pq.poll();
            last.next = temp;
            last = last.next;
            if(temp.next!=null) pq.offer(temp.next);
        }

        return list.next;
    }
}