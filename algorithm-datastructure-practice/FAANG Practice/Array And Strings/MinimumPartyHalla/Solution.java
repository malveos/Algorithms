/***

@Author Omkar Malve

Party hall : minimum no of halls required to schedule requirred number of parties

****/
class Solution {

	public int getMinimumHalls(List<List<integer>> timingSlots) {
		
		// sort list based on start times
		Collections.sort(timingSlots, (ls) -> Integer.comparing(ls.get(0), ls.get(1)));
		int i = 0, j = 0, c = 0, max = 0;
		while(i < timingSlots.length() && j < timingSlots.length()) {
			// if new party can be started ; new strt <end time
			if (timingSlots.get(i).get(0) < timingSlots.get(j).get(1)) {
				c++; 
				i++;
			} else {
				c--;
				j++;
			}
			if (max < c) max = c;
		}
		return max;
	}

}