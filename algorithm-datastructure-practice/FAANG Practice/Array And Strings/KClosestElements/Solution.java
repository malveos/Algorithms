/***
@Author Omkar Malve

658. Find K Closest Elements

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 


**/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
     
        int idx = 0, s = 0, n = arr.length;
        for (int i = 0; i < k; i++) {
            s+= Math.abs(x - arr[i]);
        }
        
        int sum = s;
        for (int i = 1; i <= n- k; i++) {
            s+= Math.abs(x - arr[i + k - 1]);
            s-= Math.abs(x - arr[i - 1]);
            if (s < sum) {
                sum = s;
                idx = i;
            }
        }
        List<Integer> ans = new ArrayList<>(k);
        for(int i = 0; i < k; i++)
            ans.add(arr[i + idx]);
        return ans;
    }
}