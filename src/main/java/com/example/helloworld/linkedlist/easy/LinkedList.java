package com.example.helloworld.linkedlist.easy;

import com.example.helloworld.linkedlist.model.ListNode;

/**
 *      Linked List implementation.
 */
public class LinkedList {
    ListNode root;

    /**
     * insert a new node at head of this LinkedList with value = val
     * @param val   value of new node
     */
    void insertHead(int val){
        if(root == null){
            root = new ListNode(val);
            return;
        }

        ListNode node =new ListNode(val);
        node.next = root;
        root = node;
    }

    /**
     * delete the first value with value as val
     * @param val   value to be deleted
     */
    void delete(int val){
        if(root == null) return;
        if(root.val == val){
            root = root.next;   // deleted one node.
            return;
        }

        ListNode curr = root;
        while(root.next != null && root.next.val != val){
            curr = curr.next;
        }

        if(curr.next != null){
            curr.next = curr.next.next;
        }
    }

    /**
     * print this LinkedList
     */
    void print(){
        System.out.print("List = ");
        ListNode.print(root);
    }

    boolean search(int val){
        ListNode curr = root;
        while (curr != null) {
            if(curr.val == val) return true;
            curr = curr.next;
        }
        return false;
    }
}

class LinkedListTest{
    public static void main(String[] args) {
        LinkedList o = new LinkedList();
        o.insertHead(2);
        o.print();
        o.insertHead(3);

        o.print();
        o.delete(2);
        o.print();
        o.delete(3);
        System.out.println(o.search(3));
        o.print();

    }
}
