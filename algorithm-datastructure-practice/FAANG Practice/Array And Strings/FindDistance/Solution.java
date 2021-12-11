/***

@Author Omkar Malve

244 : Word Distance 2


**/

public Solution {

	public int findDistance (String[] words, String word1, String word2) {
		int i = 0, int min = words.length;
		if (word1.equals(word2)) {
			int p = -1;
			for (String w : words) {
				if (w.equals(word1)) {
					if (p == -1) {
						p = i;
					} else {
						min = Math.min(min, Maths.abs(p-i));
						p = i;
					}
				}
				i++;
			}
		} else {
			int a1 = -1, a2 = -1;
			for (String w : words) {
				if (w.equals(word1)) {
					a1 = i;
				} else if (w.equals(word2)){
					a2 = i;
				}
				if (a1 != -1 && a2 != -1) {
					min + Math.min(min, Maths.abs(a1 - a2));
				}
				i++;
			}
		}
		return min;
	}
	
}