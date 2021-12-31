/***
@Author Omkar Malve

480. Sliding Window Median

The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle values.

For examples, if arr = [2,3,4], the median is 3.
For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
You are given an integer array nums and an integer k. There is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the median array for each window in the original array. Answers within 10-5 of the actual value will be accepted.


**/
class Solution {
    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        double[] ans = new double[len - k + 1];
        for (int i = 0; i < len; i++) { // Store in heaps and then start getting midian by using tops
            addInHeap(nums[i]);
            if (i + 1 >= k) { // Need calculations here
                ans[i - k + 1] = getMid();
                removePrevious(nums[i - k + 1]);
            }
        }
        return ans;
    }

    private void addInHeap(int num) {
        if (maxHeap.size() == 0 || maxHeap.peek() >= num)
            maxHeap.add(num);
        else
            minHeap.add(num);
        heapUp();
    }

    private void heapUp() {
        if (maxHeap.size() == minHeap.size()) return;
        
        if (minHeap.size() + 1 < maxHeap.size())
            minHeap.add(maxHeap.poll());
        else if (minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }

    private double getMid() {
        return minHeap.size() < maxHeap.size() ? maxHeap.peek() : maxHeap.peek()/2.0 + minHeap.peek() / 2.0;
    }

    private void removePrevious(int num) {
        if (num > maxHeap.peek())
            minHeap.remove(num);
        else
            maxHeap.remove(num);
        heapUp();
    }
}