/**
Search in Rotated Sorted Array
Array will be rotated in any direction before input

**/
class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }
    
    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right)
            return -1;
        if (left == right)
            return nums[left] == target ? left : -1;
        if (left == right -1)
            if (nums[left] == target)
                return left;
            else if (nums[right] == target)
                return right;
            else
                return -1;
        
        int mid = (left +right)/2;
        if (nums[mid] == target)
            return mid;
        // below test added due to rotation of array
        else if(nums[mid]>nums[left]  && target <= nums[mid] && target >= nums[left])
            return binarySearch(nums, left, mid, target);
        else if(nums[mid] >= nums[left])
            return binarySearch(nums, mid, right, target);
        // below test added due to rotation of array
        else if(nums[mid] < nums[left] && target>nums[mid] && target<nums[left])
            return binarySearch(nums, mid, right, target);
        else
            return binarySearch(nums, left, mid, target);
    }
}