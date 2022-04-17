/***

@Author Omkar Malve

1306. Jump Game III

Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.
***/
class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        q.add(start);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;
            int left = cur - arr[cur];
            int right = cur + arr[cur];
            if (arr[cur] == 0) return true;
            if (left <arr.length && left >=0 && !visited[left]) {
                q.add(left);
            }
            if (right <arr.length && right >=0 && !visited[right]) {
                q.add(right);
            }
        }
        return false;
    }
}