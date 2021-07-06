/**

@Author Omkar Malve

Circular Array Loop

You are playing a game involving a circular array of non-zero integers nums. Each nums[i] denotes the number of indices forward/backward you must move if you are located at index i:

If nums[i] is positive, move nums[i] steps forward, and
If nums[i] is negative, move nums[i] steps backward.
Since the array is circular, you may assume that moving forward from the last element puts you on the first element, and moving backwards from the first element puts you on the last element.

A cycle in the array consists of a sequence of indices seq of length k where:

Following the movement rules above results in the repeating index sequence seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
Every nums[seq[j]] is either all positive or all negative.
k > 1
Return true if there is a cycle in nums, or false otherwise.

**/

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        return circularArray(nums) ;
    }

    public boolean circularArray(int[] nums) {
        // two pointer approach to chcek a loop
        // make all values Less than length
    	for (int i = 0; i < nums.length; i++) {
    		nums[i] %= nums.length;
    	}
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }

            int slowPtr = i;
            int fastPtr = i;
            
            // for checking reverse direction we can check magnitude of consecutive jumps
            // Ex: if both are same product will be positive
            
            while (  (nums[slowPtr] * nums[nextIndex(nums, slowPtr)] > 0) // one jump 
                  && (nums[fastPtr] * nums[nextIndex(nums, fastPtr)] > 0)  // two jumps
                  && (nums[fastPtr] * nums[nextIndex(nums, nextIndex(nums, fastPtr))] > 0)) {

                slowPtr = nextIndex(nums, slowPtr);
                fastPtr = nextIndex(nums, nextIndex(nums, fastPtr));

                if (fastPtr == slowPtr) {
                    // check if  it is not a single jump
                    if (slowPtr == nextIndex(nums, slowPtr)) {
                        break;
                    }
                    System.out.println("Loop at" + slowPtr);
                    return true;
                }
            }
            
            // after unsuccessful iteration we can say same values will never lead to a loop , So make them 0
            // WE can decide firection using first value
            // Ex: If going forward make positives 0.
            // Ex: If going backward make negatives 0.
            
            while (slowPtr != fastPtr) {
                 int temp = slowPtr; 
                 slowPtr = nextIndex(nums, slowPtr);
                 nums[temp] = 0;
            }
        }
        return false;        
    }
    
    private int nextIndex(int[] nums, int i) {
        // find next index  with jump i
        // consider negative index with adding array size
        return (i + nums[i] + nums.length) % nums.length;
    }
}