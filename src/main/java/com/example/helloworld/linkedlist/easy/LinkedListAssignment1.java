package com.example.helloworld.linkedlist.easy;
import com.example.helloworld.linkedlist.model.ListNode;

/**
 *      Linked List implementation.
 */
class LinkedListAssignment1 {
    ListNode root;

    /**
     * insert a new node at head of this LinkedList with value = val
     * @param val   value of new node
     */
    void insertHead(int val){
        // todo implement
    }

    /**
     * delete the first value with value as val
     * @param val   value to be deleted
     */
    void delete(int val){
        // todo implement
    }

    /**
     * print this LinkedList
     */
    void print(){
        // todo implement
    }

    /**
     * @param val   search for node with value = val in this list
     * @return  true/false
     */
    boolean search(int val){
        // todo implement
        return false;
    }
}

class LinkedListAssignment1Test{
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

