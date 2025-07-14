package dsa;

import utility.Utility;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest in heap
            }
        }

        return minHeap.peek(); // top of the heap is kth largest
    }

    public static void main(String[] args) {
        int[] array = Utility.generateIntegerArray(4);
        int kthLargest = findKthLargest(array, 2);
        System.out.println(kthLargest);
    }
}
