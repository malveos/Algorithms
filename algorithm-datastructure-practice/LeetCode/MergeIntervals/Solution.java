/*
@Author Omkar Malve

Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
**/
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        // sort intervals by start of interval
        Arrays.sort(intervals, (x, y) -> {return x[0] - y[0];});
        List<int[]> ans = new ArrayList<>();
        for (int [] curInterval : intervals) {
            if (ans.size() == 0)
                ans.add(curInterval);
            else {
                // get last from list for checking merge condition
                int[] prev = ans.get(ans.size() - 1);
                // [a, b] [c, d] : merge if c <=b
                if(prev[1] >= curInterval[0])
                    prev[1] = Math.max(prev[1], curInterval[1]);
                else
                    ans.add(curInterval);                    
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}