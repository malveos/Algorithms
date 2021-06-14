/**
31. Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

**/
class Solution {
    public void nextPermutation(int[] nums) {
        if (null == nums || nums.length <=1)
            return;
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i+1])
            i--;
        
        // we can have next permutation
        if (i >=0 ) {
            int j = nums.length - 1;
            while(nums[i] >= nums[j])
                j--;
            swap(i, j, nums);
        }
        
        // reverse array from i to last
        reverse(i + 1, nums.length - 1, nums);
    }
    
    public void swap(int i, int j, int[] nums) {
        nums[j] = nums[i] + nums[j];
        nums[i] = nums[j] - nums[i];
        nums[j] = nums[j] - nums[i];        
    }
        
    public void reverse(int i, int j, int[] nums) {
        // we can reverse like this as arre will be descending
        while(i < j) {
            swap(i++, j--, nums);
        }
    }
}