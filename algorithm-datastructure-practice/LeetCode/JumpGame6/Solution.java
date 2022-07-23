/***

@Author Omkar Malve

1696. Jump Game VI

You are given a 0-indexed integer array nums and an integer k.

You are initially standing at index 0. In one move, you can jump at most k steps forward without going outside the boundaries of the array. That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.

You want to reach the last index of the array (index n - 1). Your score is the sum of all nums[j] for each index j you visited in the array.

Return the maximum score you can get.



****/
class Solution {
    public int maxResult(int[] nums, int k) {
        return getByDP(nums, k);
    }

    private int getByDP(int[] nums, int k) {
        // idea is to keep a max in every range of i to k
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int mx = dp[0];
        int maxI = 0;
        
        for (int i = 1; i < nums.length; i++) {
            dp[i] = mx + nums[i];
            
            // update max if
            if (dp[i] >= mx) {
                mx = dp[i];
                maxI = i;
            } else if (maxI == i - k) {
                maxI = updateNewMaxFromRange(dp, i - k + 1, i);
                mx = dp[maxI];
                //System.out.println("Getting newMax from range bet:" + (i - k + 1) + " and "+ i);
            }
        }
       // System.out.println("DP : "+ Arrays.toString(dp));
        return dp[nums.length - 1];
    }

    private int updateNewMaxFromRange(int[] dp, int st, int ed) {
        int mx = dp[st];
        int maxI = st;
        for (int i = st; i <= ed; i++) {
            if (mx <= dp[i]) {
                mx = dp[i];
                maxI = i;
            }
        }
        return maxI;
    }
 
    private int getByDequeue(int[] nums, int k) {
        // this list keeps track of max k elems with max values consecutively
        LinkedList<Integer> ls = new LinkedList<Integer>();
        ls.add(0);
        for (int i = 1; i < nums.length; i++) {
            
            //List remove is it got out of range of k
            if(ls.getFirst() < i - k) {
                //System.out.println("Removing ListFirst from: " + ls + " as "+ i + " - " + k + " is greater than ListFirst");
                ls.removeFirst();                
            }

            //System.out.println("Adding to  "+ i+ " value of listFirst:" + nums[ls.getFirst()]); 
            nums[i] += nums[ls.getFirst()];// Adding maximum from start of k
            //System.out.println("After adding list first elem , New Nums[" + i + "] = " + nums[i]);
            
            // Remove if new added is greater than the end of current list
            while(!ls.isEmpty() && nums[ls.getLast()] <= nums[i]){
                //System.out.println("Removing last from list as ( " + nums[ls.getLast()] + "<= " + nums[i] + ")");
                ls.removeLast();   
            }
            //System.out.println("List become here: " + ls);
            ls.add(i);
            //System.out.println("Array is " + Arrays.toString(nums)); 
            //System.out.println("List Loop end: " + ls + "\n");            
        }
        return nums[nums.length - 1];
    }
}