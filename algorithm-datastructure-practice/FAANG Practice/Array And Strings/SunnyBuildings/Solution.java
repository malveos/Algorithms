/***

@Author Omkar Malve

Sunny Building

If sun if at left and building s are on right; find all the building that will get sunlight

**/

class Solution {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i< n; i++)
			arr[i] = sc.nextInt();
		
		int maxHeight = Integer.MIN_VALUE;
		int count = 0;
		for (int i = 0; i< n; i++) {
			if (arr[i]>= maxHeight) {
				count++;
				maxHeight = Math.max(maxHeight, arr[i]);
			}
		}
		return count;
	}
}