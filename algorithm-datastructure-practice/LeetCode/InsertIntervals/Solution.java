/***

@Author Omkar Malve

Insert Interval

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

 
**/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0)
            return new int[][] {{newInterval[0], newInterval[1]}};

        List<int[]> ans = new LinkedList<>();
        // search position for new interval
        int pos = binarySearch(intervals, newInterval[0]);
        int i = 0;
        for (i = 0; i <= pos; i++) {
            ans.add(new int[] {intervals[i][0], intervals[i][1]});
        }

        // Merge intervals using pos
        if (pos >= 0) { // 
            i--;
            if (ans.get(i)[1] < newInterval[0]) { // prev end is less than new start
                ans.add(newInterval);
                i++;
            } else {
                ans.get(i)[1] = Math.max(ans.get(i)[1], newInterval[1]);
            }
        } else {
            ans.add(newInterval);
        }

        // Merge all intervals after the new interval
        for (int j = pos + 1; j < intervals.length; j++) {
            if (ans.get(i)[1] < intervals[j][0]) {
                ans.add(intervals[j]);
            } else  {
                ans.get(i)[1] = Math.max(ans.get(i)[1], intervals[j][1]);
            }
        }
        return ans.toArray(new int[][]{});

    }

    private int binarySearch(int[][] intervals, int target) {
        int pos = -1;
        int st = 0; int ed = intervals.length - 1;

        while(st <= ed) {
            int mid = (st + ed)/2;
            if (intervals[mid][0] <= target) {
                pos = mid;
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return pos;
    }
}