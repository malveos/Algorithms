/***

@Author Omkar Malve

154. Find Minimum in Rotated Sorted Array II

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:

[4,5,6,7,0,1,4] if it was rotated 4 times.
[0,1,4,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.

You must decrease the overall operation steps as much as possible.


***/
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n -1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if(nums[m] < nums[r]) { // smaller will be on left
              r = m;
            } else if (nums[m] > nums[r]) {
                l = m + 1;
            } else { // if both same check if right part has one lesser
                if (r != 0 && nums[r] >= nums[r - 1]) {// it has one smaller on left
                    r--;
                } else// right have sammlest on left
                    return nums[r];
                    
            }
        }
        return -1;
    }
}