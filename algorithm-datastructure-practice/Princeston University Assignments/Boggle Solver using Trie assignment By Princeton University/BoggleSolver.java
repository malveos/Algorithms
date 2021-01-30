import edu.princeton.cs.algs4.SET;

public class BoggleSolver
{
    private static final int RADIX = 26;
    private Node root;
    private boolean[] marked;
    private char[] board;
    private int rows;
    private int cols;
    private CubeBoard[] adj;
    
    private static class Node {
        private boolean isWord;
        private Node[] next = new Node[RADIX];
    }
    
    private static class CubeBoard {
        private int n = 0;
        private int[] neighbours = new int[8]; // board is 4*4
    }

    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary) {
        if (null == dictionary) throw new IllegalArgumentException("Invalid Input");

        for (int i = 0; i < dictionary.length; i++) {
            addToTrie(dictionary[i]);
        }
    }

    private void addToTrie(String word) {
        if (null == word) throw new IllegalArgumentException("Invalid word............");
        root = addNode(root, word, 0);
    }

    private Node addNode(Node x, String word, int depth) {
        if (null == x) x = new Node();
        if (depth == word.length()) x.isWord = true;
        else {
            char c = word.charAt(depth);
            x.next[c - 'A'] = addNode(x.next[c - 'A'], word, depth + 1);
        }
        return x;
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word) {
        if (null == word) throw new IllegalArgumentException(" invalid input.....");
        if (!contains(word)) return 0;
        else if (word.length() < 3) return 0;
        else if (word.length() < 5) return 1;
        else if (word.length() == 5) return 2;
        else if (word.length() == 6) return 3;
        else if (word.length() == 7) return 5;
        else return 11;
    }
    
    private boolean contains(String word) {
        Node x = get(root, word, 0);
        if (x == null) return false;
        return x.isWord;
    }
    
    private Node get(Node x, String word, int depth) {
        if (null == x) return null;
        if (depth == word.length()) return x;
        return get(x.next[word.charAt(depth) - 'A'], word, depth + 1);
    }

    private void computeValidStringArrayAdj() {
        adj = new CubeBoard[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int idx = i * cols + j;
                adj[idx] = new CubeBoard();
                // a b c
                // d pv f
                // g h i
                if (i > 0) {
                    adj[idx].neighbours[adj[idx].n++] = (i - 1) * cols + j; // b
                    if (j < cols - 1) {
                        adj[idx].neighbours[adj[idx].n++] = (i - 1) * cols + j + 1; // c
                    }
                }
                if (i < rows - 1) {
                    adj[idx].neighbours[adj[idx].n++] = (i + 1) * cols + j; // h
                    if (j > 0) {
                        adj[idx].neighbours[adj[idx].n++] = (i + 1) * cols + j - 1; // g
                    }
                }
                if (j > 0) {
                    adj[idx].neighbours[adj[idx].n++] = i * cols + j - 1; // d
                    if (i > 0) {
                        adj[idx].neighbours[adj[idx].n++] = (i - 1) * cols + j - 1; // a
                    }
                }
                if (j < cols - 1) {
                    adj[idx].neighbours[adj[idx].n++] = i * cols + j + 1; // f
                    if (i < rows - 1) {
                        adj[idx].neighbours[adj[idx].n++] = (i + 1) * cols + j + 1; // i
                    }
                }
            }
        }
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        if (null == board) throw new IllegalArgumentException(" invalid input.........................");
        if (rows != board.rows() || cols != board.cols()) {
            rows = board.rows();
            cols = board.cols();
            marked = new boolean[rows * cols];
            this.board = new char[rows * cols];
            computeValidStringArrayAdj();
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.board[i * cols + j] = board.getLetter(i, j);
            }
        }
        return DFS();
    }

    private SET<String> DFS() {
        SET<String> words = new SET<>();
        for (int i = 0; i < rows * cols; i++) {
            DFS(i, new StringBuilder(), words, root);
        }
        return words;
    }

    private void DFS(int idx, StringBuilder prefix, SET<String> words, Node x) {
        char c = board[idx];
        Node nxt = x.next[c - 'A'];
        if (c == 'Q' && nxt != null)
            nxt = nxt.next['U' - 'A']; // QU comes together
        if (nxt == null) return;
        
        if (c == 'Q') prefix.append("QU");
        else prefix.append(c);

        if (prefix.length() > 2 && nxt.isWord) {
            words.add(prefix.toString());
        }
        
        marked[idx] = true;
        // check if string is in dictionary to add in words.
        for (int k = 0; k < adj[idx].n; k++) {
            int nextIdx = adj[idx].neighbours[k];
            if (!marked[nextIdx])
                DFS(nextIdx, new StringBuilder(prefix), words, nxt);
        }
        marked[idx] = false;
    }
}