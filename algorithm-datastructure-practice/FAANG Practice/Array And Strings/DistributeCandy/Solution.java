/***

@Author Omkar Malve

Distribute Candies

Alice has n candies, where the ith candy is of type candyType[i]. Alice noticed that she started to gain weight, so she visited a doctor.

The doctor advised Alice to only eat n / 2 of the candies she has (n is always even). Alice likes her candies very much, and she wants to eat the maximum number of different types of candies while still following the doctor's advice.

Given the integer array candyType of length n, return the maximum number of different types of candies she can eat if she only eats n / 2 of them.

**/
class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length >> 1;      
        
        // taken size max will be 10^4 ; so such two times because of negative
        boolean []eaten = new boolean[200001];
        int ct = 0;
        for (int c : candyType) {
            int t = c + 100000;
            if (!eaten[t]) {
				if (++ct > n) return n;
                eaten[t] = true;
            }                
        }
        return ct;
        
         //Set<Integer> cset = new HashSet<>(IntStream.of(candyType).boxed().collect(Collectors.toList()));
        //cset.addAll(Arrays.asList(candyType));
        /*int half = candyType.length >> 1;
        boolean[] eaten = new boolean[200001];
        int count = 0;
        for (int num : candyType) {
            int type = num + 100000;
            if (!eaten[type]) {
                if (++count > half) {
                    return half;
                }
                eaten[type] = true;
            }
        }
        
        return count;
        return Math.min(n, cset.size());        */
    }
}