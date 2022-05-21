/***

@Auhtor Omkar Malve

126. Word Ladder II

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

***/
class Solution {
   private int min = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);

        if (words.size() == 0 || !words.contains(endWord))
            return ans;

        Queue<Word> q = new LinkedList<>();
        q.add(new Word(beginWord));
        List<String> path = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            Set<String> visited = new HashSet<>();
            for(int i = 0; i < size; i++) {
                Word cur = q.poll();
                if (cur.name.equals(endWord)) {
                    ans.add(cur.path);
                } else {
                    List<String> neighbours = getNeighbours(words, cur.name);
                    for(String n : neighbours){
                        q.add(new Word(n, cur.path));
                        visited.add(n);
                    }
                }
            }            
            words.removeAll(visited);
        }
        return ans;
    }
    class Word {
        String name;
        List<String> path;
        public Word(String name) {
            this.name = name;
            this.path = new LinkedList<>();
            this.path.add(name);
        }
        public Word(String s, List<String> ls) {
            this.name = s;
            this.path = new LinkedList<>();
            this.path.addAll(ls);// add prevvious
            this.path.add(name);
        }
    }

    private List<String> getNeighbours(Set<String> words, String s) {
        List<String> ans = new ArrayList<>();
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < sb.length(); i++) {
            char oldChar = sb.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == oldChar) { // if same char continue
                    continue;
                }
                sb.setCharAt(i, c);
                String nw = sb.toString();
                if (words.contains(nw))
                    ans.add(nw);
            }
            sb.setCharAt(i, oldChar);
        }
        return ans;
    }
}