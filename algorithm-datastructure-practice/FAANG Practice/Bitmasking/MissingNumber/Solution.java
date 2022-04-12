/***

@Author Omkar Malve

268. Missing Number

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.


**/
class Solution {
    public int missingNumber(int[] nums) {
        // a ^ b ^ c ^ b ^ a = c
        int ans = 0;    
        for(int n : nums)
            ans ^= n;
        
        for (int i = 0; i <= nums.length; i++)
            ans ^= i;
        return ans;
    }
}