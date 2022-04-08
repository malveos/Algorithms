/****

@author Omkar Malve


692. Top K Frequent Words

Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

***/
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>(k);
        Map<String, Integer> ctmap = new HashMap<>();
        for (String str : words)
            ctmap.put(str, ctmap.containsKey(str) ? ctmap.get(str) + 1 : 1);
        
        PriorityQueue<String> [] freq = new PriorityQueue[words.length];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new PriorityQueue<>();
        }
        
        //  add all word with count in the maxHeap
        for (String w : ctmap.keySet())
            freq[ctmap.get(w) - 1].add(w);
        
        // collect all in ans from last
        for (int  i = freq.length - 1; i >=0 && k > 0 ; i--) {
            while(k >0 && !freq[i].isEmpty()) {
                ans.add(freq[i].poll());
                k--;
            }
        }
        return ans;
    }
}