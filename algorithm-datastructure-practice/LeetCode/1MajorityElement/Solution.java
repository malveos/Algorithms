/**
Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.


**/
class Solution {
    public int majorityElement(int[] nums) {
        int n  = nums.length;
        int elem = 0;
        int ct = 0;
        for(int num : nums) {
            if(num == elem) {
                ct++;
            } else if(ct == 0) {
                elem = num;
            } else {
                ct--;
            }
        }
        return elem;
    }
}