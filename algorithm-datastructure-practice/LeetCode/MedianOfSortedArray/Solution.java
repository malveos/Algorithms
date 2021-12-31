/***
@Author Omkar Malve

4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

-- Make lalf of fisrt array and then try to make the same no at both sides usign next array.
Move this partition acc to the balancing the merging.

***/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // make left one smaller
        if (nums1.length > nums2.length) {
            int [] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int l = 0, r = m;
        int half = (m + n + 1)/2;
        double median = 0.0;
        
        while (l <= r) {
            int i = (l + r)/2;
            int j = half - i;
            
            if (i < r && nums1[i] < nums2[j -1]) { // left max from 2 is greater than right min from 1
                l = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {//right min from 1 is greter than left max from 2
                r = i - 1;
            } else {
                int mid = 0;
                if (i == 0) mid = nums2[j -1];
                else if (j == 0) mid = nums1[i - 1];
                else mid = Math.max(nums1[i - 1], nums2[j - 1]);

                if ((n + m)%2 == 1) return mid;

                int midR = 0;
                if (i == m) midR = nums2[j];
                else if (j == n) midR = nums1[i];
                else midR = Math.min(nums1[i], nums2[j]);
                
                if ((n + m) %2 == 0) return (mid + midR) / 2.0;
                
                l = r + 1;
            }
        }
        return median;
    }
}