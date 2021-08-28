/*****

@Author Omkar Malve

Word distance from list of words


****/

public class Solution {
	public int getWordDistance(List<String> words, String w1, String w2) {
		int wc1 = -1;
		int wc2 = -1;
		int minDistance = Integer.MAX_VALUE;
		int i = 0;
		for (String w : words) {
			if (w.equals(w1)) {
				wc1 = i;
			}
			if (w.equals(w2)) {
				wc2 = i;
			}
			
			if (wc1 != -1 && wc2 != -1) {
				int dist = Math.mod(wc1 - wc2);
				if( dist < minDistance) minDistance = dist;
			}
			i++;
		}
		return minDistance;
	}

}