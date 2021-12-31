/**

@Author Omkar Malve

27. Remove Element

Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.


**/

class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null) return 0;
        
        int left = 0 , right = 0;
        while (right < nums.length) {
            while(right != nums.length && nums[right] == val ) {
                right++;
            }
            if (right == nums.length) break;
            nums[left++] = nums[right++];
        }
        return left;
    }
}