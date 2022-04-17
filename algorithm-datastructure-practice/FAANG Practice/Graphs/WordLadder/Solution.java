/**

@Author Omkar Malve

127. Word Ladder

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

***/
class Solution {
    public class Word {
        public String word;
        public int depth;
        Word(String w, int d) {
            this.word = w;
            this.depth = d;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> ls = new HashSet<>(wordList);
        if (ls.size() == 0 || !ls.contains(endWord)) {
            return 0;
        }
        // find all neaighbours per entry and then use BFS with DEpth like structure
        Queue<Word>  q = new LinkedList<>();
        q.add(new Word(beginWord, 1));

        while(!q.isEmpty()) {
            Word w = q.poll(); 
            List<String> adjs = getNeighbours(ls, w.word);
            //System.out.println("Neighbours of " + w.word + " : " + adjs);
            for (String s : adjs) {
                if (s.equals(endWord))
                    return w.depth + 1;
                q.add(new Word(s, w.depth + 1));
            }
        }
        return 0;
    }

    private List<String> getNeighbours(Set<String> words, String s) {
        List<String> ans = new LinkedList<>();
        
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < sb.length(); i++) {
            // replace every leffer with another letter and try if it exists
            char oldChar = sb.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == oldChar) { // if same char continue
                    continue;
                }
                sb.setCharAt(i, c);
                String nw = sb.toString();
                //System.out.println("Checking for word :" + nw);
                if (words.remove(nw))// Need remove for making it visited
                    ans.add(nw);
            }
            sb.setCharAt(i, oldChar);
        }
        return ans;
    }
}