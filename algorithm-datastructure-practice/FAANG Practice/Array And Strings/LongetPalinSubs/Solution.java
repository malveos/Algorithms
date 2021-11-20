/***

@Author Omkar Malve

5. Longest Palindromic Substring

Given a string s, return the longest palindromic substring in s.


***/
class Solution {
	public String longestSubString(String str) {
		if (str == null) return null;
		if (str.isEmpty()) return "";
		
		// fill all gaps with new character as to make string odd to get center
		char[] input = new char[2 * str.length() + 1];
		for (int  i = = str.length(); i>=0; i--) {
			input[2*i+1] = str.charAt(i);
			input[2*i] = '*';
		}
		input[2*str.length()]= '*';
		
		int [] LPS = new int[2*str.length() + 1];
		int c = 0; //center
		int r = 0; // right boundry
		
		
		for (int x = 1 ; x<LPS.length(); x++) {
			int mrrorIndex = 2*c - x;
			if (x<r) {
				LPS[x] = Math.min(r- x, LPS[mrrorIndex]);
			}
			while(x+LPS[x]+1<=2*str.length() 
				&& x-LPS[x]-1>=0
				&& input[x+LPS[x]+1] == input[x-LPS[x]-1]) {
					LPS[x]++;
				}
			if (x+LPS[x]>r) {
				c = x;
				r = x+LPS[x];
			}
		}
		
		int valueMax = 0;
		int indexMax = 0;
		for(int  i=0; i<LPS.length(); i++) {
			if (LPS[i]>valueMax) {
				valueMax = LPS[i];
				indexMax = i;
			}
		}
		
		int palinSpan = valueMax/2;
		if (indexMax%2==0)
			return str.substring(indexMax/2-palinSpan, indexMax/2+palinSpan);
		else
			return str.substring(indexMax/2-palinSpan, indexMax/2+palinSpan + 1);
	}
}