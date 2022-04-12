/****

@Author Omkar Malve

Find maximum cost needed to buy all books such that if book buy we need cost  = book value * left value * right value


****/
class Solution {
	private int[] dp;
	public int getMaxCostRequired(int[] books) {
		int n = books.length();
		dp = new int[n + 2]; // 2 edge for 1 value
		dp[0] = dp[n + 1] = 1;

		return solve(0, n + 1);
	}

	private int solve(int l, int r, int[] books) {
		if (r - l <=1) return 0;
		
		if (dp[l][r] != -1) return dp[l][r];
		
		int max = -1;
		for (int i = l + 1; i < r; i++) {
			max = Math.max(max, books[i] * books[l] * books[r] + solve(l, i) + solve(i, r)); 
		}
		return dp[l][r] = max;
	}
}