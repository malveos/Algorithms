/**
 Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.


**/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int [] merged = new int[total];
        int  i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                merged[k++] = nums2[j++];
            } else {
                merged[k++] = nums1[i++];
            }
        }
        
        while (i < nums1.length) {
            merged[k++] = nums1[i++];
        }
        
        while (j < nums2.length) {
            merged[k++] = nums2[j++];
        }
        
        if (total % 2 == 0) {
            return ((merged[total/2 - 1] + merged[(total/2)]) / 2.0);
        }
        return merged[total/2];
    }
}