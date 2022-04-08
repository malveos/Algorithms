/*****

@Author Omkar Malve


973. K Closest Points to Origin

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).


***/
class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> (y[0] * y[0] + y[1] * y[1]) - (x[0] * x [0] + x[1] * x[1]));

        for (int[] p : points) {
            maxHeap.add(p);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        int [][] ans = new int[k][2];
        while(k-- > 0) {
            ans[k] = maxHeap.poll();
        }
        return ans;
    }
}