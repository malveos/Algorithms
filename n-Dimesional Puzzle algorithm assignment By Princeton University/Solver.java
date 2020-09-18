import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

public class Solver {
    private class Move implements Comparable<Move> {
        private Move pre;
        private Board board;
        private int mCount = 0;

        public Move(Board board) {
            this.board = board;
        }

        public Move(Board board, Move pre) {
            this.board = board;
            this.pre = pre;
            this.mCount = pre.mCount + 1;
        }

        public int compareTo(Move move) {
            return (this.board.manhattan() - move.board.manhattan()) + (this.mCount - move.mCount);
        }
    }

    private Move lastMove;

    public Solver(Board initial) {
        if (null == initial) throw new IllegalArgumentException();
        MinPQ<Move> moves = new MinPQ<Move>();
        moves.insert(new Move(initial));

        MinPQ<Move> twinMoves = new MinPQ<Move>();
        twinMoves.insert(new Move(initial.twin()));

        while (true) {
            lastMove = expand(moves);
            if (lastMove != null || expand(twinMoves) != null) return;
        }
    }

    private Move expand(MinPQ<Move> moves) {
        if (moves.isEmpty()) return null;
        Move best = moves.delMin();
        if (best.board.isGoal()) return best;
        
        for (Board nei : best.board.neighbors()) {
            if (best.pre == null || !nei.equals(best.pre.board)) {
                moves.insert(new Move(nei, best));
            }
        }
        return null;
    }

    public boolean isSolvable() {
        return (lastMove != null);
    }

    public int moves() {
        return isSolvable() ? lastMove.mCount : -1;
    }

    public Iterable<Board> solution() {
        if (!isSolvable()) return null;

        Stack<Board> moves = new Stack<Board>();
        while (lastMove != null) {
            moves.push(lastMove.board);
            lastMove = lastMove.pre;
        }

        return moves;
    }
}