/**
First Missing Positive

Given an unsorted integer array nums, find the smallest missing positive integer.
You must implement an algorithm that runs in O(n) time and uses constant extra space.

**/
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int j = 0;
        
        for (int i =0; i<len; i++) {
            int cur = nums[i];
            // Move all elems to respective index in the array by swapping
            while(cur>=1 && cur<=len && nums[cur - 1] != cur) {
                int temp = nums[cur - 1];
                nums[cur - 1] = cur;
                cur = temp;
            }
        }
        
       // printArr(nums);
        for(int i = 0; i<len; i++) {
         if(nums[i] != i + 1)
             return i + 1;
        }
        return len + 1;
    }
    
    private void printArr(int[] ar) {
        for (int n: ar)
            System.out.print(n + " ");
        System.out.println();
    }
}