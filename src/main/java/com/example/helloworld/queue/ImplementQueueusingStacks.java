package com.example.helloworld.queue;


import java.util.Stack;

/**
 * leetcode 232. Implement Queue using Stacks
 *
 * code harmony solution video : https://youtu.be/KECpyDI9m1I
 *
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 *
 * Implement the MyQueue class:
 *
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 1, 1, false]
 *
 * Explanation
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 *
 *
 * Constraints:
 *
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, peek, and empty.
 * All the calls to pop and peek are valid.
 *
 *
 * Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
 */
public class ImplementQueueusingStacks {

    // Inner class representing the MyQueue implementation
    class MyQueue {

        // Two stacks to simulate the queue
        Stack<Integer> s1;
        Stack<Integer> s2;

        // Variable to store the front element of the queue
        int front;

        // Constructor to initialize the stacks and front
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
            front = -1;
        }

        // Method to push an element to the back of the queue
        public void push(int x) {
            // If s1 is empty, set the front element
            if (s1.isEmpty()) {
                front = x;
            }
            // Push the element to s1
            s1.push(x);
        }

        // Method to remove and return the element from the front of the queue
        public int pop() {
            // If s2 is empty, transfer elements from s1 to s2
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            // Pop from s2
            return s2.pop();
        }

        // Method to return the element at the front of the queue without removing it
        public int peek() {
            // If s2 is not empty, return the top element of s2
            if (!s2.isEmpty()) {
                return s2.peek();
            }
            // Otherwise, return the front element stored in the variable
            return front;
        }

        // Method to check if the queue is empty
        public boolean empty() {
            // Queue is empty if both s1 and s2 are empty
            return s1.isEmpty() && s2.isEmpty();
        }
    }
}

// Class representing a brute-force approach for implementing a queue using stacks
class ImplementQueueusingStacksBruteForceApproach {

    // Two stacks to simulate the queue
    Stack<Integer> s1;
    Stack<Integer> s2;

    // Constructor to initialize the stacks
    public ImplementQueueusingStacksBruteForceApproach() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Method to push an element to the back of the queue
    public void push(int x) {
        // Transfer all elements from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        // Push the new element to s1
        s1.push(x);
        // Transfer elements back from s2 to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Method to remove and return the element from the front of the queue
    public int pop() {
        // Pop from s1
        return s1.pop();
    }

    // Method to return the element at the front of the queue without removing it
    public int peek() {
        // Return the top element of s1
        return s1.peek();
    }

    // Method to check if the queue is empty
    public boolean empty() {
        // Queue is empty if s1 is empty
        return s1.isEmpty();
    }
}
