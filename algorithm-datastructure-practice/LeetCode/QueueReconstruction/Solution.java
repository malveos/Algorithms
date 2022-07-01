/***

@Author Omkar Malve

406. Queue Reconstruction by Height

You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.

Reconstruct and return the queue that is represented by the input array people. The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).


***/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // IF sae height then decrasing order of infront person count else default decrease
        Arrays.sort(people, (x, y) -> x[0] == y[0] ? x[1] - y[1] : y[0] - x[0]);
        System.out.println(people);

        // Insert everyone at theri index i.e. persons on front; it will adjust infront count
        List<int[]> ans = new LinkedList<>();
        for( int[] t : people)
            ans.add(t[1], t);
        
        return ans.toArray(new int[ans.size()][]);
    }
}