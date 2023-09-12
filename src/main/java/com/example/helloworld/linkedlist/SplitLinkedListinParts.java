package com.example.helloworld.linkedlist;

import com.example.helloworld.linkedlist.model.ListNode;

/**
 * leetcode 725. Split Linked List in Parts
 * amazon, google
 * https://leetcode.com/problems/split-linked-list-in-parts/description/
 *
 * Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.
 *
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.
 *
 * The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.
 *
 * Return an array of the k parts.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but its string representation as a ListNode is [].
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * Output: [[1,2,3,4],[5,6,7],[8,9,10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 1000].
 * 0 <= Node.val <= 1000
 * 1 <= k <= 50
 */
public class SplitLinkedListinParts {
    /**
     * reference video : https://youtu.be/tY1HevJFD98
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        ListNode curr = head, prev = null;
        int len = 0;
        while(curr != null){
            len++; curr = curr.next;
        }

        int nodes = len/k;  // nodes in each block
        int extras = len%k; // ek ek karke starting se daalte rhege har block

        for(int i=0; head!=null && i<k; i++){
            result[i] = head;
            for(int j=0; j < nodes + (extras > 0 ? 1 : 0) ; j++){
                prev = head;
                head = head.next;
            }
            prev.next = null;
            extras--;
        }
        return result;
    }
}
