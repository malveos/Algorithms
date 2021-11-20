/**
@Author Omkar Malve

34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

***/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findIndex(nums, target, true);
        ans[1] = findIndex(nums, target, false);
        return ans;
    }
    
    private int findIndex(int [] nums, int target, boolean isFirst) {
        int st = 0, ed = nums.length -1;
        int index = -1;
        while (st <= ed) {
            int mid = (st + ed)/2;
            if (nums[mid] == target) {
                index = mid;
                if (isFirst) {
                    ed = mid - 1;    
                } else {
                    st = mid + 1;
                }
            } else if (nums[mid] < target) {
                st = mid +1;
            } else {
                ed = mid -1;
            }
        }
        return index;
    }
}