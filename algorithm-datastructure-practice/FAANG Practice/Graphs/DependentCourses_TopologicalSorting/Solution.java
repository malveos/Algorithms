/***

@Author Omkar Malve

207. Course Schedule

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.



***/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0)
            return true;
        //Topological Sort
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> bfs = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                bfs.add(i);
        }
        int ct = bfs.size();// maintain processed count and all started can be completed

        while(!bfs.isEmpty()) {
            int cur = bfs.poll();
            // check neighbours that can be finished
            for (int i = 0; i < prerequisites.length; i++) {
                // if cur was target then decrease its indegree
                if (prerequisites[i][1] == cur) {
                    int target = prerequisites[i][0];
                    indegree[target]--;
                    if (indegree[target] == 0) {// if this can be next then add
                        ct++;
                        bfs.add(target);
                    }
                }
            }
        }
        return ct == numCourses;
    }
}