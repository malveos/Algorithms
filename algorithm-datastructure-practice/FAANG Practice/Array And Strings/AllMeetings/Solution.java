/**

@Author Omkar Malve

Max meetings that can be attended

***/
class Solution {

	public static class Interval implements Comparable{
		private int st;
		private int ed;
		
		Interval(int s, int e){st = s; ed =e;}
		@Override
		public int compareTo(Interval iv) {
			return this.st - iv.st; // Sort basic of interval array
		}
	}
	
	public boolean canAttendAllMeetings(Interval[] intervals) {
		if (intervals == null || intervals.length < 2) return true;
		Arrays.sort(intervals);
		
		int i = 1;
		while (i < intervals.length) {
			if (intervals[i].st < intervals[i-1].ed)
				return false;
			i++;
		}
		
		
		return true;
	}
}