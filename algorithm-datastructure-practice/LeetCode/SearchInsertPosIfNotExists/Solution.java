/***
 Search Insert Position
 
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity

***/
class Solution {
    public int searchInsert(int[] nums, int target) {
        return findElemPos(nums, 0, nums.length - 1, target);
    }
    
    private int findElemPos(int[] nums, int st, int ed, int target) {
        int newPos = -1;
        while(st<=ed) {
            int mid = st + ((ed - st)>>2);
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                newPos = mid;
                ed = mid - 1;
            } else {
                st = newPos = mid + 1;
            }
        }        
        return newPos;
    }
}