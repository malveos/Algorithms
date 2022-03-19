public class Solution {
	public int getLongestSubstringLengthWithKDistictCharacter(String s, int k) {
			int n = s.length();
			if (n * k == 0) return 0; // if anyone is 0
			int l = 0;
			int maxL = 0;
			Map<character, Integer> mp = new HashMap<>();
			for (int  i = 0; i < n; i++) {
				char c = s.charAt(i);
				mp.put(c, i);
				if (mp.size() == k + 1) { // remove most first added in map/
					// need record whose value is minimum
					int minVal = Integer.MAX_VALUE;
					char minKey = '0';
					for (char chr  : mp.keySet()) {
						if (mp.get(chr) < minVal) {
							minVal = mp.get(chr);
							minKey = chr;
						}
					}
					l = minVal + 1;
					mp.remove(minKey);
				}
				maxL = Math.max(maxL, i - l + 1);
			}
			
			return maxL;
	}
}