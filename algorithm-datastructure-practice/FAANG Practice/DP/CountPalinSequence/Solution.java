/**
SubString palindromes

**/
class Solution {
    public int findPalindromeSubsequences(String s) {
		int  n = s.length();
		boolean[][] dp = new boolean[n][n];
		for (int i = 0; i<n; i++) {
			dp[i][i] = true;
		}
		for (int i = 0; i<n-1; i++) {
			if(s.charAt(i) == s.charAt(i +1)) {
				dp[i][i+1] = true;
			}
		}
		
		// filling others after i =0 , j =2
		for (int dig = 2; dig<n; dig++) {
			int i = 0, j = dig;
			while(j<n) {
				if(s.charAt(i) == s.charAt(j) && dp[i+1][j - 1] == true ) {
					dp[i][j] = true;
				} else {
					dp[i][j] = false;
				}
				
				i++, j++;
			}
		}
		
		int ans = 0;
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++) {
				if(dp[i][j] == true) ans++;
			}
		}
		
		return ans;
    }
}