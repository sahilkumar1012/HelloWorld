package com.example.helloworld.heap.easy;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    // Get parent and children indexes
    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    // Swap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Percolate Up
    private void percolateUp(int index) {
        while (index > 0 && heap[parent(index)] < heap[index]) {        // change < to > for minHeap
            swap(index, parent(index));
            index = parent(index);
        }
    }

    // Percolate Down
    private void percolateDown(int index) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            percolateDown(largest);
        }
    }

    // Insert
    public void insert(int val) throws Exception {
        if (size == capacity) throw new Exception("Heap is full");
        heap[size] = val;
        percolateUp(size);
        size++;
    }

    // Delete max (root)
    public int deleteMax() throws Exception {
        if (size == 0) throw new Exception("Heap is empty");
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        percolateDown(0);
        return max;
    }

    // Heapify an existing array
    public void heapify(int[] arr) {
        this.heap = arr;
        this.size = arr.length;
        this.capacity = arr.length;
        for (int i = (size / 2) - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    // Print Heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
