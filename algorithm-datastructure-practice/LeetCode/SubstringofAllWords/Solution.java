/***
30. Substring with Concatenation of All Words

You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.

You can return the answer in any order.

***/
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s.isEmpty())
            return new ArrayList<>();
    
        List<Integer> result = new ArrayList<>(); 
        Map<String, Integer> wordsMap = new HashMap<>();
        int noofwords = words.length;
        int wordL = words[0].length();
        int st = 0;
        
        // add all words with count in map
        for (String word: words)
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        
        for (; st <= s.length() - (noofwords * wordL); st++) {
            String sub = s.substring(st, st + (noofwords * wordL));
            if (containsAll(sub, wordsMap, wordL)) {
                result.add(st);
            }
        }
        
        return result;
    }
    
    private boolean containsAll(String sub, Map<String, Integer> wordsMap, int wordL) {
        Map<String, Integer> wordsMapCopy = new HashMap<>(wordsMap);
        
        int substringindex = 0;
        while(wordsMapCopy.size() > 0) {
            String word = sub.substring(substringindex, substringindex + wordL);
            if (!wordsMapCopy.containsKey(word))
                return false;
            
            wordsMapCopy.put(word, wordsMapCopy.get(word) - 1);
            if(wordsMapCopy.get(word) == 0)
                wordsMapCopy.remove(word);
            substringindex += wordL;
        }
        return wordsMapCopy.isEmpty();
    }
}