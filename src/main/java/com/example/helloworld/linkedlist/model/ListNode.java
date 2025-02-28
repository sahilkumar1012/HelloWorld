package com.example.helloworld.linkedlist.model;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // create fromArray
    public static ListNode fromArray(int[] arr) {
        ListNode head = new ListNode();
        ListNode current = head;
        for (int j : arr) {
            current.next = new ListNode(j);
            current = current.next;
        }
        return head.next;
    }

    // create print function
    public static void print(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println();
    }

}
