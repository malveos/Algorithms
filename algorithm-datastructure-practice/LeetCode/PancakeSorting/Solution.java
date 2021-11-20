/***

@Author Omkar Malve

Pancake Sorting 
Can flip first N elements

***/

class Solution {
    public Integer findLargest(int[] a, int n) {
		for (int i = 0; i < a.length; i++)
			if (a[i] == n) return i;
		return -1;
	}
	
	public void flip(int[] a, int j) {
		for (int  i = 0; i < j/2; i++) {
			// swap i, k-i
			int t = a[i];
			a[i] = a[j-i-1];
			a[j-i-1] = t;
		}
	}

	public List<Integer> pancakeSort(int[] a) {
		// find largest 
		int n = a.length;
		
		List<Integer> sol = new ArrayList<>(n);
		
		while (n > 0) {
			int largest = findLargest(a, n);
			if (largest != n - 1) {
				flip(a, largest + 1);
				flip(a, n);
				sol.add(largest + 1);
				sol.add(n);
			}
			n--;
		}
		return sol;
	}
}