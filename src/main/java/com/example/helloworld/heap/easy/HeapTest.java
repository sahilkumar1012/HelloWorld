package com.example.helloworld.heap.easy;

public class HeapTest {
    public static void main(String[] args) throws Exception {
        MaxHeap heap = new MaxHeap(10);

        heap.insert(20);
        heap.insert(15);
        heap.insert(30);
        heap.insert(40);

        heap.printHeap();  // Should show max-heap

        System.out.println("Max: " + heap.deleteMax());  // 40
        heap.printHeap();

        // Heapify an existing array
        int[] arr = {3, 9, 2, 1, 4, 5};
        heap.heapify(arr);
        heap.printHeap();  // Heapified array
    }
}
