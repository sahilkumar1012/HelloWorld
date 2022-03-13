package com.example.helloworld.linkedlist.easy;


import com.example.helloworld.linkedlist.model.ListNode;

/**
 * leetcode 19. Remove Nth Node From End of List
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 *
 * Follow up: Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * ## Single pass solution ##
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();    // sentinel
        dummy.next = head;

        ListNode slow = dummy, fast = dummy;
        while(n -- > 0)
            fast = fast.next;

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }

    /**
     * Removing nth node from end of a list. In two passes.
     */
    public ListNode removeNthFromEndTwoPasses(ListNode head, int n) {
        int len = lengthOfLinkedList(head);
        if(len == 1) return null;
        if(n == len) return head.next;

        int k = len - n -1;
        ListNode temp = head;
        while(k -- > 0)
            temp = temp.next;

        temp.next = temp.next.next;
        return head;
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
