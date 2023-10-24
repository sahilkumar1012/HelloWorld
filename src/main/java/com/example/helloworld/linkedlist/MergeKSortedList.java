package com.example.helloworld.linkedlist;

import com.example.helloworld.linkedlist.model.ListNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * hard
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

    // Implementation, using heap
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode listNode : lists) {
            if (listNode != null) // handle nulls properly.
                pq.offer(listNode);
        }

        ListNode list = new ListNode(-1), last = list;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            last.next = node; last = last.next;
            if (node.next != null)
                pq.offer(node.next);
        }

        return list.next;
    }

    // write a main method to test this function
    public static void main(String[] args) {
        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNode.fromArray(new int[]{1, 4, 5});
        lists[1] = ListNode.fromArray(new int[]{1, 3, 4});
        lists[2] = ListNode.fromArray(new int[]{2, 6});
        ListNode list = mergeKSortedList.mergeKLists(lists);
        ListNode.print(list);
    }

}

class MergeKSortedListDivideNConquer {
    // Merging K sorted linked list using Divide and conquer technique
    // We are not using any extra space O(1) space here and time complexity is O(nlogk)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int low, int high) {
        if (low > high) {
            return null;
        } else if (low == high) {
            return lists[low];
        } else {
            int mid = low + (high - low) / 2;
            ListNode left = helper(lists, low, mid);
            ListNode right = helper(lists, mid + 1, high);
            return merge(left, right);
        }
    }


    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;
        ListNode t1 = l1;
        ListNode t2 = l2;
        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                t.next = t1;
                t = t.next;
                t1 = t1.next;
            } else {
                t.next = t2;
                t = t.next;
                t2 = t2.next;
            }
        }

        while (t1 != null) {
            t.next = t1;
            t = t.next;
            t1 = t1.next;
        }

        while (t2 != null) {
            t.next = t2;
            t = t.next;
            t2 = t2.next;

        }
        return dummy.next;
    }
}