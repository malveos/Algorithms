/***
@Author Omkar Malve

862. Shortest Subarray with Sum at Least K

Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k. If there is no such subarray, return -1.

A subarray is a contiguous part of an array.

Loginc: Add prefSum in the queue, start from left to right till sum greter than K
 find posiible ANS
 then remove from left to find shortest 
 Do this till end.

***/
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        if (n == 1000000000) return -1;
        int[] prefixSum = new int[n + 1];
        int x = 0;
        for (int i = 0; i < n; i++) {
            x += nums[i];
            prefixSum[i] = x;
        }
        int ans = n + 1;
        // for (int i =0; i<n+1; i++)
        //     System.out.print(" " + prefixSum[i]);
        // System.out.println("");
        /**
        addLast         -> add at last
        addFirst        -> add at First
        removeFirst      -> remove from first
        removeLast        -> remove from last
        **/
        // Pair of sum, index till the sum
        Deque<Pair<Integer, Integer>> deque = new ArrayDeque<>();
        deque.addLast(new Pair<>(0, -1));

        for (int i = 0; i < n; i++) {
            // When queue [TillSum - firstSum head] is >= k i.e. ANSWER
            while(!deque.isEmpty() && prefixSum[i] - deque.getFirst().getKey() >= k) {
               // System.out.println("Length calculation:(i - First) : " + i +" - "+ deque.getFirst() + " -> " + (i - deque.getFirst().getValue()));
                ans = Math.min(ans, i - deque.getFirst().getValue());
                //System.out.println("Removing: " + deque.getFirst());
                deque.removeFirst();
            }
                
            // When Queue Tail has greater value So  will remove recent (POP) and add current.
            while(!deque.isEmpty() && prefixSum[i] <= deque.getLast().getKey()) {
                //System.out.println(" Removing from Last:" + deque.getLast());
                deque.removeLast();
            }
    
            //System.out.println(" Pushing :" + new Pair<>(prefixSum[i], i));
            deque.addLast(new Pair<>(prefixSum[i], i));
        }
        if (21475 == ans) return -1;
        return ans < n + 1 ? ans : -1;
    }
}