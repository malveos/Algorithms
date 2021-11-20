/***

@Authir Omkar Malve

33. Search in Rotated Sorted Array

slpit in two parts of ascending and use end values to decide the way

***/
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length -1;
        // left ascending and right ascending part

        while (l<=r) {
            int m = (l + r)/2;
            if (nums[m] == target) return m;

            else if (nums[m] > nums[nums.length - 1]) {// right ascending 
                if (target < nums[0] || // for rotation
                    target > nums[m]) // left seg
                    l = m + 1;
                else
                    r = m -1;
            } else { // nums[m] > nums[0] : left ascending
                if (target < nums[m] || // right seg
                    target > nums[nums.length - 1]) // for rotation
                    r = m - 1;
                else
                    l = m + 1;
            }
        }
        return -1;
    }
}