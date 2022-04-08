/****

@author Omkar Malve


Merge k sorted arrays


**/

class Solution {
	public static List<Integer> mergeKSortedArrays(int[][] arrays) {
		PriorityQueue<Node> minHeap = new PriorityQueue<>();
		for (int [] a : arrays)
			minHeap.add(new Node(a, 0));// Adding start of all
		
		List<Integer> ans = new LinkedList<>();
		while (!minHeap.isEmpty()) {
			Node top = minHeap.poll();
			ans.add(top.arr[top.index]);
			if (top.index + 1 < top.arr.length)
				minHeap.add(new Node(top.arr, top.index + 1));
		}
		return ans;
	}
	
	
}
class Node implements Comparable<Node> {
	public int[] arr;
	public int index;
	
	@Override
	public int compareTo(Node other) {
		return this.arr[this.index] - other.arr[other.index];
	}
}