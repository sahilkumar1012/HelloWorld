package com.example.helloworld.linkedlist;

import com.example.helloworld.linkedlist.model.ListNode;
import com.example.helloworld.tree.model.TreeNode;

/**
 * leetcode problem 109. Convert Sorted List to Binary Search Tree
 *
 Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;

        // finding middle node of the list.
        ListNode slow = head,fast = head, prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(prev!=null)
            prev.next = null;
        else      // when we're left with just one node for left..
            return new TreeNode(slow.val);

        // recurison
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }
}