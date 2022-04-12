/***

@Author Omkar Malve

1207. Unique Number of Occurrences

Given an array of integers arr, return true if the number of occurrences of each value in the array is unique, or false otherwise.

***/
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>(n);
        for(int x : arr)
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        return new HashSet<>(mp.values()).size() == mp.size();
    }
}