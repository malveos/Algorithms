
/***

@Author Omkar Malve

REturn array of size n such that sum add up to zero, no duplicates allowed

***/
class Solution {
	public Set<Integer> targetZero(int n) {
		Set<Integer> ans = new HashSet<>();
		int half = (n/2);
		for (int  i = 0; i<half; i++) {
			ans.add(i);
			ans.add(i * -1);
		}
		if (n%2 != 0) ans.add(0);
		return ans;
	}

}