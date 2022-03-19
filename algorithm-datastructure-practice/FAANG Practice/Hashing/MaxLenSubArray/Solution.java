/***

@Author Omkar Malve

Maximum Length of subarray to target sum

***/

class Solution {

	public int getMaxLen(int [] nums, int k) {
		// need commulative sum startign with 0
		int [] cumm = new int[nums.length + 1];
		int max = Integer.MIN_VALUE;
		
		cumm[0] = 0;
		int val = 0;
		for (int i = 0; i < nums.length; i++) {
			val += nums[i];
			cumm[i + 1] = val;
		}
		
		// map of cummulative to index
		Map<Integer, Integer> mp = new HashMap<>();
		for (int i = 0; i < cumm.length; i++) {
			mp.put(mp.get(i), i);
		}
		
		// j - i = k  So find (i  + k -> j)
		for (int i = 0; i < cumm.length; i++) {
			int key = k + mp.get(i);
			// it key prensent check if it is maximum length
			if (mp.containsKey(key)) {
				int idx = mp.get(key);
				if (idx - i > max)
					max = idx - i;
			}
		}

		return max;
	}
}