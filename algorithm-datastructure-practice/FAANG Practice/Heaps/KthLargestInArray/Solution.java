/***

@Author Omkar Malve

215. Kth Largest Element in an Array

Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

***/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // maintain minHeap of size k, and at least we get largest at top
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}