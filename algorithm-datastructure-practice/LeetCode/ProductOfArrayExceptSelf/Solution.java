/***

@Author Omkar Malve

238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.


***/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n == 0) return null;
        int ans[] = new int[n];
        
        int left[] = new int[n]; left[0] = 1;
        int right[] = new int[n]; right[n - 1] = 1;
        
        int i = 1;
        while (i < n) {
            left[i] = left[i - 1] * nums[i - 1];
            right[n - i - 1] = right[n - i] * nums[n - i];
            i++;
        }
       // print(left);
       // print(right);
        
        for (i = 0; i < n; i++)
            ans[i] = left[i] * right[i];
        
        return ans;        
    }

    private void print(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}