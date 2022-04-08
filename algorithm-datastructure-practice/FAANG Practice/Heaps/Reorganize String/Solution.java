/****

@Author Omkar Malve


767. Reorganize String

Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
Return any possible rearrangement of s or return "" if not possible.

****/
class Solution {
    public String reorganizeString(String s) {
        // create maxHeap of <int, char> from a string i.e. we alwasy need a pair having one as maxOccuring
        Map<Character, Integer> mp = new HashMap<>();
        for (char cc : s.toCharArray())
            mp.put(cc, mp.getOrDefault(cc, 0) + 1);

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((x, y) -> mp.get(y) - mp.get(x));
        maxHeap.addAll(mp.keySet());
        
        StringBuilder sb = new StringBuilder();
        while(maxHeap.size() > 1) {
            char c1 = maxHeap.poll();
            char c2 = maxHeap.poll();
            sb.append(c1);sb.append(c2);

            // push back if ther is more count
            mp.put(c1, mp.get(c1) - 1);
            mp.put(c2, mp.get(c2) - 1);
            
            if (mp.get(c1) > 0) maxHeap.add(c1);
            if (mp.get(c2) > 0) maxHeap.add(c2);
            
            // check if map size is less than 1
            if (maxHeap.size() == 1) {
                char c = maxHeap.poll();
                int ct = mp.get(c);
                
                // if only remin has more than 1 chars we cannot append 
                if (ct > 1)
                    return "";
                else
                    sb.append(c);
            }
            
        }
        return sb.toString();
    }
}